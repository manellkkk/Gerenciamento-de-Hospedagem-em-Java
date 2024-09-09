package com.manel.hospedagem.janelas;

import static java.awt.SystemColor.text;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Configuration {
    public static void impedirNumero(JTextField txt){
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }

            }
        });
    }
    
    public static void permitirNumero(JTextField txt){
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }

            }
        });
    }
    
    public static void permitirNumeroValor(JTextField txt){
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                String content = txt.getText();
                int index = content.indexOf('.');
                long count = content.chars().filter(c -> c == '.').count();
                if (!Character.isDigit(keyChar)) {
                    if(keyChar != '.'){
                        e.consume();
                    } else if(content.length() == 0){
                        txt.setText("0");
                    } else if(count > 0){
                        e.consume();
                    }
                }
                
                if(index != -1 && index < content.length() - 1){
                    content = content.substring(index + 1);
                    if(content.length() > 1){
                        e.consume();
                    }
                }

            }
        });
    }
    
    public static void permitirNumeroFormatado(JFormattedTextField txt){
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
}