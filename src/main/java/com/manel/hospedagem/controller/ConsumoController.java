package com.manel.hospedagem.controller;

import com.manel.hospedagem.dao.ProdutoDAO;
import com.manel.hospedagem.dao.ConsumoDAO;
import com.manel.hospedagem.dto.ConsumoDTO;
import com.manel.hospedagem.dto.ProdutoDTO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

public class ConsumoController {
    private ProdutoController produtoController = new ProdutoController();
    private ConsumoDAO produtoConsumidoDAO = new ConsumoDAO();
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public Boolean adicionarConsumo(int idProduto, int idHospedagem, int quantidade, double valorTotal){
        
        ConsumoDTO produtoConsumido = new ConsumoDTO(0, idProduto, idHospedagem, null, quantidade, valorTotal);
         
        ProdutoDTO produtoDTO = produtoController.selecionarProduto(idProduto);
        if(quantidade > produtoDTO.getQuantidade() || quantidade == 0){
            JOptionPane.showMessageDialog(null, "Quantidade inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(produtoConsumidoDAO.adicionarConsumo(produtoConsumido)){
           produtoController.alterarQuantidade(idProduto, produtoDTO.getQuantidade() - quantidade); 
           return true;
        } else{
            mensagem = "Não foi possível inserir.";
            return false;
        }
    }
    
    public Boolean removerConsumo(int consumo){
        ConsumoDAO consumoDAO = new ConsumoDAO();
        try {
            consumoDAO.removerConsumo(consumo);
            
            ConsumoDTO consumoDTO = consumoDAO.selecionarConsumo(consumo);
            
            ProdutoDAO produtoDAO = new ProdutoDAO();
            ProdutoDTO produtoDTO = produtoDAO.selecionarProduto(consumoDTO.getIdProduto());
            
            int novaQuantidade = consumoDTO.getQuantidade() + produtoDTO.getQuantidade();
            int idProduto = consumoDTO.getIdProduto();
            
            produtoDAO.alterarQuantidade(idProduto, novaQuantidade);
            
            mensagem = "Consumo removido com sucesso.";
            JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException ex) {
            mensagem = consumoDAO.getMensagem();
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<ConsumoDTO> selecionarTodos(){
        ArrayList<ConsumoDTO> produtosConsumidos = new ArrayList();
        ConsumoDAO produtoConsumidosDAO = new ConsumoDAO();
        produtosConsumidos = produtoConsumidosDAO.selecionarTodos();
        return produtosConsumidos;
    }
    
    public ArrayList<ConsumoDTO> selecionarPorHospedagem(int id){
        ArrayList<ConsumoDTO> produtosConsumidos = new ArrayList();
        ConsumoDAO produtoConsumidosDAO = new ConsumoDAO();
        produtosConsumidos = produtoConsumidosDAO.selecionarPorHospedagem(id);
        return produtosConsumidos;
    }
}