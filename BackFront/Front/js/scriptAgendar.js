window.onload = function () {
  carregaMedicos();
};

function carregaMedicos() {
  fetch('http://localhost:8080/medicos')
    .then((res) => {
      if (!res.ok) throw new Error('Erro ao buscar médicos');
      return res.json();
    })
    .then((medicos) => {
      const select = document.getElementById('medicoSelect');
      medicos.forEach((medico) => {
        const option = document.createElement('option');
        option.value = medico.cpf; // agora usa CPF
        option.textContent = `${medico.nome} - ${medico.especialidade}`;
        select.appendChild(option);
      });
    })
    .catch((err) => {
      console.error('❌ Erro ao carregar médicos:', err);
      document.getElementById('mensagem').textContent =
        'Erro ao carregar médicos.';
    });
}

function agendarConsulta() {
  const cpfPaciente = document.getElementById('cpfPaciente').value.trim();
  const cpfMedico = document.getElementById('medicoSelect').value;
  const dataHora = document.getElementById('dataHora').value;
  const observacoes = document.getElementById('observacoes').value;
  const mensagem = document.getElementById('mensagem');

  if (!cpfPaciente || !cpfMedico || !dataHora) {
    mensagem.textContent = '⚠️ Preencha todos os campos obrigatórios.';
    return;
  }

  const consulta = {
    pacienteCpf: cpfPaciente,
    medicoCpf: cpfMedico,
    dataHora,
    observacoes,
  };

  console.log('📤 Enviando agendamento:', consulta);

  fetch('http://localhost:8080/consultas', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(consulta),
  })
    .then((res) => {
      if (!res.ok) throw new Error('Erro ao agendar consulta');
      return res.json();
    })
    .then(() => {
      mensagem.textContent = '✅ Consulta agendada com sucesso!';
      document.getElementById('formAgendamento').reset();
    })
    .catch((err) => {
      console.error('❌ Erro ao agendar:', err);
      mensagem.textContent =
        '❌ Não foi possível agendar. Verifique os dados e tente novamente.';
    });
}
