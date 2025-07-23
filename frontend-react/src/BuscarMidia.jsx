import React, { useState } from "react";

function BuscarMidia() {
    const [titulo, setTitulo] = useState('');
    const [dados, setDados] = useState(null);
    const [erro, setErro] = useState(null);

    const buscarMidia = async (e) => {
        e.preventDefault();

        try {
            setErro(null);
            setDados(null);

            const response = await fetch("http://telinha-backend:8085/midia?t=" + encodeURIComponent(titulo));
            if (!response.ok) {
                throw new Error('Erro ao buscar mídia');
            }

            const json = await response.json();
            setDados(json);
        } catch (err) {
            setErro(err.message);
        }
    };

    return (
        <div>
            <h2>Buscar Filme ou Série</h2>
            <form onSubmit={buscarMidia}>
                <input
                    type="text"
                    value={titulo}
                    onChange={(e) => setTitulo(e.target.value)}
                    placeholder="Digite o nome da mídia"
                    required
                />
                <button type="submit">Buscar</button>
            </form>

            {erro && <p style={{ color: 'red' }}>{erro}</p>}

            {dados && (
                <div>
                    <h3>{dados.titulo}</h3>
                    <p>Total de Temporadas: {dados.totalDeTemporadas || 'N/A'}</p>
                    <p>Avaliação IMDB: {dados.avaliacao}</p>
                </div>
            )}
        </div>
    );
}

export default BuscarMidia;

   