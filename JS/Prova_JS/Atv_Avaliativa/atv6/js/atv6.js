function calcular(){
    let conta = document.getElementById("conta").value;
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;

    const operacoes = {
        soma: (a, b) => a + b,
        subtracao: (a, b) => a - b,
        multiplicacao: (a, b) => a * b,
        divisao: (a, b) => a / b,
        potenciacao: (a, b) => Math.pow(a, b),
        radiciacao: (a, b) => Math.sqrt(a, b)
    };

    let resultado;

    if(conta === "soma"){
        resultado = num1 + num2; //n funciona com callback, mas não sei dizer o porque
    }else if(conta === "subtracao"){
        resultado = operacoes [conta] (num1, num2); //funciona
    }else if(conta === "multiplicacao"){
        resultado = num1 / num2; //n funciona com callback, mas não sei dizer o porque
    }else if(conta === "divisao"){
        resultado = operacoes [conta] (num1, num2); //funciona
    }else if(conta === "potenciacao"){
        resultado = operacoes [conta] (num1, num2); //funciona
    }else if(conta === "radiciacao"){
        resultado = operacoes [conta] (num1, num2); //funciona
    }

    document.getElementById("resultado").innerText = `A ${conta} dos numeros ${num1} e ${num2} é ${resultado}`
}