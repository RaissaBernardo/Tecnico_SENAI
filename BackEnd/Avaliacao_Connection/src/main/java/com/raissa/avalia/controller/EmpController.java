package com.raissa.avalia.controller;

import com.raissa.avalia.database.ClienteBanco;
import com.raissa.avalia.database.EmprestimoBanco;
import com.raissa.avalia.database.LivroBanco;
import com.raissa.avalia.model.Cliente;
import com.raissa.avalia.model.Emprestimo;
import com.raissa.avalia.model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpController {
    private EmprestimoBanco emprestimoBanco;
    private LivroBanco livroBanco;
    private ClienteBanco clienteBanco;

    public EmpController() {
        this.emprestimoBanco = new EmprestimoBanco();
        this.livroBanco = new LivroBanco();
        this.clienteBanco = new ClienteBanco();
    }

    //registrar um novo emprestimo
    public void registrarEmprestimo(int clienteId, List<Livro> livros, String dataInicio, String dataFim) {
        Cliente cliente = clienteBanco.findOne(clienteId);
        if (cliente != null) { //caso cliente não esteja vazio
            Emprestimo emprestimo = new Emprestimo(cliente, livros, dataInicio, dataFim); //crie um emprestimo com esse atributos
            emprestimoBanco.insert(emprestimo);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }//regstro empr

    //ver quais são os emprestimos
    public List<Emprestimo> consultarEmprestimos() {
        return emprestimoBanco.findAll();
    }

    //excluir emp
    public boolean excluirEmprestimo(int emprestimoId) {
        Emprestimo emprestimo = emprestimoBanco.findOne(emprestimoId);
        if (emprestimo != null) {
            emprestimoBanco.delete(emprestimoId);
            return true;
        }
        return false;
    }

    // adicionar livro ao emprestimo
    public void adicionarLivroAoEmprestimo(int idEmprest, int idLivro) {
        //busca pelo id de novo
        Emprestimo emprestimo = emprestimoBanco.findOne(idEmprest);

        if (emprestimo != null) {
            //agora busca o livro pelo id
            Livro livro = livroBanco.findOne(idLivro);

            if (livro != null) {
                // add este livro na lista de emprestimos
                emprestimo.getLivrosEmprestados().add(livro);
                emprestimoBanco.update(emprestimo);
                System.out.println("Livro adicionado ao empréstimo.");
            } else {
                System.out.println("Livro não encontrado.");
            }
        } else {
            System.out.println("Empréstimo não encontrado.");
        }
    }

    //atualizar pela data final
    public boolean atualizarDataFinalEmprestimo(int emprestimoId, String novaDataFim) {
        Emprestimo emprestimo = emprestimoBanco.findOne(emprestimoId);
        if (emprestimo != null) {
            emprestimo.setDataFim(LocalDate.parse(novaDataFim)); //o inetllij pediu para que eu colocasse o parse
            emprestimoBanco.update(emprestimo);
            return true;
        }
        return false;
    }

    //pesquisa pela data final
    public List<Emprestimo> consultarEmprestimosPorDataFim(String dataFim) {
        List<Emprestimo> emprestimosComDataFim = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimoBanco.findAll()) {
            if (emprestimo.getDataFim().equals(dataFim)) {
                emprestimosComDataFim.add(emprestimo);
            }
        }
        return emprestimosComDataFim;
    }

}//cont
