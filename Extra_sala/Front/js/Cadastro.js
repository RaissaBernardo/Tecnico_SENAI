document.getElementById("form-aviso").addEventListener("submit", async (e) => {
    e.preventDefault();
    const aviso = {
      titulo: document.getElementById("titulo").value,
      descricao: document.getElementById("descricao").value,
      autor: document.getElementById("autor").value
    };

    await fetch("http://localhost:8080/avisos", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(aviso)
    });

    window.location.href = "mural.html";
  });