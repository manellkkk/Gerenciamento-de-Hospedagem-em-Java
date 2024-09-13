package com.manel.hospedagem.dto;

import java.sql.Date;

public class ConsumoDTO {
    private int idConsumo;
    private int idProduto;
    private int idHospedagem;
    private Date data;
    private int quantidade;
    private double valorTotal;

    public ConsumoDTO(int idConsumo, int idProduto, int idHospedagem, Date data, int quantidade, double valorTotal) {
        this.idConsumo = idConsumo;
        this.idProduto = idProduto;
        this.idHospedagem = idHospedagem;
        this.data = data;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(int idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "ProdutoConsumidoDTO{" + "idConsumo=" + idConsumo + ", idProduto=" + idProduto + ", idHospedagem=" + idHospedagem + ", data=" + data + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + '}';
    }
}