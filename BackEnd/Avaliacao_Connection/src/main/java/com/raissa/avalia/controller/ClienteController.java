package com.raissa.avalia.controller;

import com.raissa.avalia.database.ClienteBanco;
import com.raissa.avalia.database.LivroBanco;
import com.raissa.avalia.model.Cliente;
import java.util.List;


public class ClienteController {
    private final ClienteBanco clienteBanco;

    public ClienteController() {
        this.clienteBanco = new ClienteBanco();
    }

    // inserir cliente
    public void inserirCliente(Cliente cliente) {
        clienteBanco.insert(cliente);
    }

    // consultar cliente
    public List<Cliente> consultarClientes() {
        return clienteBanco.findAll();
    }

    //atuzlaizra cliente
    public boolean atualizarCliente(int clienteId, Cliente novoCliente) {
        Cliente cliente = clienteBanco.findOne(clienteId);
        if (cliente != null) {
            clienteBanco.update(novoCliente);
            return true;
        }
        return false;
    }

    //excluir cliente
    public boolean excluirCliente(int clienteId) {
        Cliente cliente = clienteBanco.findOne(clienteId);
        if (cliente != null) {
            clienteBanco.delete(clienteId);
            return true;
        }
        return false;
    }
}
