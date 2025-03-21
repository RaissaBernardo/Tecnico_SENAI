package com.raissa.demo.banco;

import com.raissa.demo.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBaseProduto {

    private List<Produto> produtos;

    public DataBaseProduto() {
        this.produtos = new ArrayList<>();
    }

    // INSERE
    public void insert(Produto p) {
        produtos.add(p);
    }

    // BUSCA PELO ID
    public Produto findOne(int id) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == id) {
                return p;
            }
        }
        return null;
    }

    // RETORNA
    public List<Produto> findAll() {
        return new ArrayList<>(produtos);
    }

    // ATUALIZA
    public boolean update(Produto p) {
        for (int i = 0; i < produtos.size(); i++) {
            if (Objects.equals(produtos.get(i).getIdProduto(), p.getIdProduto())) {
                produtos.set(i, p);
                return true;
            }
        }
        return false;
    }

    //DELETA
    public boolean delete(int id) {
        return produtos.removeIf(p -> p.getIdProduto() == id);
    }
}