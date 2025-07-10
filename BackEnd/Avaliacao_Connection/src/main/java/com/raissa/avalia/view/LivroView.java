package com.raissa.avalia.view;


import com.raissa.avalia.controller.ClienteController;
import com.raissa.avalia.controller.LivroController;
import com.raissa.avalia.model.Cliente;
import com.raissa.avalia.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroView {

    LivroController controller = new LivroController();

    @PostMapping
    public String livro(@RequestBody Livro livro) {
        controller.inserirLivro(livro);
        return "Inserido";
    }

    @GetMapping
    public List<Livro> mostrarLivro() {
        return controller.consultarLivros();
    }

    @PutMapping("/{idLivro}")
    public String trocar(@PathVariable int idLivro, @RequestBody Livro livro) {
        boolean atualizado = controller.atualizarLivro(idLivro, livro);
        return "Atualizado";
    }

    @DeleteMapping
    public String deleta(@RequestBody int id){
        boolean deleted = controller.excluirLivro(id);
        return deleted ? "Produto deletado com sucesso!" : "Produto não encontrado!";
    }
}
