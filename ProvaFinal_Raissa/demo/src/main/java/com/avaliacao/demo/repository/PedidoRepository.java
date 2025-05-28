package com.avaliacao.demo.repository;

import com.avaliacao.demo.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByDataPedido(LocalDate dataPedido);
    List<Pedido> findByStatus(String status);
}

