package com.raissa.avalia.database;

import java.util.ArrayList;
import java.util.List;

import com.raissa.avalia.model.Emprestimo;

public class EmprestimoBanco {
    private final ArrayList<Emprestimo> emprestimos;

    public EmprestimoBanco() {
        this.emprestimos = new ArrayList<>();
    }

    //adiciona um emprestimp
    public void insert(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    // busca pelo id
    public Emprestimo findOne(int id) {
        for (Emprestimo e : emprestimos) {
            if (e.getIdEmprest() == id) {
                return e;
            }
        }
        return null;
    }

    //retorna eles (get)
    public List<Emprestimo> findAll() {
        return new ArrayList<>(emprestimos);
    }

    // atualiza
    public boolean update(Emprestimo emprestimo) {
        for (int i = 0; i < emprestimos.size(); i++) {
            if (emprestimos.get(i).getIdEmprest() == emprestimo.getIdEmprest()) {
                emprestimos.set(i, emprestimo);
                return true;
            }
        }
        return false;
    }

    // remove pelo id
    public boolean delete(int id) {
        return emprestimos.removeIf(e -> e.getIdEmprest() == id);
    }
}
