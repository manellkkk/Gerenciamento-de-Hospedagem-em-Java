package com.manel.hospedagem.dto;

import java.util.Date;

public class HospedagemDTO {
    private final int idHospedagem;
    private final String cpfCliente;
    private double valor;
    private Date dataEntrada;
    private Date dataSaida;
    private int quarto;
    private double totalConsumo;
    private double totalHospedagem;

    public HospedagemDTO(int idHospedagem, String cpfCliente, double valor, Date dataEntrada, Date dataSaida, int quarto) {
        this.idHospedagem = idHospedagem;
        this.cpfCliente = cpfCliente;
        this.valor = valor;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quarto = quarto;
    }

    public double getTotalConsumo() {
        return totalConsumo;
    }

    public void setTotalConsumo(double totalConsumo) {
        this.totalConsumo = totalConsumo;
    }

    public double getTotalHospedagem() {
        return totalHospedagem;
    }

    public void setTotalHospedagem(double totalHospedagem) {
        this.totalHospedagem = totalHospedagem;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getCpfCliente() {
        return cpfCliente;
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

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }
}