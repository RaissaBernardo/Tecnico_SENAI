class Aluno{
  


    constructor(nome, nota1, nota2, nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    calcularMedia() {
        return ((this.nota1 + this.nota2 + this.nota3) / 3).toFixed(2);
    }
}

function cadastrarAluno() {
    let nome = document.getElementById("nome").value;
    let nota1 = parseFloat(document.getElementById("nota1").value);
    let nota2 = parseFloat(document.getElementById("nota2").value);
    let nota3 = parseFloat(document.getElementById("nota3").value);

    if (nome === "" || isNaN(nota1) || isNaN(nota2) || isNaN(nota3) || nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || nota3 < 0 || nota3 > 10) {
        alert("Erro! Digite um nome válido e notas entre 0 e 10.");
        return;
    }

    let aluno = new Aluno(nome, nota1, nota2, nota3);
    document.getElementById("resultado").innerText = `${aluno.nome} - Média: ${aluno.calcularMedia()}`;
}