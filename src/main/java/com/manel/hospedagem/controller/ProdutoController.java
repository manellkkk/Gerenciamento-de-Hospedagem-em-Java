package com.manel.hospedagem.controller;

import com.manel.hospedagem.dao.ProdutoDAO;
import com.manel.hospedagem.dto.ProdutoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
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
        
        ProdutoDTO produto = new ProdutoDTO(0, nome, qtd, dValor);
        
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
    
    public Boolean removerProduto(int idProduto){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        try {
            produtoDAO.removerProduto(idProduto);
            mensagem = "Produto removido com sucesso.";
            JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException ex) {
            mensagem = produtoDAO.getMensagem();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<ProdutoDTO> selecionarTodos(){
        ArrayList<ProdutoDTO> produtos = new ArrayList();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        try {
            produtos = produtoDAO.selecionarTodos();
            return produtos;
        } catch (SQLException ex) {
            mensagem = "Não foi possível selecionar: ";
            mensagem += ex.getMessage();
            return null;
        }
    }
    
    public ArrayList<ProdutoDTO> selecionarPorNome(String nome) throws SQLException{
        ArrayList<ProdutoDTO> produtos = new ArrayList();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        produtos = produtoDAO.selecionarPorNome(nome);
        return produtos;
    }
    
    public ArrayList<ProdutoDTO> selecionarPorID(String id) throws SQLException{
        ArrayList<ProdutoDTO> produtos = new ArrayList();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        produtos = produtoDAO.selecionarPorID(id);
        return produtos;
    }
}