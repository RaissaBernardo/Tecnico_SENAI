let soma = 0;

function adicionarNumero() {
  let input = document.getElementById('num').value;
  let num = parseInt(input);

  if (num === -1) {
    document.getElementById('resultado').innerHTML = `A soma dos números é: ${soma}`;
    return;
  } else {
    soma += num;
  }

  document.getElementById('num').value = ''; // Limpa o input para o próximo número
}
