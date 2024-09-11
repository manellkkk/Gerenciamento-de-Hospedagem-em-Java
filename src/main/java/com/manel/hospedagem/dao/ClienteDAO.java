package com.manel.hospedagem.dao;

import com.manel.hospedagem.database.DatabaseConnection;
import com.manel.hospedagem.dto.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
    
    public void adicionarCliente(ClienteDTO cliente) throws SQLException {
        connection.openConnection();
        
        String query = "INSERT INTO cliente (nome, cpf, telefone, placaDoCarro) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getCPF());
        statement.setString(3, cliente.getTelefone());
        statement.setString(4, cliente.getPlacaDoCarro());
        statement.executeUpdate();
        mensagem = "Inserido com sucesso.";
        
        connection.closeConnection();
    }
    
    public void removerCliente(String cpf) throws SQLException {
        connection.openConnection();
        
        String query = "DELETE FROM cliente WHERE cpf = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cpf);
        statement.executeUpdate();
        mensagem = "Excluído com sucesso.";
        
        connection.closeConnection();
    }
    
    public void editarCliente(ClienteDTO cliente) throws SQLException {
        connection.openConnection();

        String query = "UPDATE cliente SET nome = ?, telefone = ?, placaDoCarro = ? WHERE cpf = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getTelefone());
        statement.setString(3, cliente.getPlacaDoCarro());
        statement.setString(4, cliente.getCPF());
        statement.executeUpdate();
        mensagem = "Editado com sucesso.";
        
        connection.closeConnection();
    }
    
    public ArrayList<ClienteDTO> selecionarTodos() throws SQLException {
        String query = "SELECT * FROM Cliente";
        ArrayList<ClienteDTO> clientes = new ArrayList();
        
        connection.openConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            String nomeCliente = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            String telefone = resultSet.getString("telefone");
            String placaDoCarro = resultSet.getString("placaDoCarro");
            
            ClienteDTO cliente = new ClienteDTO(nomeCliente, cpf, telefone, placaDoCarro);
            clientes.add(cliente);
        }
        connection.closeConnection();
        return clientes;
    }
    
    public ArrayList<ClienteDTO> selecionarPorNome(String nome) throws SQLException{
        String query = "SELECT * FROM Cliente WHERE nome LIKE ?";
        ArrayList<ClienteDTO> clientes = new ArrayList();
        clientes = consultarClientesBanco(query, nome);
        return clientes;
    }
    
    public ArrayList<ClienteDTO> selecionarPorCPF(String cpf) throws SQLException {
        String query = "SELECT * FROM Cliente WHERE cpf LIKE ?";
        ArrayList<ClienteDTO> clientes = new ArrayList();
        clientes = consultarClientesBanco(query, cpf);
        return clientes;
    }
    
    public ClienteDTO selecionarCliente(String cpf) throws SQLException {
        String query = "SELECT * FROM Cliente WHERE cpf = ?";
        ClienteDTO cliente = selecionarClienteBanco(query, cpf);
        return cliente;
    }
    
    private ArrayList<ClienteDTO> consultarClientesBanco(String query, String target) throws SQLException{
        connection.openConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + target + "%");
        ResultSet resultSet = statement.executeQuery();
        
        ArrayList<ClienteDTO> clientes = new ArrayList();
        
        while (resultSet.next()) {
            String nomeCliente = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            String telefone = resultSet.getString("telefone");
            String placaDoCarro = resultSet.getString("placaDoCarro");
            
            ClienteDTO cliente = new ClienteDTO(nomeCliente, cpf, telefone, placaDoCarro);
            clientes.add(cliente);
        }
        connection.closeConnection();
        return clientes;
    }
    
    private ClienteDTO selecionarClienteBanco(String query, String target) throws SQLException{
        connection.openConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, target);
        ResultSet resultSet = statement.executeQuery();

        ClienteDTO cliente = null;

        if (resultSet.next()) {
            String nomeCliente = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            String telefone = resultSet.getString("telefone");
            String placaDoCarro = resultSet.getString("placaDoCarro");

            cliente = new ClienteDTO(nomeCliente, cpf, telefone, placaDoCarro);
        }

        connection.closeConnection();
        return cliente;
    }
}