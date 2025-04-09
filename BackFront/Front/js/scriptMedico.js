let consultas = [];

function buscarConsultas() {
  const medicoId = document.getElementById('medicoId').value;
  if (!medicoId) {
    alert('Digite um ID válido');
    return;
  }

  fetch(`http://localhost:8080/consultas/medico/${medicoId}`)
    .then(res => {
      if (!res.ok) {
        throw new Error('Erro ao buscar as consultas');
      }
      return res.json();
    })
    .then(data => {
      consultas = data;
      mostrarConsultas(consultas);
    })
    .catch(err => {
      alert('Erro ao buscar consultas');
      console.error(err);
    });
}

function mostrarConsultas(lista) {
  const tabela = document.getElementById('tabelaConsultas');
  const corpo = document.getElementById('corpoTabela');
  const filtro = document.getElementById('filtro');

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
  const termo = document.getElementById('pesquisa').value.toLowerCase();
  const filtradas = consultas.filter(c =>
    c.nomePaciente.toLowerCase().includes(termo)
  );
  mostrarConsultas(filtradas);
}
