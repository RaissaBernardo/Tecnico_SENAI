function validar(){
    let resposta = document.getElementById("resposta")  ;

    try {
        let idade = parseInt(document.getElementById("idade").value);

        if (isNaN(idade)) {
            console.log("entrei");
            throw new Error ( resposta.textContent = "A idade deve ser um número.");
        } else if (idade < 0) {
            throw new Error( resposta.textContent = "A idade não pode ser negativa.");
        }else if (idade < 18) {
            throw new Error( resposta.textContent = "Acesso negado. Você deve ter 18 anos ou mais.");
        } else if(idade > 120){
            throw new Error( resposta.textContent = "Você deve digitar um idade válida");
        } else{
            resposta.textContent = "Acesso permitido. Bem-vindo(a)!";
        }
    } catch (erro) {
        resposta.textContent = erro.message;
    }
}