import logo from './logo.svg';
import './App.css';

const API_URL = process.env.REACT_APP_BACKEND_URL || "http://localhost:8080";

export async function fetchMidia(titulo) {
  const response = await fetch(`${API_URL}/midia?t=${titulo}`);
  if (!response.ok) {
    throw new Error("Erro na requisição");
  }
  return response.json();
}

function App() {
  return (
    <div>
      <h1> Telinha Quente Online!</h1>
      <p>Integração com Jenkins e Docker feita com sucesso.</p>
    </div>
  );
}

export default App;
