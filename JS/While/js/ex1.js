function mostrarTabuada() {
  const num = parseInt(document.getElementById('numero').value);
  let resultado = '';

  for (let i = 1; i <= 10; i++) {
    resultado += `${num} x ${i} = ${num * i} <br>`;
  }

  document.getElementById('resultado').innerHTML = resultado;
}
