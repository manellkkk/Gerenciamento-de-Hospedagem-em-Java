package com.manel.hospedagem.controller;

import com.manel.hospedagem.dao.ProdutoDAO;
import com.manel.hospedagem.dto.ProdutoDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutoController {
    public String mensagem;
    
    public Boolean adicionarProduto(String nome, String quantidade, String valor){
        int qtd = 0;
        double dValor = 0;
        try{
            qtd = Integer.parseInt(quantidade);
            dValor = Double.parseDouble(valor);
        } catch(NumberFormatException e){
            mensagem = "Parâmetros inválidos.";
        }
        
        if(nome.isEmpty()){
            mensagem = "Nome inválido.";
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(qtd == 0 || dValor == 0){
            mensagem = "Quantidade e/ou valor inválido(s)";
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        ProdutoDTO produto = new ProdutoDTO(nome, qtd, dValor);
        
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.adicionarProduto(produto);
            mensagem = "Produto criado com sucesso.";
            JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            mensagem = "Erro ao criar produto ";
            mensagem += e.getMessage();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean removerProduto(String nome, int quantidade, double valor){
        ProdutoDTO produto = new ProdutoDTO(nome, quantidade, valor);
        
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.removerProduto(produto);
            mensagem = "Produto excluído com sucesso.";
            JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            mensagem = "Erro ao remover produto: ";
            mensagem += e.getMessage();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}