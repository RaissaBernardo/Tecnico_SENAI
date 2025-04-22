const calcularFatorial = (num) =>
  num === 0 || num === 1 ? 1 : num * calcularFatorial(num - 1);

const mostrarFatorial = () => {
  let numero = parseInt(document.getElementById('numero').value);
  document.getElementById(
    'resultado'
  ).innerText = `O fatorial de ${numero} é: ${calcularFatorial(numero)}`;
};
