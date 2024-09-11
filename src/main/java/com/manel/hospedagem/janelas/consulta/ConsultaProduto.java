package com.manel.hospedagem.janelas.consulta;

import com.manel.hospedagem.controller.JanelaController;
import com.manel.hospedagem.controller.ProdutoController;
import com.manel.hospedagem.dto.ProdutoDTO;
import com.manel.hospedagem.janelas.EntradaConfig;
import static com.manel.hospedagem.janelas.EntradaConfig.permitirNumero;
import com.manel.hospedagem.janelas.cadastro.CadastroProduto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ConsultaProduto extends javax.swing.JFrame {
    JanelaController janelaController = new JanelaController();
    ProdutoController produtoController = new ProdutoController();
    EntradaConfig entradaConfig = new EntradaConfig();
    
    CadastroProduto cadProduto = null;
    
    public ConsultaProduto() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        carregarTabelaProduto();
        verificarSelecao();
        fecharConfig();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsultaProduto = new javax.swing.JPanel();
        lblConsultarPor = new javax.swing.JLabel();
        cbConsulta = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();
        txtConsulta = new javax.swing.JTextField();
        spConsulta = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de produto");

        lblConsultarPor.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblConsultarPor.setText("Consultar por:");

        cbConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome" }));
        cbConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConsultaActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Preço"
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
        tblProduto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spConsulta.setViewportView(tblProduto);

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

        javax.swing.GroupLayout panelConsultaProdutoLayout = new javax.swing.GroupLayout(panelConsultaProduto);
        panelConsultaProduto.setLayout(panelConsultaProdutoLayout);
        panelConsultaProdutoLayout.setHorizontalGroup(
            panelConsultaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaProdutoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelConsultaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultaProdutoLayout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelConsultaProdutoLayout.createSequentialGroup()
                            .addComponent(lblConsultarPor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnConsultar))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelConsultaProdutoLayout.setVerticalGroup(
            panelConsultaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaProdutoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelConsultaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsultarPor)
                    .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panelConsultaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnFechar))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsultaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsultaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        if (janelaController.cadastroAbertoProduto(cadProduto) == false){
            dispose();
        } else{
            cadProduto.toFront();
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        cadProduto = janelaController.abrirJanelaCadastroProduto(cadProduto);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int idProduto = selecionarIDLinha();
        if (idProduto == 0) {
            return;
        }
        try {
            excluirLinha(idProduto);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String selecionado = (String) cbConsulta.getSelectedItem();
        if(txtConsulta.getText().isEmpty()){
            carregarTabelaProduto();
            return;
        }
        try {
            consultar(selecionado);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void cbConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConsultaActionPerformed
        limparConsulta();
        verificarSelecao();
    }//GEN-LAST:event_cbConsultaActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> cbConsulta;
    private javax.swing.JLabel lblConsultarPor;
    private javax.swing.JPanel panelConsultaProduto;
    private javax.swing.JScrollPane spConsulta;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtConsulta;
    // End of variables declaration//GEN-END:variables

    private void carregarTabelaProduto(){
        tblProduto.getTableHeader().setReorderingAllowed(false);
        ArrayList<ProdutoDTO> produtos = produtoController.selecionarTodos();
        carregarTabela(produtos);
    }
    
    private void carregarTabela(ArrayList<ProdutoDTO> produtos){
        DefaultTableModel modeloTabela = (DefaultTableModel) tblProduto.getModel(); 
        modeloTabela.setRowCount(0);
        if (produtos != null && !produtos.isEmpty()){
            for (ProdutoDTO produto : produtos){
                modeloTabela.addRow(new Object[]{
                    produto.getIdProduto(),
                    produto.getNome(),
                    produto.getQuantidade(),
                    produto.getValor()
                });
            }
        }
    }
    
    private int selecionarIDLinha() {
        int linhaSelecionada = tblProduto.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
        DefaultTableModel modeloTabela = (DefaultTableModel) tblProduto.getModel();
        return (int) modeloTabela.getValueAt(linhaSelecionada, 0);
    }
    
    private void excluirLinha(int idProduto) throws SQLException{
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            produtoController.removerProduto(idProduto);
            carregarTabelaProduto();
        }
    }
    
    private void consultar(String selecionado) throws SQLException{
        if("ID".equals(selecionado)){
            selecionarPorID(txtConsulta.getText());
        } else{
            selecionarPorNome(txtConsulta.getText());
        }
    }
    
    private void selecionarPorID(String id) throws SQLException{
        ArrayList<ProdutoDTO> produtos = produtoController.selecionarPorID(id);
        carregarTabela(produtos);
    }
    
    private void selecionarPorNome(String nome) throws SQLException{
        ArrayList<ProdutoDTO> produtos = produtoController.selecionarPorNome(nome);
        carregarTabela(produtos);
    }
    
    private void verificarSelecao(){
        if("ID".equals(cbConsulta.getSelectedItem())){
            EntradaConfig.permitirNumero(txtConsulta);
        } else{
            EntradaConfig.removerPermitirNumero(txtConsulta);
        }
    }
    
    private void limparConsulta(){
        txtConsulta.setText("");
    }
    
    private void fecharConfig(){
        addWindowListener(new WindowAdapter() {
        @Override
            public void windowClosing(WindowEvent e) {
                if (janelaController.cadastroAbertoProduto(cadProduto)) {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    cadProduto.toFront();
                } else{
                    dispose();
                }
            }
        });
    }
}