package com.medico.paciente.controller;

import com.medico.paciente.dto.ConsultaDTOResponse;
import com.medico.paciente.entity.Consulta;
import com.medico.paciente.repository.ConsultaRepository;
import com.medico.paciente.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    public ResponseEntity<ConsultaDTOResponse> criarConsulta(@RequestBody ConsultaDTOResponse consultaDTO) {
        Consulta consulta = consultaService.criarConsulta(consultaDTO);
        return ResponseEntity.ok(ConsultaDTOResponse.fromEntity(consulta));
    }

    @GetMapping("/paciente/{cpf}")
    public List<ConsultaDTOResponse> listarConsultasPorPaciente(@PathVariable String cpf) {
        return consultaService.listarConsultasPorPaciente(cpf);
    }

    @GetMapping
    public List<ConsultaDTOResponse> listarConsultas() {
        return consultaRepository.findAllComMedicoEPaciente().stream()
                .map(ConsultaDTOResponse::fromEntity)
                .sorted(Comparator.comparing(ConsultaDTOResponse::getDataHora).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("/medico/{id}")
    public List<ConsultaDTOResponse> listarPorMedico(@PathVariable Long id) {
        return consultaService.listarConsultasPorMedico(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
