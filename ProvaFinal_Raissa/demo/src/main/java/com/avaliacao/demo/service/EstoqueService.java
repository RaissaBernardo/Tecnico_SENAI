package com.avaliacao.demo.service;

import com.avaliacao.demo.entity.Estoque;
import com.avaliacao.demo.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;

    public Estoque createEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public List<Estoque> findAllEstoque() {
        return estoqueRepository.findAll();
    }

    public List<Estoque> findByTipoMaterial(String tipoMaterial) {
        return estoqueRepository.findByTipoMaterial(tipoMaterial);
    }

    public List<Estoque> findByIdProduto(Long idProduto) {
        return estoqueRepository.findByIdProduto(idProduto);
    }

    public Estoque updateEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    @Transactional
    public void updateStockAfterOrder(Long idProduto, Integer quantidade) {
        Estoque estoque = estoqueRepository.findByIdProduto(idProduto).stream().findFirst().orElseThrow(() -> new RuntimeException("Estoque not found for product"));
            estoque.setQuantidadeAtual(estoque.getQuantidadeAtual() - quantidade);
            estoqueRepository.save(estoque);
        }
    }
