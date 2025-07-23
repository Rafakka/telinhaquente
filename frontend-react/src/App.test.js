import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});

import React, { useEffect, useState } from "react";
import { fetchMidia } from "./api";

function App() {
  const [midia, setMidia] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchMidia("batman")
      .then(data => setMidia(data))
      .catch(err => setError(err.message));
  }, []);

  if (error) return <div>Erro: {error}</div>;
  if (!midia) return <div>Carregando...</div>;

  return (
    <div>
      <h1>{midia.titulo}</h1>
      <p>{midia.descricao}</p>
      {/* e mais campos */}
    </div>
  );
}

export default App;