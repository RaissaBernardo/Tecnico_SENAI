async function carregarAvisos() {
      const res = await fetch("http://localhost:8080/avisos");
      const avisos = await res.json();
      const mural = document.getElementById("mural");
      mural.innerHTML = "";

      avisos.forEach(aviso => {
        const card = document.createElement("div");
        card.className = "aviso";
        card.innerHTML = `
          <h3>${aviso.titulo}</h3>
          <p>${aviso.descricao}</p>
          <small><strong>Autor:</strong> ${aviso.autor} | <strong>Data:</strong> ${aviso.dataDePublicacao}</small>
          <div class="botoes">
            <button class="editar" onclick="editar(${aviso.id})">Editar</button>
            <button class="excluir" onclick="excluir(${aviso.id})">Excluir</button>
          </div>
        `;
        mural.appendChild(card);
      });
    }
    
    async function excluir(id) {
        await fetch(`http://localhost:8080/avisos/${id}`, { method: "DELETE" });
        carregarAvisos();
      }
  
      function editar(id) {
        window.location.href = `editar.html?id=${id}`;
      }
  
      carregarAvisos();