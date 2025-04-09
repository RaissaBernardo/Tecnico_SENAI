async function buscarConsultasPaciente() {
  const inputCPF = document.getElementById("cpfPaciente");
  const tabela = document.getElementById("tabelaPaciente");
  const infoPaciente = document.getElementById("infoPaciente");

  if (!inputCPF || !tabela || !infoPaciente) {
    console.error("❌ Elementos do DOM não encontrados!");
    return;
  }

  const cpf = inputCPF.value.trim();

  if (!cpf) {
    alert("Por favor, insira o CPF do paciente.");
    return;
  }

  console.log("🔎 Buscando consultas para CPF:", cpf);

  try {
    const res = await fetch(`http://localhost:8080/consultas/paciente/${cpf}`);

    if (!res.ok) {
      throw new Error(`Erro ao buscar consultas: ${res.status}`);
    }

    const consultas = await res.json();
    console.log("📋 Consultas recebidas:", consultas);

    renderizarConsultasPaciente(consultas, tabela, infoPaciente);
  } catch (err) {
    console.error("❌ Erro ao buscar consultas:", err);
    alert("Erro ao buscar consultas. Verifique o CPF e tente novamente.");
  }
}

function renderizarConsultasPaciente(consultas, tabela, infoPaciente) {
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

  infoPaciente.style.display = "block";
}

function irParaAgendamento() {
  window.location.href = "agendar.html";
}

function main() {
  console.log("✅ DOM carregado");

  const btnBuscar = document.getElementById("btnBuscarConsultas");

  if (btnBuscar) {
    btnBuscar.addEventListener("click", buscarConsultasPaciente);
  } else {
    console.warn("❌ Botão de buscar não encontrado!");
  }
}

document.addEventListener("DOMContentLoaded", main);
