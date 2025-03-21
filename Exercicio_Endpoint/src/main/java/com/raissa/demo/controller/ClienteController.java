package com.raissa.demo.controller;


import com.raissa.demo.banco.DataBaseCliente;
import com.raissa.demo.model.Cliente;
import com.raissa.demo.model.Produto;

import java.util.List;

public class ClienteController {

    DataBaseCliente bcC = new DataBaseCliente();

    public List<Cliente> pegarOsClientes(){
        return bcC.findAll();
    }

    public void adicionarCliente(Cliente c) {
        bcC.insert(c);
    }

    public boolean atualizarProduto(Cliente c) {
        return bcC.update(c);
    }

    // REMOVE
    public boolean removerProduto(int id) {
        return bcC.delete(id);
    }

}
