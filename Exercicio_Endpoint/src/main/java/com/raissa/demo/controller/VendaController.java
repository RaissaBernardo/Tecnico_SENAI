package com.raissa.demo.controller;

import com.raissa.demo.banco.DataBaseVendas;
import com.raissa.demo.model.Venda;

import java.util.List;

public class VendaController {

    DataBaseVendas bcV = new DataBaseVendas();


    //RETORNA TD
    public List<Venda> pegarVendas() {
        return bcV.findAll();
    }

    // ADD PROS
    public void adicionarVendas(Venda v) {
        bcV.insert(v);
    }

    // ATUALIZA PROD
    public boolean atualizarVenda(Venda v) {
        return bcV.update(v);
    }

    // REMOVE
    public boolean removerVenda(int id) {
        return bcV.delete(id);
    }
}
