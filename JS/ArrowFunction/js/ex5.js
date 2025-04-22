const compararNumero = (num1, num2) => num1 > num2;

const maiorNumero = (num1, num2, num3) => {
  if (compararNumero(num1, num2) && compararNumero(num1, num3)) {
    return num1;
  } else if (compararNumero(num2, num1) && compararNumero(num2, num3)) {
    return num2;
  } else {
    return num3;
  }
};

const mostrarMaiorNumero = () => {
  const num1 = parseFloat(document.getElementById('num1').value);
  const num2 = parseFloat(document.getElementById('num2').value);
  const num3 = parseFloat(document.getElementById('num3').value);

  const maior = maiorNumero(num1, num2, num3);
  document.getElementById('resultado').innerText = `O maior número é: ${maior}`;
};
