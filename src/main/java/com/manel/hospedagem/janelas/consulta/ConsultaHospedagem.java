package com.manel.hospedagem.janelas.consulta;

import com.manel.hospedagem.controller.ClienteController;
import com.manel.hospedagem.controller.HospedagemController;
import com.manel.hospedagem.controller.JanelaController;
import com.manel.hospedagem.dto.ClienteDTO;
import com.manel.hospedagem.dto.HospedagemDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaHospedagem extends javax.swing.JFrame {
    HospedagemController hospedagemController = new HospedagemController();
    JanelaController janelaController = new JanelaController();
    
    GerenciarHospedagem gerenciarHospedagem = null;
    
    public ConsultaHospedagem() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        carregarTabelaHospedagem();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsultaHospedagem = new javax.swing.JPanel();
        lblConsultarPor = new javax.swing.JLabel();
        cbConsulta = new javax.swing.JComboBox<>();
        txtConsulta = new javax.swing.JFormattedTextField();
        btnConsulta = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tblHospedagem = new javax.swing.JTable();
        lblFiltrar = new javax.swing.JLabel();
        cbFiltro = new javax.swing.JComboBox<>();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnGerenciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de hospedagem");

        lblConsultarPor.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblConsultarPor.setText("Consultar por:");

        cbConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Quarto" }));

        btnConsulta.setText("Consultar");

        tblHospedagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
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
        tblHospedagem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblHospedagem.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tblHospedagem);
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

        lblFiltrar.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblFiltrar.setText("Filtrar por:");

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aberta", "Fechada", "Ordem de chegada", "Ordem de saída", "Nenhum" }));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnGerenciar.setText("Gerenciar");
        btnGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConsultaHospedagemLayout = new javax.swing.GroupLayout(panelConsultaHospedagem);
        panelConsultaHospedagem.setLayout(panelConsultaHospedagemLayout);
        panelConsultaHospedagemLayout.setHorizontalGroup(
            panelConsultaHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaHospedagemLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelConsultaHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultaHospedagemLayout.createSequentialGroup()
                        .addComponent(lblFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelConsultaHospedagemLayout.createSequentialGroup()
                        .addGroup(panelConsultaHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane)
                            .addGroup(panelConsultaHospedagemLayout.createSequentialGroup()
                                .addComponent(lblConsultarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbConsulta, 0, 174, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsulta))
                            .addGroup(panelConsultaHospedagemLayout.createSequentialGroup()
                                .addComponent(btnGerenciar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFechar)))
                        .addGap(25, 25, 25))))
        );
        panelConsultaHospedagemLayout.setVerticalGroup(
            panelConsultaHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaHospedagemLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelConsultaHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsultarPor)
                    .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConsultaHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltrar)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(panelConsultaHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnExcluir)
                    .addComponent(btnGerenciar))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelConsultaHospedagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsultaHospedagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String id = selecionarIDLinha();
        if (id == null) {
            return;
        }
        try {
            excluirLinha(id);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarActionPerformed
        String id = selecionarIDLinha();
        if (id == null) {
            return;
        }
        try {
            gerenciarHospedagem = janelaController.abrirJanelaGerenciarHospedagem(gerenciarHospedagem, id);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar hospedagem.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_btnGerenciarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGerenciar;
    private javax.swing.JComboBox<String> cbConsulta;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JLabel lblConsultarPor;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JPanel panelConsultaHospedagem;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tblHospedagem;
    private javax.swing.JFormattedTextField txtConsulta;
    // End of variables declaration//GEN-END:variables

    private void carregarTabelaHospedagem() throws SQLException{
        tblHospedagem.getTableHeader().setReorderingAllowed(false);
        ArrayList<HospedagemDTO> hospedagens = hospedagemController.selecionarTodos();
        carregarTabela(hospedagens);
    }
    
    private void carregarTabela(ArrayList<HospedagemDTO> hospedagens) throws SQLException{
        ClienteController clienteController = new ClienteController();

        ClienteDTO clienteDTO = null;
        
        
        DefaultTableModel modeloTabela = (DefaultTableModel) tblHospedagem.getModel();
        modeloTabela.setRowCount(0);
        if (hospedagens != null && !hospedagens.isEmpty()){
            for (HospedagemDTO hospedagem : hospedagens){
                clienteDTO = clienteController.selecionarCliente(hospedagem.getCpfCliente());
                modeloTabela.addRow(new Object[]{
                    hospedagem.getIdHospedagem(),
                    clienteDTO.getNome(),
                    hospedagem.getValor(),
                    hospedagem.getDataEntrada(),
                    hospedagem.getDataSaida(),
                    hospedagem.getQuarto()
                });
            }
        }
    }
    
    private void excluirLinha(String id) throws SQLException{
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            hospedagemController.removerHospedagem(id);
            carregarTabelaHospedagem();
        }
    }
    
    private String selecionarIDLinha() {
        int linhaSelecionada = tblHospedagem.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        DefaultTableModel modeloTabela = (DefaultTableModel) tblHospedagem.getModel();
        return String.valueOf(modeloTabela.getValueAt(linhaSelecionada, 0));
    }
}