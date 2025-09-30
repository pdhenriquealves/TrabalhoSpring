package com.projeto.TrabalhoSpring.Controller;

import com.projeto.TrabalhoSpring.Model.Cliente;
import com.projeto.TrabalhoSpring.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.salvar(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(
            @PathVariable Long id,
            @RequestBody Cliente cliente) {
        Cliente existente = clienteService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        existente.setNome(cliente.getNome());
        existente.setEmail(cliente.getEmail());

        return ResponseEntity.ok(clienteService.salvar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
