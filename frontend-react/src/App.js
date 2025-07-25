import { useState } from 'react';
import './App.css';

const API_URL = process.env.NODE_ENV === 'development'
  ? "http://localhost:8091/midia" 
  : "http://backend.localhost/midia";  // Via Traefik em produção

function App() {
  const [titulo, setTitulo] = useState("");
  const [midia, setMidia] = useState(null);
  const [error, setError] = useState(null);

  const buscarMidia = async () => {
    try {
      const response = await fetch(`${API_URL}?t=${encodeURIComponent(titulo)}`, {
        credentials: 'include'
      });

      const contentType = response.headers.get("content-type");
      const rawText = await response.text();

      console.log("Resposta bruta da API:", rawText);

      if (!contentType || !contentType.includes("application/json")) {
        throw new Error("A resposta da API não está em formato JSON.");
      }

      const data = JSON.parse(rawText);

      if (data.Error) {
        throw new Error(data.Error);
      }

      setMidia(data);
      setError(null);

    } catch (err) {
      console.error("Erro ao buscar mídia:", err);
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

      {error && <div className="error-message">Erro: {error}</div>}

      {midia && (
        <div className="media-info">
          <h2>{midia.titulo}</h2>
          <img src={midia.poster} alt={`Poster de ${midia.titulo}`} width="200" />
          <p><strong>Gênero:</strong> {midia.genero}</p>
          <p><strong>Sinopse:</strong> {midia.sinopse}</p>
          <p><strong>Temporadas:</strong> {midia.totalDeTemporadas || "N/A"}</p>
          <p><strong>Avaliação:</strong> {midia.avaliacao}</p>
          <p><strong>Ano:</strong> {midia.ano}</p>
        </div>
      )}
    </div>
  );
}

export default App;
