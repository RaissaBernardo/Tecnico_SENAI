package com.avaliacao.demo.service;

import com.avaliacao.demo.entity.PediProd;
import com.avaliacao.demo.entity.Pedido;
import com.avaliacao.demo.repository.PediProdRepository;
import com.avaliacao.demo.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PediProdRepository pediProdRepository;
    private final EstoqueService estoqueService;

    @Transactional
    public Pedido createPedido(Pedido pedido, List<PediProd> itens) {
        for (PediProd item : itens) {
            estoqueService.updateStockAfterOrder(item.getIdProduto(), item.getQuantidade());
        }
        Pedido savedPedido = pedidoRepository.save(pedido);
        itens.forEach(item -> item.setIdPedido(savedPedido.getId()));
        pediProdRepository.saveAll(itens);
        return savedPedido;
    }

    public List<Pedido> findAllPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> findByClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public List<Pedido> findByDataPedido(LocalDate dataPedido) {
        return pedidoRepository.findByDataPedido(dataPedido);
    }

    public List<Pedido> findByStatus(String status) {
        return pedidoRepository.findByStatus(status);
    }

    public Pedido updateStatus(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}