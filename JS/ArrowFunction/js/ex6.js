const calcularImposto = (compra, imposto) => compra * (imposto / 100);

const totalPago = (compra, imposto) => {
  const impostoCalculado = calcularImposto(compra, imposto);
  return compra + impostoCalculado;
};

const mostrarTotal = () => {
  let valorCompra = parseFloat(document.getElementById('compra').value);
  let valorImposto = parseFloat(document.getElementById('imposto').value);

  let impostoCalculado = calcularImposto(valorCompra, valorImposto);
  let valorTotal = totalPago(valorCompra, valorImposto);

  document.getElementById('resultado').innerText =
    'Valor total do imposto: R$ ' + impostoCalculado.toFixed(2) +
    '\n' + 'Valor total da compra: R$ ' + valorTotal.toFixed(2);
};
