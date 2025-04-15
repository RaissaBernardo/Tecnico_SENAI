function numero(){
    let numero1 = parseInt(document.getElementById("num1").value);
    let numero2 = parseInt(document.getElementById("num2").value);

    if(numero1 === numero2){
        alert('Escolha dois números diferentes');
    }

    let menorNum = Math.min(numero1, numero2);
    let maiorNum = Math.max(numero1, numero2);

    if(menorNum % 5 !== 0){
        menorNum += (5 -(menorNum % 5));
    }

    let quantidade = 0;

    for(let i = menorNum; i <= maiorNum; i += 5){
         quantidade++;
    }

    document.getElementById("resposta").innerText = `A quantidade de multiplos de 5 entre os numeros ${numero1} e ${numero2} é ${quantidade}`
}