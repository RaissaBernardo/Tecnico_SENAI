fetch("http://localhost:8080/usuario/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username: "Raissa Bernardo", password: "123456" })
})
.then(response => response.json())
.then(({ status, user }) => {
    if (status === "success") {
        // Salva as informações do usuário no localStorage
        localStorage.setItem("username", user.username);
        localStorage.setItem("email", user.email);
        localStorage.setItem("role", user.role);
        localStorage.setItem("photoUrl", user.photoUrl); // Salva a URL da foto
        
        // Redireciona para o dashboard
        window.location.href = "dashboard.html";
    } else {
        alert("Login falhou!");
    }
});
