package com.manel.hospedagem.controller;

import com.manel.hospedagem.dao.ProdutoConsumidoDAO;
import com.manel.hospedagem.dto.ProdutoConsumidoDTO;
import java.util.ArrayList;
import java.util.Date;

public class ConsumoController {
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void adicionarConsumo(int idProduto, int idHospedagem, int quantidade, double valorTotal){
        java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());
        ProdutoConsumidoDTO produtoConsumido = new ProdutoConsumidoDTO(0, idProduto, idHospedagem, dataAtual, quantidade, valorTotal);
        
        ProdutoConsumidoDAO produtoDAO = new ProdutoConsumidoDAO();
        produtoDAO.adicionarConsumo(produtoConsumido);
        mensagem = "Adicionado com sucesso.";
    }
    
    public ArrayList<ProdutoConsumidoDTO> selecionarTodos(){
        ArrayList<ProdutoConsumidoDTO> produtosConsumidos = new ArrayList();
        ProdutoConsumidoDAO produtoConsumidosDAO = new ProdutoConsumidoDAO();
        produtosConsumidos = produtoConsumidosDAO.selecionarTodos();
        return produtosConsumidos;
    }
}