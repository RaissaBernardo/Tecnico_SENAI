package com.raissa.avalia.controller;

import com.raissa.avalia.database.LivroBanco;
import com.raissa.avalia.model.Livro;
import java.util.List;

public class LivroController {
    private LivroBanco livroBanco;

    public LivroController() {
        this.livroBanco = new LivroBanco();
    }

    //inserir livros
    public void inserirLivro(Livro livro) {
        livroBanco.insert(livro);
    }

    // consulta livros
    public List<Livro> consultarLivros() {
        return livroBanco.findAll();
    }

    // atualzia dados
    public boolean atualizarLivro(int livroId, Livro novoLivro) {
        Livro livro = livroBanco.findOne(livroId);
        if (livro != null) {
            livroBanco.update(novoLivro);
            return true;
        }
        return false;
    }

    // apaga o livro
    public boolean excluirLivro(int livroId) {
        Livro livro = livroBanco.findOne(livroId);
        if (livro != null) {
            livroBanco.delete(livroId);
            return true;
        }
        return false;
    }
}