const calcularDesconto = (preco, desconto = 10) =>
  preco - preco * (desconto / 100);

const mostrarDesconto = () => {
  let preco = parseFloat(document.getElementById('preco').value);
  let desconto = parseFloat(document.getElementById('desconto').value) || 10;
  document.getElementById('resultadoDesconto').innerText =
    'Preço final: R$ ' + calcularDesconto(preco, desconto);
};
