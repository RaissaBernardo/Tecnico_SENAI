package com.crud.raissa.controller;

import com.crud.raissa.entity.Venda;
import com.crud.raissa.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping
    public List<Venda> listar() {
        return vendaRepository.findAll();
    }

    @PostMapping
    public Venda salvar(@RequestBody Venda venda) {
        return vendaRepository.save(venda);
    }
}
