package com.manel.hospedagem.janelas;

import com.manel.hospedagem.controller.JanelaController;
import com.manel.hospedagem.janelas.cadastro.CadastroProduto;
import com.manel.hospedagem.janelas.cadastro.CadastroCliente;
import com.manel.hospedagem.janelas.consulta.ConsultaCliente;
import com.manel.hospedagem.janelas.consulta.ConsultaHospedagem;
import com.manel.hospedagem.janelas.consulta.ConsultaProduto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Principal extends javax.swing.JFrame {
    public static final String JanelaCadastro = "JanelaCadastro";
    public static final String JanelaConsulta = "JanelaConsulta";
    public static final String JanelaHospedagem = "JanelaHospedagem";
    
    JanelaController janelaController = new JanelaController();
    CadastroCliente cadCliente = null;
    ConsultaCliente conCliente = null;
    CadastroProduto cadProduto = null;
    ConsultaProduto conProduto = null;
    ConsultaHospedagem conHospedagem = null;
    
    public Principal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barPrincipal = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        itemCliente = new javax.swing.JMenuItem();
        itemProduto = new javax.swing.JMenuItem();
        itemHospedagem = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenu();
        itemClientes = new javax.swing.JMenuItem();
        itemProdutos = new javax.swing.JMenuItem();
        itemHospedagens = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de hospedagem");
        setName("Hospedagem"); // NOI18N
        setPreferredSize(new java.awt.Dimension(720, 480));

        menuCadastro.setText("Cadastro");

        itemCliente.setText("Cliente");
        itemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(itemCliente);

        itemProduto.setText("Produto");
        itemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProdutoActionPerformed(evt);
            }
        });
        menuCadastro.add(itemProduto);

        itemHospedagem.setText("Hospedagem");
        itemHospedagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHospedagemActionPerformed(evt);
            }
        });
        menuCadastro.add(itemHospedagem);

        barPrincipal.add(menuCadastro);

        menuConsulta.setText("Consulta");

        itemClientes.setText("Cliente");
        itemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClientesActionPerformed(evt);
            }
        });
        menuConsulta.add(itemClientes);

        itemProdutos.setText("Produto");
        itemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProdutosActionPerformed(evt);
            }
        });
        menuConsulta.add(itemProdutos);

        itemHospedagens.setText("Hospedagem");
        itemHospedagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHospedagensActionPerformed(evt);
            }
        });
        menuConsulta.add(itemHospedagens);

        barPrincipal.add(menuConsulta);

        setJMenuBar(barPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClienteActionPerformed
        cadCliente = janelaController.abrirJanelaCadastroCliente(cadCliente);
    }//GEN-LAST:event_itemClienteActionPerformed

    private void itemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProdutoActionPerformed
        cadProduto = janelaController.abrirJanelaCadastroProduto(cadProduto);
    }//GEN-LAST:event_itemProdutoActionPerformed

    private void itemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClientesActionPerformed
        conCliente = janelaController.abrirJanelaConsultaCliente(conCliente, JanelaConsulta);
    }//GEN-LAST:event_itemClientesActionPerformed

    private void itemHospedagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHospedagemActionPerformed
        conCliente = janelaController.abrirJanelaConsultaCliente(conCliente, JanelaCadastro);
    }//GEN-LAST:event_itemHospedagemActionPerformed

    private void itemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProdutosActionPerformed
        conProduto = janelaController.abrirJanelaConsultaProduto(conProduto, "Principal", 0);
    }//GEN-LAST:event_itemProdutosActionPerformed

    private void itemHospedagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHospedagensActionPerformed
        try {
            conHospedagem = janelaController.abrirJanelaConsultaHospedagem(conHospedagem);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemHospedagensActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barPrincipal;
    private javax.swing.JMenuItem itemCliente;
    private javax.swing.JMenuItem itemClientes;
    private javax.swing.JMenuItem itemHospedagem;
    private javax.swing.JMenuItem itemHospedagens;
    private javax.swing.JMenuItem itemProduto;
    private javax.swing.JMenuItem itemProdutos;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuConsulta;
    // End of variables declaration//GEN-END:variables
    
    
}