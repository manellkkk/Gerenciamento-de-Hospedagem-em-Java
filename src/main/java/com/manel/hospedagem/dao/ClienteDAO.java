package com.manel.hospedagem.dao;

import com.manel.hospedagem.database.DatabaseConnection;
import com.manel.hospedagem.dto.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private String mensagem;
    
    public void adicionarCliente(ClienteDTO cliente) throws SQLException {
        connection.openConnection();
        
        String query = "INSERT INTO cliente (nome, cpf, telefone, placaDoCarro) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getCPF());
        statement.setString(3, cliente.getTelefone());
        statement.setString(4, cliente.getPlacaDoCarro());
        statement.executeUpdate();
        mensagem = "Inserido.";
        
        connection.closeConnection();
    }
    
    public void removerCliente(ClienteDTO cliente) throws SQLException {
        connection.openConnection();
        
        String query = "DELETE FROM cliente WHERE nome = ? AND cpf = ? AND telefone = ? AND placaDoCarro = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getCPF());
        statement.setString(3, cliente.getTelefone());
        statement.setString(4, cliente.getPlacaDoCarro());
        statement.executeUpdate();
        mensagem = "Excluído.";
        
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
        mensagem = "Editado.";
        
        connection.closeConnection();
    }
    
    public ClienteDTO selecionarCliente(String cpf) throws SQLException {
        connection.openConnection();

        String query = "SELECT idCliente FROM Cliente WHERE cpf = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cpf);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int idCliente = resultSet.getInt("idCliente");
            String nome = resultSet.getString("nome");
            String telefone = resultSet.getString("telefone");
            String placaDoCarro = resultSet.getString("placaDoCarro");
            ClienteDTO cliente = new ClienteDTO(nome, cpf, telefone, placaDoCarro);
            cliente.setIdCliente(idCliente);
            connection.closeConnection();
            return cliente;
        } else {
            mensagem = "Cliente não encontrado com o CPF fornecido.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            connection.closeConnection();
            return null;
        }
    }
}