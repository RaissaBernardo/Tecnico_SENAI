package com.example.demo.view;


import com.example.demo.controller.ProdutoController;
import com.example.demo.model.Produto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutosView {

    //clonar prod

    ProdutoController controle = new ProdutoController();


    @GetMapping("/produto") //ve o que ta la
    public List<Produto> getProd(){
        return controle.pegar();
    }

    @PostMapping("/produto") //usa o "scanner", insere/cria
    public String postProd(@RequestBody Produto produtoInserido){
         controle.inserir(produtoInserido);
         return "Sucesso";
    }

    @PutMapping("/produto")//atualiza td
    public String putProd(@RequestBody Produto prodAtt){
            controle.atualizar(prodAtt);
            return "Produto atualizado";
    }

    @DeleteMapping("/produto/{id}")
   public String delProd(@RequestBody int id){
        boolean deleted = controle.apagar(id);
        return deleted ? "Produto deletado com sucesso!" : "Produto não encontrado!";
    }
}