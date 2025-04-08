package com.crud.raissa.controller;

import com.crud.raissa.entity.Produto;
import com.crud.raissa.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}
