package com.manel.hospedagem.controller;

import com.manel.hospedagem.janelas.cadastro.CadastroCliente;
import com.manel.hospedagem.janelas.cadastro.CadastroProduto;
import com.manel.hospedagem.janelas.consulta.ConsultaCliente;
import com.manel.hospedagem.janelas.consulta.ConsultaHospedagem;
import com.manel.hospedagem.janelas.consulta.ConsultaProduto;
import com.manel.hospedagem.janelas.consulta.GerenciarHospedagem;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JanelaController {
    //cliente
    public CadastroCliente abrirJanelaCadastroCliente(CadastroCliente cadCliente){
        if (cadastroAbertoCliente(cadCliente) == false) {
            cadCliente = new CadastroCliente();
        } else {
            cadCliente.toFront();
        }
        return cadCliente;
    }
    
    public Boolean cadastroAbertoCliente(CadastroCliente cadCliente){
        return cadCliente != null && cadCliente.isShowing();
    }
    
    public ConsultaCliente abrirJanelaConsultaCliente(ConsultaCliente conCliente, String parent){
        if (consultaAbertaCliente(conCliente) == false) {
            try {
                conCliente = new ConsultaCliente(parent);
            } catch (ParseException ex) {
                Logger.getLogger(JanelaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            conCliente.toFront();
        }
        return conCliente;
    }
    public Boolean consultaAbertaCliente(ConsultaCliente conCliente){
        return conCliente != null && conCliente.isShowing();
    }
    
    //produto
    public CadastroProduto abrirJanelaCadastroProduto(CadastroProduto cadProduto){
        if (cadastroAbertoProduto(cadProduto) == false) {
            cadProduto = new CadastroProduto();
        } else {
            cadProduto.toFront();
        }
        return cadProduto;
    }
    
    public Boolean cadastroAbertoProduto(CadastroProduto cadProduto){
        return cadProduto != null && cadProduto.isShowing();
    }
    
    public ConsultaProduto abrirJanelaConsultaProduto(ConsultaProduto conProduto){
        if (consultaAbertaProduto(conProduto) == false) {
            conProduto = new ConsultaProduto();
        } else {
            conProduto.toFront();
        }
        return conProduto;
    }
    public Boolean consultaAbertaProduto(ConsultaProduto conProduto){
        return conProduto != null && conProduto.isShowing();
    }
    
    //hospedagem
    public ConsultaHospedagem abrirJanelaCadastroHospedagem(ConsultaHospedagem conHospedagem) throws SQLException{
        if (cadastroAbertoHospedagem(conHospedagem) == false) {
            conHospedagem = new ConsultaHospedagem();
        } else {
            conHospedagem.toFront();
        }
        return conHospedagem;
    }
    
    public Boolean cadastroAbertoHospedagem(ConsultaHospedagem conHospedagem){
        return conHospedagem != null && conHospedagem.isShowing();
    }
    
    public ConsultaHospedagem abrirJanelaConsultaHospedagem(ConsultaHospedagem conHospedagem) throws SQLException{
        if (consultaAbertaHospedagem(conHospedagem) == false) {
            conHospedagem = new ConsultaHospedagem();
        } else {
            conHospedagem.toFront();
        }
        return conHospedagem;
    }
    public Boolean consultaAbertaHospedagem(ConsultaHospedagem conHospedagem){
        return conHospedagem != null && conHospedagem.isShowing();
    }
    
    //gerenciar hospedagem
    public GerenciarHospedagem abrirJanelaGerenciarHospedagem(GerenciarHospedagem gerenciarHospedagem, String id) throws SQLException{
        if (gerenciarAbertoHospedagem(gerenciarHospedagem) == false) {
            gerenciarHospedagem = new GerenciarHospedagem(id);
        } else {
            gerenciarHospedagem.toFront();
        }
        return gerenciarHospedagem;
    }
    
    public Boolean GerenciarAbertoHospedagem(GerenciarHospedagem gerenciarHospedagem){
        return gerenciarHospedagem != null && gerenciarHospedagem.isShowing();
    }
    
    public Boolean gerenciarAbertoHospedagem(GerenciarHospedagem gerenciarHospedagem){
        return gerenciarHospedagem != null && gerenciarHospedagem.isShowing();
    }
}