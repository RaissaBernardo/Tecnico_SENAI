package com.raissa.avalia.database;

import java.util.ArrayList;
import java.util.List;

import com.raissa.avalia.model.Cliente;

public class ClienteBanco {
    private final ArrayList<Cliente> clientes;

    public ClienteBanco() {
        this.clientes = new ArrayList<>();
    }

    // add cliente
    public void insert(Cliente cliente) {
        clientes.add(cliente);
    }

    // busca id
    public Cliente findOne(int id) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    //retorna
    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    //atualiza clientes
    public boolean update(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente() == cliente.getIdCliente()) {
                clientes.set(i, cliente);
                return true;
            }
        }
        return false;
    }

    // remove
    public boolean delete(int id) {
        return clientes.removeIf(c -> c.getIdCliente() == id);  // Alterado para usar getId()
    }
}
