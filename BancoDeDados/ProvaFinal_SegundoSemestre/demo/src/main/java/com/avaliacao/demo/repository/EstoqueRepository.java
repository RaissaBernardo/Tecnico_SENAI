package com.avaliacao.demo.repository;

import com.avaliacao.demo.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    List<Estoque> findByTipoMaterial(String tipoMaterial);
    List<Estoque> findByIdProduto(Long idProduto);
}
