package com.manel.hospedagem.controller;

import com.manel.hospedagem.dao.ClienteDAO;
import com.manel.hospedagem.dto.ClienteDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteController {
    public String mensagem = "nada";

    public String getMensagem() {
        return mensagem;
    }
    
    public Boolean adicionarCliente(String nome, String CPF, String telefone, String placaDoCarro){
        String cpf = CPF.trim();
        if(nome.isEmpty() || isCPFInvalido(cpf)){
            mensagem = "Nome e/ou CPF inválido(s).";
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
            mensagem = "Cliente criado com sucesso.";
            JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            mensagem = "Erro ao criar cliente: ";
            mensagem += e.getMessage();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void removerCliente(String cpf){
        ClienteDAO clienteDAO = new ClienteDAO();
        try {
            clienteDAO.removerCliente(cpf);
            mensagem = "Cliente removido com sucesso.";
            JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            mensagem = clienteDAO.getMensagem();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<ClienteDTO> selecionarPorNome(String nome) throws SQLException{
        ArrayList<ClienteDTO> clientes = new ArrayList();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        clientes = clienteDAO.selecionarPorNome(nome);
        return clientes;
    }
    
    public ClienteDTO selecionarCliente(String cpf) throws SQLException{
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteDTO cliente = clienteDAO.selecionarCliente(cpf);
        return cliente;
    }
    
    public ArrayList<ClienteDTO> selecionarTodos(){
        ArrayList<ClienteDTO> clientes = new ArrayList();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        try {
            clientes = clienteDAO.selecionarTodos();
            return clientes;
        } catch (SQLException ex) {
            mensagem = "Não foi possível selecionar: ";
            mensagem += ex.getMessage();
            return null;
        }
    }
    
    public ArrayList<ClienteDTO> selecionarPorCPF(String cpf) throws SQLException{
        ArrayList<ClienteDTO> clientes = new ArrayList();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        clientes = clienteDAO.selecionarPorCPF(cpf);
        return clientes;
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