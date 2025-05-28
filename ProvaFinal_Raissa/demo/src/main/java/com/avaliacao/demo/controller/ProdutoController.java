package com.avaliacao.demo.controller;

import com.avaliacao.demo.entity.Produto;
import com.avaliacao.demo.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@AllArgsConstructor
class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAllProdutos();
    }

    @GetMapping("/tipo/{tipoAco}")
    public List<Produto> getByTipoAco(@PathVariable String tipoAco) {
        return produtoService.findByTipoAco(tipoAco);
    }

    @GetMapping("/especificacoes/{especificacoes}")
    public List<Produto> getByEspecificacoes(@PathVariable String especificacoes) {
        return produtoService.findByEspecificacoes(especificacoes);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoService.updateProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}