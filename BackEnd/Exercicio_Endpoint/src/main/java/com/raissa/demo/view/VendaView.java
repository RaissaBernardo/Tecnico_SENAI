package com.raissa.demo.view;

import com.raissa.demo.banco.DataBaseCliente;
import com.raissa.demo.banco.DataBaseProduto;
import com.raissa.demo.controller.VendaController;
import com.raissa.demo.model.Produto;
import com.raissa.demo.model.Venda;
import com.raissa.demo.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaView {
    VendaController vd = new VendaController();
    DataBaseCliente dbClientes = new DataBaseCliente();
    DataBaseProduto dbProdutos = new DataBaseProduto();

    @GetMapping
    public List<Venda> getAllVendas() {
        return vd.pegarVendas();
    }

    @PostMapping
    public String addVendas(@RequestParam int idCliente, @RequestParam List<Integer> idsProdutos) {
        Cliente cliente = dbClientes.findOne(idCliente);
        List<Produto> produtos = new ArrayList<>();

        for (int idProd : idsProdutos) {
            Produto p = dbProdutos.findOne(idProd);
            if (p != null) {
                produtos.add(p);
            }
        }

        if (cliente == null) {
            return "Cliente não encontrado!";
        }
        if (produtos.isEmpty()) {
            return "Nenhum produto encontrado!";
        }

        Venda v = new Venda(null, LocalDate.now(), produtos, cliente);
        vd.adicionarVendas(v);

        return "Venda cadastrada com sucesso!";
    }

    @PutMapping
    public boolean updateVenda(@RequestBody Venda v) {
        return vd.atualizarVenda(v);
    }

    @DeleteMapping
    public boolean deleteProduto(@RequestParam int id) {
        return vd.removerVenda(id);
    }
}
