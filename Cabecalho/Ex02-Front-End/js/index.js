// Função de login
function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const remember = document.getElementById('remember').checked;

    // Recuperando a linguagem selecionada
    const language = document.getElementById('language').value;
    
    // Fazendo a requisição com o cabeçalho 'Accept-Language'
    fetch('http://localhost:8080/usuario/login', {
        method: 'POST',
        headers: { 
            'Content-Type': 'application/json',
            'Accept-Language': language // Enviando a linguagem selecionada
        },
        body: JSON.stringify({ username, password, remember })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert(data.message);  
        } else {
            setTimeout(function() {
                window.location.replace("dashboard.html"); // Redireciona para uma página interna após 5 segundos
              }, 5000);
        }
    })
    .catch(error => {
        alert("Erro ao fazer login");
        console.log(error);
    });
}

// Objetos de tradução para cada idioma
const translations = {
    en: {
        "login-title": "Login",
        "username-placeholder": "Username",
        "password-placeholder": "Password",
        "remember-label": "Remember me",
        "login-button": "Login",
        "signup-button": "Sign up"
    },
    pt: {
        "login-title": "Login",
        "username-placeholder": "Usuário",
        "password-placeholder": "Senha",
        "remember-label": "Lembrar minha senha",
        "login-button": "Entrar",
        "signup-button": "Cadastre-se"
    },
    es: {
        "login-title": "Iniciar sesión",
        "username-placeholder": "Usuario",
        "password-placeholder": "Contraseña",
        "remember-label": "Recordar mi contraseña",
        "login-button": "Ingresar",
        "signup-button": "Regístrate"
    }
};

// Função que altera o idioma da interface
function changeLanguage() {
    const language = document.getElementById("language").value;
    const selectedTranslations = translations[language];

    // Atualizando os textos da página com base nas traduções
    document.getElementById("login-title").innerText = selectedTranslations["login-title"];
    document.getElementById("username").placeholder = selectedTranslations["username-placeholder"];
    document.getElementById("password").placeholder = selectedTranslations["password-placeholder"];
    document.getElementById("remember-label").innerText = selectedTranslations["remember-label"];
    document.getElementById("login-button").innerText = selectedTranslations["login-button"];
    document.getElementById("signup-button").innerText = selectedTranslations["signup-button"];
}

// Função que inicializa o idioma ao carregar a página
document.addEventListener("DOMContentLoaded", function() {
    changeLanguage();  // Atualiza o idioma com base na seleção inicial
});
