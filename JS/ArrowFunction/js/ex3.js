const verificarPar = (numero) =>
  numero % 2 === 0 ? 'O número Par' : 'O número Ímpar';

const mostrarParidade = () => {
  let numero = parseInt(document.getElementById('numero').value);
  document.getElementById('resultadoParidade').innerText = verificarPar(numero);
};
