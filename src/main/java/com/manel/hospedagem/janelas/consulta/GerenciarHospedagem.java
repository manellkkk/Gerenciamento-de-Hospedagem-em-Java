package com.manel.hospedagem.janelas.consulta;

import com.manel.hospedagem.controller.ClienteController;
import com.manel.hospedagem.controller.ConsumoController;
import com.manel.hospedagem.controller.HospedagemController;
import com.manel.hospedagem.controller.JanelaController;
import com.manel.hospedagem.controller.ProdutoController;
import com.manel.hospedagem.dto.ClienteDTO;
import com.manel.hospedagem.dto.HospedagemDTO;
import com.manel.hospedagem.dto.ProdutoConsumidoDTO;
import com.manel.hospedagem.dto.ProdutoDTO;
import static com.manel.hospedagem.janelas.Principal.JanelaHospedagem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GerenciarHospedagem extends javax.swing.JFrame {
    HospedagemController hospedagemController = new HospedagemController();
    ClienteController clienteController = new ClienteController();
    JanelaController janelaController = new JanelaController();
    
    
    ProdutoController produtoController = new ProdutoController();
    ConsumoController consumoController = new ConsumoController();
    
    ProdutoDTO produtoDTO = null;
    ConsultaProduto conProduto = null;
    
    HospedagemDTO hospedagemDTO;
    ClienteDTO clienteDTO;
    
    private final String idHospedagem;
    
    public GerenciarHospedagem(String id) throws SQLException{
        initComponents();
        this.idHospedagem = id;
        this.hospedagemDTO = hospedagemController.selecionarHospedagem(id);
        this.clienteDTO = clienteController.selecionarCliente(hospedagemDTO.getCpfCliente());
        atualizarHospedagem();
        verificarFinalizar();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblConsultarPor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHospedagem = new javax.swing.JTable();
        lblConsultarPor1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsumo = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JToggleButton();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar hospedagem");

        lblConsultarPor.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblConsultarPor.setText("Informações do cliente");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblHospedagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Diária", "Data entrada", "Data saída", "Quarto", "Consumo", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHospedagem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblHospedagem.setRowHeight(30);
        tblHospedagem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblHospedagem);
        if (tblHospedagem.getColumnModel().getColumnCount() > 0) {
            tblHospedagem.getColumnModel().getColumn(0).setResizable(false);
            tblHospedagem.getColumnModel().getColumn(1).setResizable(false);
            tblHospedagem.getColumnModel().getColumn(2).setResizable(false);
            tblHospedagem.getColumnModel().getColumn(3).setResizable(false);
            tblHospedagem.getColumnModel().getColumn(4).setResizable(false);
            tblHospedagem.getColumnModel().getColumn(5).setResizable(false);
            tblHospedagem.getColumnModel().getColumn(6).setResizable(false);
            tblHospedagem.getColumnModel().getColumn(7).setResizable(false);
        }

        lblConsultarPor1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblConsultarPor1.setText("Informações do consumo");

        tblConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data", "Quantidade", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblConsumo);
        if (tblConsumo.getColumnModel().getColumnCount() > 0) {
            tblConsumo.getColumnModel().getColumn(0).setResizable(false);
            tblConsumo.getColumnModel().getColumn(1).setResizable(false);
            tblConsumo.getColumnModel().getColumn(2).setResizable(false);
            tblConsumo.getColumnModel().getColumn(3).setResizable(false);
            tblConsumo.getColumnModel().getColumn(4).setResizable(false);
        }

        btnSalvar.setText("Fechar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addComponent(lblConsultarPor1)
                    .addComponent(lblConsultarPor)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblConsultarPor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblConsultarPor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnSalvar))
                .addGap(224, 224, 224))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja finalizar?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            hospedagemController.finalizarHospedagem(hospedagemDTO.getIdHospedagem());
        }
        atualizarHospedagem();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        int id = Integer.valueOf(idHospedagem);
        conProduto = janelaController.abrirJanelaConsultaProduto(conProduto, JanelaHospedagem, id);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        carregarTabelaConsumo();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JToggleButton btnFinalizar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblConsultarPor;
    private javax.swing.JLabel lblConsultarPor1;
    private javax.swing.JTable tblConsumo;
    private javax.swing.JTable tblHospedagem;
    // End of variables declaration//GEN-END:variables

    private void carregarTabelaHospedagem(){
        tblHospedagem.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel modeloTabela = (DefaultTableModel) tblHospedagem.getModel(); 
        modeloTabela.setRowCount(0);
        modeloTabela.addRow(new Object[]{
            hospedagemDTO.getIdHospedagem(),
            clienteDTO.getNome(),
            hospedagemDTO.getValor(),
            hospedagemDTO.getDataEntrada(),
            hospedagemDTO.getDataSaida(),
            hospedagemDTO.getQuarto()
        });
    }
    
    private void carregarTabelaConsumo(){
        tblConsumo.getTableHeader().setReorderingAllowed(false);
        ArrayList<ProdutoConsumidoDTO> produtosConsumidos = consumoController.selecionarTodos();
        carregarTabela(produtosConsumidos);
    }
    
    private void carregarTabela(ArrayList<ProdutoConsumidoDTO> produtosConsumidos){
        DefaultTableModel modeloTabela = (DefaultTableModel) tblConsumo.getModel(); 
        modeloTabela.setRowCount(0);
        
        ProdutoDTO produtoDTO = null;

        if (produtosConsumidos != null && !produtosConsumidos.isEmpty()){
            for (ProdutoConsumidoDTO produto : produtosConsumidos){
                produtoDTO = produtoController.selecionarProduto(produto.getIdProduto());

                modeloTabela.addRow(new Object[]{
                    produtoDTO.getNome(),
                    produto.getIdProduto(),
                    produto.getData(),
                    produto.getQuantidade(),
                    produto.getValorTotal()
                });
            }
        }
    }
    
    private void atualizarHospedagem(){
        try {
            hospedagemDTO = hospedagemController.selecionarHospedagem(idHospedagem);
            clienteDTO = clienteController.selecionarCliente(hospedagemDTO.getCpfCliente());
            carregarTabelaHospedagem();
            verificarFinalizar();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void verificarFinalizar(){
        if(hospedagemController.verificarHospedagem(hospedagemDTO.getIdHospedagem())){
            btnFinalizar.setEnabled(false);
        } else{
            btnFinalizar.setEnabled(true);
        }
    }
}