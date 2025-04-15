const id = new URLSearchParams(window.location.search).get("id");

    async function carregarAviso() {
      const res = await fetch(`http://localhost:8080/avisos/${id}`);
      const aviso = await res.json();
      document.getElementById("titulo").value = aviso.titulo;
      document.getElementById("descricao").value = aviso.descricao;
      document.getElementById("autor").value = aviso.autor;
    }

    document.getElementById("form-editar").addEventListener("submit", async (e) => {
      e.preventDefault();
      const aviso = {
        titulo: document.getElementById("titulo").value,
        descricao: document.getElementById("descricao").value,
        autor: document.getElementById("autor").value
      };

      await fetch(`http://localhost:8080/avisos/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(aviso)
      });

      window.location.href = "mural.html";
    });

    carregarAviso();