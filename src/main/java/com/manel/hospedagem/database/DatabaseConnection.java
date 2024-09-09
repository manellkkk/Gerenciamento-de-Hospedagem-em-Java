package com.manel.hospedagem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private String URL = "jdbc:mysql://localhost:3306/hospedagemulysses";
    private String USER = "root";
    private String PASSWORD = "";
    private String mensagem = "";
    
    private Connection connection;
    
    public void openConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            mensagem = "Conectado.";
        } catch (ClassNotFoundException e) {
            mensagem = "Erro ao conectar no banco: ";
            mensagem += e.getMessage();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                mensagem = "Desconectado.";
            } catch (SQLException e) {
                mensagem = "Erro ao desconectar no banco: ";
                mensagem += e.getMessage();
                JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public PreparedStatement prepareStatement(String query){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            return statement;
        } catch (SQLException ex) {
            mensagem = ex.getMessage();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}