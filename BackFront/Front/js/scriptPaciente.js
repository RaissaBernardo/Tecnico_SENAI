document.addEventListener("DOMContentLoaded", () => {
  console.log("✅ DOM carregado");

  const btnBuscar = document.getElementById("btnBuscarConsultas");

  if (btnBuscar) {
    btnBuscar.addEventListener("click", buscarConsultasPaciente);
  } else {
    console.warn("❌ Botão de buscar não encontrado!");
  }
});

function buscarConsultasPaciente() {
  const cpf = document.getElementById("cpfPaciente").value;

  if (!cpf) {
    alert("Por favor, insira o CPF do paciente.");
    return;
  }

  console.log("🔎 Buscando consultas para CPF:", cpf);

  fetch(`http://localhost:8080/consultas/paciente/${cpf}`)
    .then(res => {
      if (!res.ok) {
        throw new Error("Erro ao buscar consultas");
      }
      return res.json();
    })
    .then(consultas => {
      console.log("📋 Consultas recebidas:", consultas);

      const tabela = document.getElementById("tabelaPaciente");
      tabela.innerHTML = "";

      if (consultas.length === 0) {
        tabela.innerHTML = "<tr><td colspan='2'>Nenhuma consulta encontrada.</td></tr>";
      } else {
        consultas.forEach(consulta => {
          const tr = document.createElement("tr");
          tr.innerHTML = `
            <td>${consulta.medicoNome}</td>
            <td>${new Date(consulta.dataHora).toLocaleString("pt-BR")}</td>
          `;
          tabela.appendChild(tr);
        });
      }

      document.getElementById("infoPaciente").style.display = "block";
    })
    .catch(err => {
      console.error("❌ Erro ao buscar consultas:", err);
      alert("Erro ao buscar consultas. Verifique o CPF e tente novamente.");
    });
}

function irParaAgendamento() {
  window.location.href = "agendar.html";
}
