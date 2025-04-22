const calcularQuadrado = num => num * num;

const aplicarOperacao = (num, operacao) => operacao(num);

const calcular = () => {
    let numero = parseFloat(document.getElementById("numero").value);
    let resultado = aplicarOperacao(numero, calcularQuadrado);
    document.getElementById("resultado").innerText = `O quadrado de ${numero} é: ${resultado}`;
};
