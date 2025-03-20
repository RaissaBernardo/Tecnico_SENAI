package com.example.demo.controller;

import com.example.demo.database.Banco;
import com.example.demo.model.Produto;
import java.util.List;

public class ProdutoController {
    Banco br = new Banco();

    //met get
    public List<Produto> pegar() {
        return br.findAll();
    }

    public void inserir(Produto pr) {
        br.insert(pr);
    }

    public void atualizar(Produto pr) {
        br.update(pr);
    }

    public boolean apagar(int id) {
        br.delete(id);
        return false;
    }
}