class Aluno{
    #nome;
    #notas = [];

    constructor(nome, notas = []) {
        this.nome = nome;
        this.notas = notas;
    }

    #validarNotas(notas){
        let validarNotas = notas.every((nota) => {
            return ((nota >= 0) && (nota <= 10));})
        if(validarNotas === false){
            alert("As notas devem ser de 0 a 10");
            return false;
        }
        return true;
    }

    #media(notas){
        if(this.#notas.length === 0){
            alert('Divisão por 0 não é permitida');
            return 0;
        } else{
        let somaNotas = notas.reduce((acumulador, atual) => acumulador + atual, 0);
        let resultado = somaNotas / this.#notas.length; 
        return resultado.toFixed(2); 
        }
    }

    
    get nome(){
        return this.#nome;
    }
    set nome(nome){
        this.#nome = nome;
    }

    get notas(){
        return this.#notas;
    }
    set notas(notas){
        this.#notas
    }


}

 