package com.manel.hospedagem.dto;

public class ClienteDTO {
    private String nome;
    private String CPF;
    private String telefone;
    private String placaDoCarro;
    
    public ClienteDTO(String nome, String CPF, String telefone, String placaDoCarro){
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.placaDoCarro = placaDoCarro;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getCPF(){
        return CPF;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public String getPlacaDoCarro(){
        return placaDoCarro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPlacaDoCarro(String placaDoCarro) {
        this.placaDoCarro = placaDoCarro;
    }
    
}
