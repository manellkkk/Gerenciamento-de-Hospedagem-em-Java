package com.manel.hospedagem.dto;

import java.util.Date;

public class HospedagemDTO {
    private int idHospedagem;
    private int idCliente;
    private double valor;
    private Date dataEntrada;
    private Date dataSaida;
    private Boolean ativo;

    public HospedagemDTO(int idCliente, double valor, Date dataEntrada, Date dataSaida) {
        this.idCliente = idCliente;
        this.valor = valor;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.ativo = false;
    }
    
    public int getIdHospedagem() {
        return idHospedagem;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValorTotal(double valor) {
        this.valor = valor;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    
}