package com.avaliacao.demo.controller;


import com.avaliacao.demo.entity.PediProd;
import com.avaliacao.demo.entity.Pedido;
import com.avaliacao.demo.repository.PediProdRepository;
import com.avaliacao.demo.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@AllArgsConstructor
class PedidoController {

    private final PedidoService pedidoService;
    private final PediProdRepository pediProdRepository;

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido, @RequestParam List<Long> produtosIds, @RequestParam List<Integer> quantidades) {
        if (produtosIds.size() != quantidades.size()) {
            throw new IllegalArgumentException("Os arrays de produtos e quantidades devem ter o mesmo tamanho");
        }

        // Monta lista de itens
        List<PediProd> itens = new java.util.ArrayList<>();
        for (int i = 0; i < produtosIds.size(); i++) {
            PediProd item = new PediProd();
            item.setIdProduto(produtosIds.get(i));
            item.setQuantidade(quantidades.get(i));
            itens.add(item);
        }

        Pedido savedPedido = pedidoService.createPedido(pedido, itens);
        return savedPedido;
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.findAllPedidos();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Pedido> getByClienteId(@PathVariable Long clienteId) {
        return pedidoService.findByClienteId(clienteId);
    }

    @GetMapping("/data/{dataPedido}")
    public List<Pedido> getByDataPedido(@PathVariable String dataPedido) {
        return pedidoService.findByDataPedido(LocalDate.parse(dataPedido));
    }

    @GetMapping("/status/{status}")
    public List<Pedido> getByStatus(@PathVariable String status) {
        return pedidoService.findByStatus(status);
    }

    @PutMapping("/{id}/status")
    public Pedido updateStatus(@PathVariable Long id, @RequestBody String status) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setStatus(status);
        return pedidoService.updateStatus(pedido);
    }

    @GetMapping("/{id}/itens")
    public List<PediProd> getItensByPedidoId(@PathVariable Long id) {
        return pediProdRepository.findByIdPedido(id);
    }
}
