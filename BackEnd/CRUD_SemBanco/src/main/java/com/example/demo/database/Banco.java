package com.example.demo.database;



import com.example.demo.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Produto> produtos;

    public Banco() {
        this.produtos = new ArrayList<>();
    }

    //post
    public void insert(Produto p) {
        produtos.add(p);
    }


    // Busca um produto pelo ID -- vinicius
    public Produto findOne(int id) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == id) {
                return p;
            }
        }
        return null;
    } //O método findOne recebe um ID de produto (id) e busca na lista de produtos um produto com esse ID.
   // percorre a lista (for (Produto p : produtos)) e, quando encontra um produto com o ID igual ao passado como argumento, o retorna.


    // retorna os produtos, get
    public List<Produto> findAll() {
        return new ArrayList<>(produtos);
    }


    // percorre a lista de produtos e, quando encontra um produto com o mesmo ID (p.getIdProduto()), o substitui na lista usando o método set da ArrayList.
    public boolean update(Produto p) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getIdProduto() == p.getIdProduto()) {
                produtos.set(i, p);
                return true; // para remover o produto que tenha o ID igual ao passado como argumento.
            }
        }
        return false; // volta falso se o produto não foi encontrado
    }


    // Remove um produto pelo ID -- vinicius
    public boolean delete(int id) {
        return produtos.removeIf(p -> p.getIdProduto() == id);
    }
}
