package com.extra.sala.controller;

import com.extra.sala.entity.Aviso;
import com.extra.sala.service.AvisoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/avisos")
@CrossOrigin("*")
public class AvisoController {
    private final AvisoService service;

    public AvisoController(AvisoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aviso> listar() {
        return service.listar();
    }

    @PostMapping
    public Aviso salvar(@RequestBody Aviso aviso) {
        aviso.setDataDePublicacao(LocalDate.now());
        return service.salvar(aviso);
    }

    @PutMapping("/{id}")
    public Aviso editar(@PathVariable Long id, @RequestBody Aviso aviso) {
        return service.editar(id, aviso);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/{id}")
    public Aviso buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
