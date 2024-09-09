package com.manel.hospedagem.janelas.consulta;

import com.manel.hospedagem.controller.ClienteController;
import com.manel.hospedagem.dto.ClienteDTO;
import com.manel.hospedagem.janelas.cadastro.CadastroCliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class ConsultaCliente extends javax.swing.JFrame {
    ClienteController clienteController = new ClienteController();
    
    public ConsultaCliente() throws ParseException {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        carregarTabelaCliente();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsultaCliente = new javax.swing.JPanel();
        cbConsulta = new javax.swing.JComboBox<>();
        lblConsultarPor = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        spConsulta = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        txtConsulta = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF" }));
        cbConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConsultaActionPerformed(evt);
            }
        });

        lblConsultarPor.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblConsultarPor.setText("Consultar por:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Telefone", "Placa do carro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spConsulta.setViewportView(tblCliente);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");

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

        javax.swing.GroupLayout panelConsultaClienteLayout = new javax.swing.GroupLayout(panelConsultaCliente);
        panelConsultaCliente.setLayout(panelConsultaClienteLayout);
        panelConsultaClienteLayout.setHorizontalGroup(
            panelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaClienteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spConsulta)
                    .addGroup(panelConsultaClienteLayout.createSequentialGroup()
                        .addGroup(panelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelConsultaClienteLayout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir))
                            .addGroup(panelConsultaClienteLayout.createSequentialGroup()
                                .addComponent(lblConsultarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFechar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelConsultaClienteLayout.setVerticalGroup(
            panelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaClienteLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsultarPor)
                    .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnFechar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsultaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConsultaActionPerformed
        try {
            int index = cbConsulta.getSelectedIndex();
            
            if(index == 1){
                MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
                cpfMask.setPlaceholderCharacter('_');
                txtConsulta.setValue(null);
                txtConsulta.setFormatterFactory(new DefaultFormatterFactory(cpfMask));
            } else{
                txtConsulta.setValue(null);
                txtConsulta.setFormatterFactory(null);
                txtConsulta.setText("");
            }
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbConsultaActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroCliente cadCliente = new CadastroCliente();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String selecionado = (String) cbConsulta.getSelectedItem();
        if(txtConsulta.getText().isEmpty()){
            carregarTabelaCliente();
            return;
        }
        try {
            consultar(selecionado);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DefaultTableModel modeloTabela = (DefaultTableModel) tblCliente.getModel();
        int linhaSelecionada = tblCliente.getSelectedRow();
        String cpf = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
        
        try {
            excluirLinha(cpf);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        linhaSelecionada = -1;
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> cbConsulta;
    private javax.swing.JLabel lblConsultarPor;
    private javax.swing.JPanel panelConsultaCliente;
    private javax.swing.JScrollPane spConsulta;
    private javax.swing.JTable tblCliente;
    private javax.swing.JFormattedTextField txtConsulta;
    // End of variables declaration//GEN-END:variables
    private void carregarTabelaCliente(){
        ArrayList<ClienteDTO> clientes = clienteController.selecionarTodos();
        carregarTabela(clientes);
    }
    
    private void selecionarPorNome(String nome) throws SQLException{
        ArrayList<ClienteDTO> clientes = clienteController.selecionarPorNome(nome);
        carregarTabela(clientes);
    }
    
    private void selecionarPorCPF(String cpf) throws SQLException{
        ArrayList<ClienteDTO> clientes = clienteController.selecionarPorCPF(cpf);
        carregarTabela(clientes);
    }
    
    private void excluirLinha(String cpf) throws SQLException{
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            clienteController.removerCliente(cpf);
            carregarTabelaCliente();
        }
    }
    
    private void consultar(String selecionado) throws SQLException{
        if("Nome".equals(selecionado)){
            selecionarPorNome(txtConsulta.getText());
        } else{
            selecionarPorCPF(txtConsulta.getText());
        }
    }
    
    private void carregarTabela(ArrayList<ClienteDTO> clientes){
        DefaultTableModel modeloTabela = (DefaultTableModel) tblCliente.getModel(); 
        modeloTabela.setRowCount(0);
        if (clientes != null && !clientes.isEmpty()){
            for (ClienteDTO cliente : clientes){
                modeloTabela.addRow(new Object[]{
                    cliente.getNome(),
                    cliente.getCPF(),
                    cliente.getTelefone(),
                    cliente.getPlacaDoCarro()
                });
            }
        }
    }
}
