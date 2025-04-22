function calcular(compra, imposto) {
  let resultado = compra * (imposto / 100);

  document.getElementById('resultado1').innerText =
    'Valor total do imposto: R$ ' + resultado.toFixed(2);
}

function calcularImposto(compra, imposto, calcular) {
  calcular(compra, imposto);
}

const totalPago = (compra, imposto) => {
  const impostoCalculado = compra * (imposto / 100);
  return compra + impostoCalculado;
};

const mostrarTotal = () => {
  let valorCompra = parseFloat(document.getElementById('compra').value);
  let valorImposto = parseFloat(document.getElementById('imposto').value);

  calcularImposto(valorCompra, valorImposto, calcular);
  let valorTotal = totalPago(valorCompra, valorImposto);

  document.getElementById('resultado').innerText =
    'Valor total da compra: R$ ' + valorTotal.toFixed(2);
};
