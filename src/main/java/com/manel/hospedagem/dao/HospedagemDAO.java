package com.manel.hospedagem.dao;

import com.manel.hospedagem.database.DatabaseConnection;
import com.manel.hospedagem.dto.HospedagemDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HospedagemDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private String mensagem;
    
    public void adicionarHospedagem(HospedagemDTO hospedagem) throws SQLException{
        connection.openConnection();
        
        String query = "INSERT INTO hospedagem (fk_cliente, valor, dataEntrada, quarto) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, hospedagem.getCpfCliente());
        statement.setDouble(2, hospedagem.getValor());
        statement.setDate(3, new java.sql.Date(hospedagem.getDataEntrada().getTime()));
        statement.setInt(4, hospedagem.getQuarto());
        statement.executeUpdate();
        mensagem = "Inserido com sucesso.";
        
        connection.closeConnection();
    }
    
    public Boolean removerHospedagem(String id){
        int idHospedagem = 0;
        try{
            connection.openConnection();
        
            idHospedagem = Integer.parseInt(id);

            String query = "DELETE FROM hospedagem WHERE idHospedagem = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idHospedagem);
            statement.executeUpdate();
            mensagem = "Excluído com sucesso.";

            connection.closeConnection();
        } catch(NumberFormatException | SQLException ex){
            JOptionPane.showMessageDialog(null, idHospedagem);
        }
        return false;
    }
    
    public Boolean finalizarHospedagem(int id){
        java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());

        try{
            connection.openConnection();

            String query = "UPDATE hospedagem SET dataSaida = ? WHERE idHospedagem = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, dataAtual);
            statement.setInt(2, id);
            statement.executeUpdate();
            mensagem = "Finalizado com sucesso.";

            connection.closeConnection();
        } catch(NumberFormatException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível finalizar.");
        }
        return false;
    }
    
    public Boolean verificarQuartoOcupado(int quarto) {
        int idHospedagem = 0;
        try{
            connection.openConnection();

            String query = "SELECT dataSaida FROM hospedagem WHERE quarto = ? AND dataSaida IS NULL";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, quarto);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    mensagem = "Quarto disponível ou sem registro de hospedagem em aberto.";
                    return false;
                }
            }
        } catch(NumberFormatException | SQLException ex){
            JOptionPane.showMessageDialog(null, idHospedagem);
        }
        return false;
    }
    
    public Boolean verificarHospedagemFinalizada(int id) {
        try{
            connection.openConnection();

            String query = "SELECT dataSaida FROM hospedagem WHERE idHospedagem = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Date dataSaida = resultSet.getDate("dataSaida");
                    return dataSaida != null;
                } else {
                    return false;
                }
            }
        } catch(NumberFormatException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o estado da hospedagem.");
        }
        mensagem = "Hospedagem fechada.";
        return false;
    }
    
    public ArrayList<HospedagemDTO> selecionarTodos() throws SQLException {
        String query = "SELECT * FROM hospedagem";
        ArrayList<HospedagemDTO> hospedagens = new ArrayList();
        
        connection.openConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int idHospedagem = resultSet.getInt("idHospedagem");
            String cpfCliente = resultSet.getString("fk_cliente");
            double valor = resultSet.getDouble("valor");
            Date dataEntrada = resultSet.getDate("dataEntrada");
            Date dataSaida = resultSet.getDate("dataSaida");
            int quarto = resultSet.getInt("quarto");
            
            HospedagemDTO hospedagem = new HospedagemDTO(idHospedagem, cpfCliente, valor, dataEntrada, dataSaida, quarto);
            hospedagens.add(hospedagem);
        }
        connection.closeConnection();
        return hospedagens;
    }
    
    public HospedagemDTO selecionarHospedagem(String id) throws SQLException {
        String query = "SELECT * FROM hospedagem WHERE idHospedagem = ?";
        HospedagemDTO hospedagem = selecionarHospedagemBanco(query, id);
        return hospedagem;
    }
    
    private HospedagemDTO selecionarHospedagemBanco(String query, String target) throws SQLException{
        connection.openConnection();
        
        int idHospedagem = Integer.parseInt(target);
        
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idHospedagem);
        ResultSet resultSet = statement.executeQuery();

        HospedagemDTO hospedagem = null;

        if (resultSet.next()) {
            String cpfCliente = resultSet.getString("fk_cliente");
            double valor = resultSet.getDouble("valor");
            Date dataEntrada = resultSet.getDate("dataEntrada");
            Date dataSaida = resultSet.getDate("dataSaida");
            int quarto = resultSet.getInt("quarto");

            hospedagem = new HospedagemDTO(idHospedagem, cpfCliente, valor, dataEntrada, dataSaida, quarto);
        }

        connection.closeConnection();
        return hospedagem;
    }

    public String getMensagem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}