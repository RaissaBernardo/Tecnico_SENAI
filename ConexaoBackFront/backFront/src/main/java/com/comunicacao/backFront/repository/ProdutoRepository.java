package com.comunicacao.backFront.repository;

import com.comunicacao.backFront.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
