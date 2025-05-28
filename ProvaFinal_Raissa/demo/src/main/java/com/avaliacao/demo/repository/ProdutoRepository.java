package com.avaliacao.demo.repository;

import com.avaliacao.demo.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByTipoAco(String tipoAco);
    List<Produto> findByEspecificacoesContaining(String especificacoes);
}
