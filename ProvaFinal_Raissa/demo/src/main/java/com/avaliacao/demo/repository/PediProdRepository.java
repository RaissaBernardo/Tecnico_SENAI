package com.avaliacao.demo.repository;

import com.avaliacao.demo.entity.PediProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PediProdRepository extends JpaRepository<PediProd, Long> {
    List<PediProd> findByIdPedido(Long idPedido);
}
