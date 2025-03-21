package com.raissa.demo.banco;

import com.raissa.demo.model.Cliente;
import com.raissa.demo.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBaseCliente {

    private List<Cliente> clientes; //criou lista de clientes para armazenar

    public DataBaseCliente(){
        this.clientes = new ArrayList<>();
    }


    //insere
    public void insert(Cliente c) {
        clientes.add(c);
    } //insere o c (cliente add), na lista clientes


    // BUSCA PELO ID
    public Cliente findOne(int id) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    } //equanto cliente estiver na linha de clientes, pega o id que foi escrito e retorna ele


    // RETORNA
    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    } //pega o client da lista e retorna ele da lista de clientes

    //DELETA
    public boolean delete(int id) {
        return clientes.removeIf(c -> c.getIdCliente() == id);
    }

    // ATUALIZA
    public boolean update(Cliente c) {
        for (int i = 0; i < clientes.size(); i++) {
            if (Objects.equals(clientes.get(i).getIdCliente(), c.getIdCliente())) {
                clientes.set(i, c);
                return true;
            }
        }
        return false;
    }
}
