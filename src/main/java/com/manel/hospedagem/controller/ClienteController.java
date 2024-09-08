package com.manel.hospedagem.controller;

import com.manel.hospedagem.dao.ClienteDAO;
import com.manel.hospedagem.dto.ClienteDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteController {
    public String mensagem;
    
    public Boolean adicionarCliente(String nome, String CPF, String telefone, String placaDoCarro){
        String cpf = CPF.trim();
        if(nome.isEmpty() || isCPFInvalido(cpf)){
            mensagem = "Nome e/ou CPF inválidos.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(isTelefoneInvalido(telefone)){
            mensagem = "Telefone incompleto.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        ClienteDTO clienteDTO = new ClienteDTO(nome, CPF, telefone, placaDoCarro);
        
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.adicionarCliente(clienteDTO);
            mensagem = "Usuário criado com sucesso.";
            JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            mensagem = "Erro ao criar usuário: ";
            mensagem += e.getMessage();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private static boolean isCPFInvalido(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11) {
            return true;
        }
        return false;
    }
    
    private static boolean isTelefoneInvalido(String telefone) {
        telefone = telefone.replaceAll("\\D", "");
        
        if (telefone.isEmpty() || telefone.length() == 11) {
            return false;
        }
        return true;
    }
}