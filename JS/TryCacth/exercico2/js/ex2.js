function solicitar(){
    let resp = document.getElementById("resp");

    try{
        let nome = document.getElementById("nome").value;
        let idade = parseInt(document.getElementById("idade").value);
        let valor = parseFloat(document.getElementById("valor").value);

        if(idade < 18){
            throw new Error(resp.textContent = "Você não é maior de idade. Portanto não tem idade o suficiente para realizar o empréstimo.");
        }else if (idade > 70){
            throw new Error(resp.textContent = "Infelizmente, o senhor (a) passou da idade permitida para realizar um empréstimo.")
        }else if(valor < 100.00){
            throw new Error(resp.textContent = "O valor deve ser maior que R$100,00");
        }else if(valor > 30000.00){ 
            throw new Error(resp.textContent = "O valor de empréstimo é muito alta.");
        }else if(!isNaN(nome)) {
            throw new Error("Nome não pode ser um número.");
        }else{
            resp.textContent = "EMPRÉSTIMO ACEITO";
        }
        
    }catch(error){
        resp.textContent = error.message;
    }
}