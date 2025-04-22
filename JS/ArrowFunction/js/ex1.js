const mostrarSaudacao = () => {
    let nomeDigitado = document.getElementById("nome").value;
    let mensagemDigitada = document.getElementById("mensagem").value;

    let resultadoTexto = `Olá, ${nomeDigitado || "Visitante"}! ${mensagemDigitada || "Bem-vindo!"}`;

    document.getElementById("resultado").textContent = resultadoTexto;
};

document.getElementById("botaoSaudacao").addEventListener("click", mostrarSaudacao);