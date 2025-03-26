function navigateTo(link) {
    window.location.href = link;
}
function changeLanguage(lang) {
    alert("Idioma selecionado: " + lang);
}

//chat
// Quando a página carregar, buscar as informações no localStorage
document.addEventListener("DOMContentLoaded", function() {
    const username = localStorage.getItem("username");
    const photoUrl = localStorage.getItem("photoUrl");

    // Atualiza o nome do usuário
    if (username) {
        document.getElementById("user-name").textContent = username;
    }

    // Atualiza a foto do usuário
    if (photoUrl) {
        document.getElementById("user-photo").src = photoUrl;
    }
});

