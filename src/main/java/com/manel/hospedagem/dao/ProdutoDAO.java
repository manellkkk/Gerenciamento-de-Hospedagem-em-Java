package com.manel.hospedagem.dao;

import com.manel.hospedagem.database.DatabaseConnection;
import com.manel.hospedagem.dto.ProdutoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
    
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
    
    public void removerProduto(int idProduto) throws SQLException {
        connection.openConnection();
        
        String query = "DELETE FROM produto WHERE idProduto = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idProduto);
        statement.executeUpdate();
        mensagem = "Excluído.";
        
        connection.closeConnection();
    }
    
    public Boolean alterarQuantidade(int idProduto, int quantidade){
        try{
            connection.openConnection();
            
            String query = "UPDATE produto SET quantidade = ? WHERE idProduto = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, quantidade);
            statement.setInt(2, idProduto);
            statement.executeUpdate();
            mensagem = "Alterado.";
            return true;
        } catch(SQLException ex){
            mensagem = "Não foi possível alterar a quantidade.";
            connection.closeConnection();
            return false;
        }
    }
    
    public ProdutoDTO selecionarProduto(int id) throws SQLException {
        connection.openConnection();

        String query = "SELECT idProduto, nome, quantidade, valor FROM produto WHERE idProduto = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int idProduto = resultSet.getInt("idProduto");
            String nomeProduto = resultSet.getString("nome");
            int quantidade = resultSet.getInt("quantidade");
            double valor = resultSet.getDouble("valor");
            ProdutoDTO produto = new ProdutoDTO(idProduto, nomeProduto, quantidade, valor);
            produto.setIdProduto(idProduto);
            connection.closeConnection();
            return produto;
        } else {
            mensagem = "Produto não encontrado com o ID fornecido.";
            connection.closeConnection();
            return null;
        }
    }
    
    public ArrayList<ProdutoDTO> selecionarTodos() throws SQLException {
        String query = "SELECT * FROM produto";
        ArrayList<ProdutoDTO> produtos = new ArrayList();
        
        connection.openConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int idProduto = resultSet.getInt("idProduto");
            String nome = resultSet.getString("nome");
            int quantidade = resultSet.getInt("quantidade");
            double valor = resultSet.getDouble("valor");
            
            ProdutoDTO cliente = new ProdutoDTO(idProduto, nome, quantidade, valor);
            produtos.add(cliente);
        }
        connection.closeConnection();
        return produtos;
    }
    
    public ArrayList<ProdutoDTO> selecionarPorNome(String nome) throws SQLException{
        String query = "SELECT * FROM produto WHERE nome LIKE ?";
        ArrayList<ProdutoDTO> produtos = new ArrayList();
        produtos = consultarProdutosBanco(query, nome);
        return produtos;
    }
    
    public ArrayList<ProdutoDTO> selecionarPorID(String id) throws SQLException{
        String query = "SELECT * FROM produto WHERE idProduto = ?";
        ArrayList<ProdutoDTO> produtos = new ArrayList();
        produtos = consultarProdutoBanco(query, id);
        return produtos;
    }
    
    private ArrayList<ProdutoDTO> consultarProdutosBanco(String query, String target) throws SQLException{
        connection.openConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + target + "%");
        ResultSet resultSet = statement.executeQuery();
        
        ArrayList<ProdutoDTO> produtos = new ArrayList();
        
        while (resultSet.next()) {
            int idProduto = resultSet.getInt("idProduto");
            String nome = resultSet.getString("nome");
            int quantidade = resultSet.getInt("quantidade");
            double valor = resultSet.getDouble("valor");
            
            ProdutoDTO produto = new ProdutoDTO(idProduto, nome, quantidade, valor);
            produtos.add(produto);
        }
        connection.closeConnection();
        return produtos;
    }
    
    private ArrayList<ProdutoDTO> consultarProdutoBanco(String query, String target) throws SQLException{
        connection.openConnection();
        
        int iTarget = Integer.parseInt(target);
        
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, iTarget);
        ResultSet resultSet = statement.executeQuery();
        
        ArrayList<ProdutoDTO> produtos = new ArrayList();
        
        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            int quantidade = resultSet.getInt("quantidade");
            double valor = resultSet.getDouble("valor");
            
            ProdutoDTO produto = new ProdutoDTO(iTarget, nome, quantidade, valor);
            produtos.add(produto);
        }
        connection.closeConnection();
        return produtos;
    }
}