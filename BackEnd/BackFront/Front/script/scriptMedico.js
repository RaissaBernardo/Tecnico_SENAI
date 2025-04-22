  document.addEventListener('DOMContentLoaded', () => {
    main();
  });

  function main() {
    const botaoBuscar = document.getElementById('botaoBuscar');
    const campoPesquisa = document.getElementById('pesquisa');

    if (!botaoBuscar || !campoPesquisa) {
      console.error('Elementos principais não encontrados na DOM. Confere aí, campeão.');
      return;
    }

    botaoBuscar.addEventListener('click', buscarConsultas);
    campoPesquisa.addEventListener('input', filtrarConsultas);
  }

  let consultas = [];

  async function buscarConsultas() {
    const inputMedico = document.getElementById('medicoId');
    if (!inputMedico) {
      alert('Campo de ID do médico não encontrado!');
      console.warn('Elemento com id "medicoId" não encontrado na DOM.');
      return;
    }

    const medicoId = inputMedico.value.trim();
    if (!medicoId) {
      alert('Digite um ID válido');
      return;
    }

    try {
      const resposta = await fetch(`http://localhost:8080/consultas/medico/${medicoId}`);
      if (!resposta.ok) throw new Error('Erro ao buscar as consultas');

      const data = await resposta.json();
      consultas = data;
      mostrarConsultas(consultas);
    } catch (err) {
      alert('Erro ao buscar consultas');
      console.error('[Erro buscarConsultas]:', err);
    }
  }

  function mostrarConsultas(lista) {
    const tabela = document.getElementById('tabelaConsultas');
    const corpo = document.getElementById('corpoTabela');
    const filtro = document.getElementById('filtro');

    if (!tabela || !corpo || !filtro) {
      console.error('Elementos da tabela não encontrados. Bora revisar o HTML.');
      return;
    }

    corpo.innerHTML = ''; // limpa tabela

    if (lista.length === 0) {
      corpo.innerHTML = '<tr><td colspan="2">Nenhuma consulta encontrada</td></tr>';
    } else {
      lista.forEach(c => {
        const linha = document.createElement('tr');
        linha.innerHTML = `
          <td>${c.nomePaciente}</td>
          <td>${new Date(c.dataHora).toLocaleString('pt-BR')}</td>
        `;
        corpo.appendChild(linha);
      });
    }

    tabela.style.display = 'table';
    filtro.style.display = 'block';
  }

  function filtrarConsultas() {
    const inputPesquisa = document.getElementById('pesquisa');
    if (!inputPesquisa) {
      console.warn('Campo de pesquisa não encontrado');
      return;
    }

    const termo = inputPesquisa.value.toLowerCase();
    const filtradas = consultas.filter(c =>
      c.nomePaciente.toLowerCase().includes(termo)
    );
    mostrarConsultas(filtradas);
  }

