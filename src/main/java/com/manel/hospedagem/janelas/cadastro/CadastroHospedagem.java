package com.manel.hospedagem.janelas.cadastro;

import com.manel.hospedagem.controller.HospedagemController;
import com.manel.hospedagem.dto.ClienteDTO;
import static com.manel.hospedagem.janelas.EntradaConfig.impedirNumero;
import static com.manel.hospedagem.janelas.EntradaConfig.permitirNumero;
import static com.manel.hospedagem.janelas.EntradaConfig.permitirNumeroValor;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class CadastroHospedagem extends javax.swing.JFrame {
    private ClienteDTO cliente;
    HospedagemController hospedagemController = new HospedagemController();
    
    public CadastroHospedagem(ClienteDTO cliente) {
        initComponents();
        this.cliente = cliente;
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        carregarCliente();
        permitirNumero(txtDataEntrada);
        permitirNumero(txtQuarto);
        permitirNumeroValor(txtValor);
        formatarData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblDataEntrada = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        lblValor = new javax.swing.JLabel();
        txtDataEntrada = new javax.swing.JFormattedTextField();
        lblValor1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        lblQuarto = new javax.swing.JLabel();
        txtQuarto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        lblCliente.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblCliente.setText("Cliente:");

        lblNome.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblNome.setText("...");

        lblDataEntrada.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblDataEntrada.setText("Data Entrada");

        lblValor.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblValor.setText("Valor da diária");

        lblValor1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblValor1.setText("R$");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setText("Cancelar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lblQuarto.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblQuarto.setText("Quarto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuarto)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFechar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDataEntrada)
                                .addComponent(txtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblValor)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblValor1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataEntrada)
                    .addComponent(lblValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblValor1))
                    .addComponent(txtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuarto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnFechar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        cancelar();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if(verificarHospedagem()){
                dispose();
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a hospedagem.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDataEntrada;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQuarto;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JFormattedTextField txtDataEntrada;
    private javax.swing.JTextField txtQuarto;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
    private void carregarCliente(){
        lblNome.setText(cliente.getNome());
    }
    
    private void formatarData(){
        try {
            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            dataMask.setPlaceholderCharacter('_');
            dataMask.install(txtDataEntrada);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void cancelar(){
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
    
    private Boolean verificarHospedagem() throws ParseException{
        return hospedagemController.adicionarHospedagem(cliente.getCPF(), txtValor.getText(), txtDataEntrada.getText(), txtQuarto.getText());
    }
}
