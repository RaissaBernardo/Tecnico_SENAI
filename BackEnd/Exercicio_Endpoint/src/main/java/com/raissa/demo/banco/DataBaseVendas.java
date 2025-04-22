package com.raissa.demo.banco;

import com.raissa.demo.model.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBaseVendas {

    private List<Venda> vendas;

    public void DataBaseVenda() {
        this.vendas = new ArrayList<>();
    }

    // INSERE
    public void insert(Venda v) {
        vendas.add(v);
    }

    // BUSCA PELO ID
    public Venda findOne(int id) {
        for (Venda v : vendas) {
            if (v.getIdVenda() == id) {
                return v;
            }
        }
        return null;
    }

    // RETORNA
    public List<Venda> findAll() {
        return new ArrayList<>(vendas);
    }

    // ATUALIZA
    public boolean update(Venda v) {
        for (int i = 0; i < vendas.size(); i++) {
            if (Objects.equals(vendas.get(i).getIdVenda(), v.getIdVenda())) {
                vendas.set(i, v);
                return true;
            }
        }
        return false;
    }

    //DELETA
    public boolean delete(int id) {
        return vendas.removeIf(v -> v.getIdVenda() == id);
    }
}
