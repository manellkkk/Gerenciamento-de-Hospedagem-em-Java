package com.manel.hospedagem.dao;

import com.manel.hospedagem.database.DatabaseConnection;
import com.manel.hospedagem.dto.ProdutoConsumidoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ProdutoConsumidoDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
    public void adicionarConsumo(ProdutoConsumidoDTO produtoConsumido){
        try{
            connection.openConnection();
        
            String query = "INSERT INTO produtoConsumido (fk_produto, fk_hospedagem, data, quantidade, valorTotal) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, produtoConsumido.getIdProduto());
            statement.setInt(2, produtoConsumido.getIdHospedagem());
            statement.setDate(3, produtoConsumido.getData());
            statement.setInt(3, produtoConsumido.getQuantidade());
            statement.setDouble(4, produtoConsumido.getValorTotal());
            statement.executeUpdate();
            mensagem = "Inserido com sucesso.";
        } catch(SQLException ex){
            mensagem = "Não foi possível inserir.";
        } finally{
            connection.closeConnection();
        }
    }
    
    public ArrayList<ProdutoConsumidoDTO> selecionarTodos(){
        try{
            String query = "SELECT * FROM produto";
            ArrayList<ProdutoConsumidoDTO> produtosConsumidos = new ArrayList();

            connection.openConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idProdutoConsumido = resultSet.getInt("idProdutoConsumido");
                int idProduto = resultSet.getInt("fk_produto");
                int idHospedagem = resultSet.getInt("fk_hospedagem");
                Date data = resultSet.getDate("data");
                int quantidade = resultSet.getInt("quantidade");
                double valorTotal = resultSet.getDouble("valorTotal");

                ProdutoConsumidoDTO produtoConsumido = new ProdutoConsumidoDTO(idProdutoConsumido, idProduto, idHospedagem, (java.sql.Date) data, quantidade, valorTotal);
                produtosConsumidos.add(produtoConsumido);
            }
            connection.closeConnection();
            return produtosConsumidos;
        } catch(SQLException ex){
            return null;
        }
    }
}