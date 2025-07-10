package com.avaliacao.demo.controller;


import com.avaliacao.demo.entity.Estoque;
import com.avaliacao.demo.service.EstoqueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
@AllArgsConstructor
class EstoqueController {
    private final EstoqueService estoqueService;

    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque) {
        return estoqueService.createEstoque(estoque);
    }

    @GetMapping
    public List<Estoque> getAllEstoque() {
        return estoqueService.findAllEstoque();
    }

    @GetMapping("/tipo/{tipoMaterial}")
    public List<Estoque> getByTipoMaterial(@PathVariable String tipoMaterial) {
        return estoqueService.findByTipoMaterial(tipoMaterial);
    }

    @GetMapping("/produto/{idProduto}")
    public List<Estoque> getByIdProduto(@PathVariable Long idProduto) {
        return estoqueService.findByIdProduto(idProduto);
    }

    @PutMapping("/{id}")
    public Estoque updateEstoque(@PathVariable Long id, @RequestBody Estoque estoque) {
        estoque.setId(id);
        return estoqueService.updateEstoque(estoque);
    }
}
