package com.manel.hospedagem.dao;

import com.manel.hospedagem.database.DatabaseConnection;
import com.manel.hospedagem.dto.ProdutoDTO;
import com.manel.hospedagem.dto.ConsumoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ConsumoDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
    
    public Boolean adicionarConsumo(ConsumoDTO produtoConsumido){
        try{
            connection.openConnection();

            String query = "INSERT INTO produtoconsumido (fk_produto, fk_hospedagem, dataConsumo, quantidade, valorTotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, produtoConsumido.getIdProduto());
            statement.setInt(2, produtoConsumido.getIdHospedagem());
            statement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            statement.setInt(4, produtoConsumido.getQuantidade());
            statement.setDouble(5, produtoConsumido.getValorTotal());
            statement.executeUpdate();

            mensagem = "Inserido com sucesso.";
            return true;
        } catch(SQLException ex){
            mensagem = "Não foi possível inserir: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return false;
        } finally{
            connection.closeConnection();
        }
    }
    
    public void removerConsumo(int consumo) throws SQLException {
        try{
            connection.openConnection();
        
            String query = "DELETE FROM produtoconsumido WHERE idProdutoConsumido = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, consumo);
            statement.executeUpdate();
            mensagem = "Excluído.";

            connection.closeConnection();
        } catch(SQLException ex){
            mensagem = "Erro ao tentar excluir";
        }
    }
    
    public ArrayList<ConsumoDTO> selecionarPorHospedagem(int id){
        ArrayList<ConsumoDTO> consumos = new ArrayList();
        try{
            String query = "SELECT * FROM produtoconsumido WHERE fk_hospedagem = ?";
            connection.openConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idProdutoConsumido = resultSet.getInt("idProdutoConsumido");
                int idProduto = resultSet.getInt("fk_produto");
                int idHospedagem = resultSet.getInt("fk_hospedagem");
                int quantidade = resultSet.getInt("quantidade");
                Date dataConsumo = resultSet.getDate("dataConsumo");
                double valorTotal = resultSet.getDouble("valorTotal");

                ConsumoDTO consumo = new ConsumoDTO(idProdutoConsumido, idProduto, idHospedagem, (java.sql.Date) dataConsumo, quantidade, valorTotal);
                consumos.add(consumo);
            }
            return consumos;
        } catch(SQLException ex){
            mensagem = "Não deu de selecionar.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return null;
        } finally{
            connection.closeConnection();
        }
    }
    
    public ArrayList<ConsumoDTO> selecionarTodos(){
        ArrayList<ConsumoDTO> consumos = new ArrayList();
        try{
            String query = "SELECT * FROM produtoconsumido";
            connection.openConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idProdutoConsumido = resultSet.getInt("idProdutoConsumido");
                int idProduto = resultSet.getInt("fk_produto");
                int idHospedagem = resultSet.getInt("fk_hospedagem");
                int quantidade = resultSet.getInt("quantidade");
                Date dataConsumo = resultSet.getDate("dataConsumo");
                double valorTotal = resultSet.getDouble("valorTotal");

                ConsumoDTO consumo = new ConsumoDTO(idProdutoConsumido, idProduto, idHospedagem, (java.sql.Date) dataConsumo, quantidade, valorTotal);
                consumos.add(consumo);
            }
            return consumos;
        } catch(SQLException ex){
            mensagem = "Não deu de selecionar.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return null;
        } finally{
            connection.closeConnection();
        }
    }
    
    public ConsumoDTO selecionarConsumo(int id) throws SQLException {
        connection.openConnection();

        String query = "SELECT idProduto, nome, quantidade, valor FROM produto WHERE idProduto = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int idProdutoConsumido = resultSet.getInt("idProdutoConsumido");
            int idProduto = resultSet.getInt("fk_produto");
            int idHospedagem = resultSet.getInt("fk_hospedagem");
            int quantidade = resultSet.getInt("quantidade");
            Date dataConsumo = resultSet.getDate("dataConsumo");
            double valorTotal = resultSet.getDouble("valorTotal");
                
            ConsumoDTO consumoDTO = new ConsumoDTO(idProdutoConsumido, idProduto, idHospedagem, (java.sql.Date) dataConsumo, quantidade, valorTotal);
            
            connection.closeConnection();
            return consumoDTO;
        } else {
            mensagem = "Consumo não encontrado com o ID fornecido.";
            connection.closeConnection();
            return null;
        }
    }
}