import React, {useState} from "react";

function BuscarMidia () {
    const [titulo, setTitulo] = useState('');
    const [dados, setDados] = useState(null);
    const [erro, setErro] = useState(null);

    const BuscarMidia = async (e) => {
        e.preventDefault();

        try {
            setErro(null);
            setDados(null);

        const response = await
        fetch(http://localhost:8082/midia?t=${encodeURIComponet(titulo)});
        if (!response.ok){
            throw new Error('Erro ao buscar midia');
            }
        
        const json = await response.json();
        setDados(json);
        } catch(err) {
                setErro(err.mensage);
                }
            }
        };
        
        return (
        <div>
            <h2>
                Buscar Filme ou Serie
            </h2>
            <form onSubmit={BuscarMidia}>
                <input
                type="text"
                value={titulo}
                onChange={(e) => setTitulo(e.target.value)}
                placeholder="Digite o nome da midia"
                required
                />
                <button type="Submit">Buscar</button>
            </form>
            {erro && <p style={{color:red}}>{erro}</p>}

            {dados && (
                <div>
                    <h3>{dados.titulo}</h3>
                    <p>Total de Temporadas:
                {dados.totalDeTemporadas || 'N/A'}</p>
                <p>Avaliação IMDB:{dados.avaliacao}</p>
                </div>
            )}
        </div>
        );
    }

    export default BuscarMidia;
   