package com.avaliacao.demo.service;

import com.avaliacao.demo.entity.Produto;
import com.avaliacao.demo.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAllProdutos() {
        return produtoRepository.findAll();
    }

    public List<Produto> findByTipoAco(String tipoAco) {
        return produtoRepository.findByTipoAco(tipoAco);
    }

    public List<Produto> findByEspecificacoes(String especificacoes) {
        return produtoRepository.findByEspecificacoesContaining(especificacoes);
    }

    public Produto updateProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}