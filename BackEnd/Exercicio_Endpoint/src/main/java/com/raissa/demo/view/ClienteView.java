package com.raissa.demo.view;

import com.raissa.demo.controller.ClienteController;
import com.raissa.demo.model.Cliente;
import com.raissa.demo.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cliente") //ja add pra td mundo
public class ClienteView {
    ClienteController cc = new ClienteController();

    @GetMapping
    public List<Cliente> getCliente() {
        return cc.pegarOsClientes();
    }

    @PostMapping
    public void addCliente (@RequestBody Cliente c){
        cc.adicionarCliente(c);
    }

    @PutMapping
    public boolean updateCliente(@RequestBody Cliente c) {
        return cc.atualizarProduto(c);
    }

    @DeleteMapping
    public boolean deleteCliente(@RequestBody int id) {
        return cc.removerProduto(id);
    }

}
