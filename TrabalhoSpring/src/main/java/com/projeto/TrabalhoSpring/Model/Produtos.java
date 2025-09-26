package com.projeto.TrabalhoSpring.Model;

import jakarta.persistence.*;

@Entity

public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidade;
    private double preco;

    @ManyToOne
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

    public double getPreco() {
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

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
