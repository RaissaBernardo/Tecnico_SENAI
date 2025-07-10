package com.raissa.avalia.view;

import com.raissa.avalia.controller.EmpController;
import com.raissa.avalia.model.Emprestimo;
import com.raissa.avalia.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmpView {
    private EmpController controller = new EmpController();

    @PostMapping
    public String registrar(@PathVariable int clienteId, @RequestBody List<Livro> livros, @PathVariable String dataInicio, @PathVariable String dataFim) {
        controller.registrarEmprestimo(clienteId, livros, dataInicio, dataFim);
        return "Empréstimo registrado com sucesso!";
    }

    @GetMapping
    public List<Emprestimo> consultar() {
        return controller.consultarEmprestimos();
    }

    @DeleteMapping("/{emprestimoId}")
    public String excluir(@PathVariable int emprestimoId) {
        boolean excluido = controller.excluirEmprestimo(emprestimoId);
        return excluido ? "Empréstimo excluído com sucesso!" : "Empréstimo não encontrado!";
    }

    @PutMapping("/{emprestimoId}/livros/{livroId}")
    public String adicionarLivro(@PathVariable int emprestimoId, @PathVariable int livroId) {
        controller.adicionarLivroAoEmprestimo(emprestimoId, livroId);
        return "Livro adicionado ao empréstimo com sucesso!";
    }

    @PutMapping("/{emprestimoId}/dataFim")
    public String dataFinal(@PathVariable int emprestimoId, @PathVariable String novaDataFim) {
        boolean atualizado = controller.atualizarDataFinalEmprestimo(emprestimoId, novaDataFim);
        return atualizado ? "Data final do empréstimo atualizada com sucesso!" : "Empréstimo não encontrado!";
    }

    @GetMapping("/dataFim")
    public List<Emprestimo> consultarPorDataFim(@PathVariable String dataFim) {
        return controller.consultarEmprestimosPorDataFim(dataFim);
    }
}
//classe n testada
//TESTAR ATE 17H25 -- N ESQUECER