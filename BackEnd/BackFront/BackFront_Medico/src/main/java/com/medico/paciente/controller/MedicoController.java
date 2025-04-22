package com.medico.paciente.controller;

import com.medico.paciente.dto.MedicoDTO;
import com.medico.paciente.entity.Medico;
import com.medico.paciente.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> listarTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Medico> criar(@RequestBody MedicoDTO medicoDTO) {
        return new ResponseEntity<>(medicoService.criarMedico(medicoDTO), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable Long id, @RequestBody Medico medico) {
        return medicoService.atualizar(id, medico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        medicoService.deletar(id);
    }
}
