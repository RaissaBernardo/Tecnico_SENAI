package com.medico.paciente.service;

import com.medico.paciente.dto.ConsultaDTO;
import com.medico.paciente.entity.Consulta;
import com.medico.paciente.entity.Medico;
import com.medico.paciente.entity.Paciente;
import com.medico.paciente.repository.ConsultaRepository;
import com.medico.paciente.repository.MedicoRepository;
import com.medico.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // Criar consulta com base no DTO (ligando médico e paciente existentes)
    public Consulta criarConsulta(ConsultaDTO consultaDTO) {
        Medico medico = medicoRepository.findById(consultaDTO.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado com ID: " + consultaDTO.getMedicoId()));

        Paciente paciente = pacienteRepository.findByCpf(consultaDTO.getPacienteCpf())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com CPF: " + consultaDTO.getPacienteCpf()));

        Consulta consulta = new Consulta();
        consulta.setDataHora(consultaDTO.getDataHora());
        consulta.setObservacoes(consultaDTO.getObservacoes());
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);

        return consultaRepository.save(consulta);
    }

    // Listar todas as consultas
    public List<ConsultaDTO> listarConsultas() {
        return consultaRepository.findAllComMedicoEPaciente().stream()
                .map(ConsultaDTO::fromEntity)
                .sorted(Comparator.comparing(ConsultaDTO::getDataHora).reversed())
                .collect(Collectors.toList());
    }

    // Buscar consulta por ID
    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + id));
    }

    // Deletar consulta
    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    // Atualizar uma consulta existente
    public Consulta atualizarConsulta(Long id, ConsultaDTO consultaDTO) {
        Consulta consultaExistente = buscarPorId(id);

        Medico medico = medicoRepository.findById(consultaDTO.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado com ID: " + consultaDTO.getMedicoId()));

        Paciente paciente = pacienteRepository.findByCpf(consultaDTO.getPacienteCpf())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com CPF: " + consultaDTO.getPacienteCpf()));

        consultaExistente.setDataHora(consultaDTO.getDataHora());
        consultaExistente.setObservacoes(consultaDTO.getObservacoes());
        consultaExistente.setMedico(medico);
        consultaExistente.setPaciente(paciente);

        return consultaRepository.save(consultaExistente);
    }

    public List<ConsultaDTO> listarConsultasPorMedico(Long medicoId) {
        return consultaRepository.findAllComMedicoEPaciente().stream()
                .filter(c -> c.getMedico().getId().equals(medicoId))
                .map(ConsultaDTO::fromEntity)
                .sorted(Comparator.comparing(ConsultaDTO::getDataHora).reversed())
                .collect(Collectors.toList());
    }

    public List<ConsultaDTO> listarConsultasPorPaciente(String cpf) {
        List<Consulta> consultas = consultaRepository.findByPacienteCpf(cpf);
        return consultas.stream()
                .map(ConsultaDTO::fromEntity)
                .sorted(Comparator.comparing(ConsultaDTO::getDataHora).reversed())
                .collect(Collectors.toList());
    }

}
