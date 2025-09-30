package com.projeto.TrabalhoSpring.Controller;

import com.projeto.TrabalhoSpring.Model.Produto;
import com.projeto.TrabalhoSpring.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.salvar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable Long id,
            @RequestBody Produto produto) {
        Produto existente = produtoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        existente.setNome(produto.getNome());
        existente.setQuantidade(produto.getQuantidade());
        existente.setPreco(produto.getPreco());

        return ResponseEntity.ok(produtoService.salvar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}