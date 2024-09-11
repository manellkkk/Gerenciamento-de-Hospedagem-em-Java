package com.manel.hospedagem.dto;

public class ProdutoDTO {
    private int idProduto;
    private String nome;
    private int quantidade;
    private double valor;
    
    public ProdutoDTO(int idProduto, String nome, int quantidade, double valor){
        this.idProduto = idProduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}