package com.manel.hospedagem.dao;

import com.manel.hospedagem.database.DatabaseConnection;
import com.manel.hospedagem.dto.ProdutoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private String mensagem;
    
    public void adicionarProduto(ProdutoDTO produto) throws SQLException {
        connection.openConnection();
        
        String query = "INSERT INTO produto (nome, quantidade, valor) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, produto.getNome());
        statement.setInt(2, produto.getQuantidade());
        statement.setDouble(3, produto.getValor());
        statement.executeUpdate();
        mensagem = "Inserido.";
        
        connection.closeConnection();
    }
    
    public void removerProduto(ProdutoDTO produto) throws SQLException {
        connection.openConnection();
        
        String query = "DELETE FROM produto WHERE nome = ? AND cpf = ? AND telefone = ? AND placaDoCarro = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, produto.getNome());
        statement.setInt(2, produto.getQuantidade());
        statement.setDouble(3, produto.getValor());
        statement.executeUpdate();
        mensagem = "Inserido.";
        
        connection.closeConnection();
    }
    
    public ProdutoDTO selecionarProduto(String nome) throws SQLException {
        connection.openConnection();

        String query = "SELECT idProduto, nome, quantidade, valor FROM Produto WHERE nome = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nome);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int idProduto = resultSet.getInt("idProduto");
            String nomeProduto = resultSet.getString("nome");
            int quantidade = resultSet.getInt("quantidade");
            double valor = resultSet.getDouble("valor");
            ProdutoDTO produto = new ProdutoDTO(nomeProduto, quantidade, valor);
            produto.setIdProduto(idProduto);
            connection.closeConnection();
            return produto;
        } else {
            mensagem = "Porduto não encontrado com o nome fornecido.";
            connection.closeConnection();
            return null;
        }
    }
}