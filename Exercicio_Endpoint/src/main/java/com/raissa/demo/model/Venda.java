package com.raissa.demo.model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
public class Venda {
    private Long idVenda;
    private LocalDate dataVenda;
    private List<Produto> produtos;
    private Cliente cliente;

    public Venda() {
    }

    public Venda(Long idVenda, LocalDate dataVenda, List<Produto> produtos, Cliente cliente) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
