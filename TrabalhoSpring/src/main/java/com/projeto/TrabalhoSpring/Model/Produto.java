package com.projeto.TrabalhoSpring.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
