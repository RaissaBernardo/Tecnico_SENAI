package com.raissa.avalia.database;

import java.util.ArrayList;
import java.util.List;

import com.raissa.avalia.model.Livro;

public class LivroBanco {
    private final ArrayList<Livro> livros;

    public LivroBanco() {
        this.livros = new ArrayList<>();
    }

    //add um livro
    public void insert(Livro livro) {
        livros.add(livro);
    }

    // busca id
    public Livro findOne(int id) {
        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                return l;
            }
        }
        return null;
    }

    //retorna
    public List<Livro> findAll() {
        return new ArrayList<>(livros);
    }

    // atualiza
    public boolean update(Livro livro) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIdLivro() == livro.getIdLivro()) {
                livros.set(i, livro);
                return true;
            }
        }
        return false;
    }

    // remove
    public boolean delete(int id) {
        return livros.removeIf(l -> l.getIdLivro() == id);  // Alterado para getIdLivro()
    }
}
