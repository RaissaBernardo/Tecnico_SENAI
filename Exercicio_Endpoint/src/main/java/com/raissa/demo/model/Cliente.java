package com.raissa.demo.model;

public class Cliente {
    private Long idCliente;
    private String nome;
    private String cpf;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nome, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}