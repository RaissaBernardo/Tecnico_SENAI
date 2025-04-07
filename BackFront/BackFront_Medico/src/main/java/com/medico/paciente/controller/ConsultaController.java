package com.medico.paciente.controller;

import com.medico.paciente.dto.ConsultaDTO;
import com.medico.paciente.entity.Consulta;
import com.medico.paciente.repository.ConsultaRepository;
import com.medico.paciente.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    public ResponseEntity<ConsultaDTO> criarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        Consulta consulta = consultaService.criarConsulta(consultaDTO);
        return ResponseEntity.ok(ConsultaDTO.fromEntity(consulta));
    }

    @GetMapping("/paciente/{cpf}")
    public List<ConsultaDTO> listarConsultasPorPaciente(@PathVariable String cpf) {
        return consultaService.listarConsultasPorPaciente(cpf);
    }

    @GetMapping
    public List<ConsultaDTO> listarConsultas() {
        return consultaRepository.findAllComMedicoEPaciente().stream()
                .map(ConsultaDTO::fromEntity)
                .sorted(Comparator.comparing(ConsultaDTO::getDataHora).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("/medico/{id}")
    public List<ConsultaDTO> listarPorMedico(@PathVariable Long id) {
        return consultaService.listarConsultasPorMedico(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
