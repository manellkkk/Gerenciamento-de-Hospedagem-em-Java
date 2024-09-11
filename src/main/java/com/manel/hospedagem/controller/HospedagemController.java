package com.manel.hospedagem.controller;

import com.manel.hospedagem.dao.HospedagemDAO;
import com.manel.hospedagem.dto.HospedagemDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

public class HospedagemController {
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
    
    public Boolean adicionarHospedagem(String cpf, String valor, String strDataEntrada, String quarto) throws ParseException{
        double dValor;
        int iQuarto;

        try {
            dValor = Double.parseDouble(valor);
            iQuarto = Integer.parseInt(quarto);
        } catch (NumberFormatException e) {
            mensagem = "Preço inválido ou número de quarto ocupado.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro de entrada", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        formato.setLenient(false);

        Date dataEntrada;
        try {
            dataEntrada = formato.parse(strDataEntrada);
        } catch (ParseException e) {
            mensagem = "Formato de data inválido.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro de entrada", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (dataInvalida(dataEntrada)) {
            mensagem = "Data muito antiga ou adiantada.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro de entrada", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(quartoOcupado(iQuarto)){
            mensagem = "Quarto ocupado.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro de entrada", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        HospedagemDTO hospedagemDTO = new HospedagemDTO(0, cpf, dValor, dataEntrada, null, iQuarto);
        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        
        try {
            hospedagemDAO.adicionarHospedagem(hospedagemDTO);
            mensagem = "Hospedagem realizada.";
            JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException ex) {
            mensagem = "Não foi possível realizar hospedagem: ";
            mensagem += ex.getMessage();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean removerHospedagem(String id){
        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        hospedagemDAO.removerHospedagem(id);
        mensagem = "Hospedagem removida com sucesso.";
        JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public Boolean verificarHospedagem(int idHospedagem){
        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        return hospedagemDAO.verificarHospedagemFinalizada(idHospedagem);
    }
    
    public void finalizarHospedagem(int id){
        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        hospedagemDAO.finalizarHospedagem(id);
    }
    
    public HospedagemDTO selecionarHospedagem(String id) throws SQLException{
        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        HospedagemDTO hospedagemDTO = hospedagemDAO.selecionarHospedagem(id);
        return hospedagemDTO;
    }
    
    private Boolean precoInvalido(String strValor, Double valor){
        return (strValor.isEmpty() || valor == 0);
    }
    
    private Boolean dataInvalida(String data){
        return data.length() != 10;
    }
    
    private Boolean quartoOcupado(int quarto){
        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        return hospedagemDAO.verificarQuartoOcupado(quarto);
    }
    
    public ArrayList<HospedagemDTO> selecionarTodos(){
        ArrayList<HospedagemDTO> hospedagens = new ArrayList();
        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        
        try {
            hospedagens = hospedagemDAO.selecionarTodos();
            return hospedagens;
        } catch (SQLException ex) {
            mensagem = "Não foi possível selecionar: ";
            mensagem += ex.getMessage();
            return null;
        }
    }
    
    private Boolean dataInvalida(Date dataEntrada) {
        Date dataAtual = new Date();

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dataAtual);
        calendario.add(Calendar.MONTH, -1);
        Date umMesAtras = calendario.getTime();

        return dataEntrada.after(dataAtual) || dataEntrada.before(umMesAtras);
    }
}