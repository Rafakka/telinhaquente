import { useState } from 'react';
import './App.css';

const API_URL = "http://backend.localhost/midia";

function App() {
  const [titulo, setTitulo] = useState("");
  const [midia, setMidia] = useState(null);
  const [error, setError] = useState(null);

  const buscarMidia = async () => {
    try {
      const response = await fetch(`${API_URL}?t=${encodeURIComponent(titulo)}`);
      
      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.message || "Erro na requisição");
      }
      
      const data = await response.json();
      setMidia(data);
      setError(null);
    } catch (err) {
      setError(err.message);
      setMidia(null);
    }
  };

  return (
    <div className="App">
      <h1>Telinha Quente Online!</h1>
      <div className="search-container">
        <input
          type="text"
          value={titulo}
          onChange={(e) => setTitulo(e.target.value)}
          placeholder="Digite o nome do filme/série"
        />
        <button onClick={buscarMidia}>Buscar</button>
      </div>

      {error && <div className="error-message">{error}</div>}

      {midia && (
        <div className="media-info">
          <h2>{midia.titulo}</h2>
          <p>Temporadas: {midia.totalDeTemporadas || "N/A"}</p>
          <p>Avaliação: {midia.avaliacao}</p>
        </div>
      )}
    </div>
  );
}

export default App;