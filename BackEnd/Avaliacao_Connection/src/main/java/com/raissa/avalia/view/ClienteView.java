package com.raissa.avalia.view;
import com.raissa.avalia.controller.ClienteController;
import com.raissa.avalia.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteView {
    ClienteController controller = new ClienteController();

    @PostMapping
    public String cliente (@RequestBody Cliente cliente){
        controller.inserirCliente(cliente);
        return "Inserido";
    } //ok

    @GetMapping
    public List<Cliente> mostrarCliente(){
        return controller.consultarClientes();
    } //ok

    @PutMapping("/{idCliente}")
    public String trocar(@PathVariable int idCliente, @RequestBody Cliente novoCliente) {
        controller.atualizarCliente(idCliente, novoCliente);
        return "Atualizado";
    } //ok

    @DeleteMapping
    public String deleta(@RequestBody int id){
        boolean deleted = controller.excluirCliente(id);
        return deleted ? "Produto deletado com sucesso!" : "Produto não encontrado!";
    }//ok
}
