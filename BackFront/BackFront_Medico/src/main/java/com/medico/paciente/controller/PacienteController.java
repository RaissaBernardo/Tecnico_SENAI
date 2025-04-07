package com.medico.paciente.controller;

import com.medico.paciente.dto.PacienteDTO;
import com.medico.paciente.entity.Paciente;
import com.medico.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Paciente> criar(@RequestBody PacienteDTO pacienteDTO) {
        return new ResponseEntity<>(pacienteService.criarPaciente(pacienteDTO), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.atualizar(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
    }
}
