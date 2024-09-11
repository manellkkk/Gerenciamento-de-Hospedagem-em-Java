package com.manel.hospedagem.janelas;

import static java.awt.SystemColor.text;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EntradaConfig {
    private static KeyListener impedirNumeroListener;
    private static KeyListener permitirNumeroListener;
    private static KeyListener permitirNumeroValorListener;
    private static KeyListener permitirNumeroFormatadoListener;
    
    public static void impedirNumero(JTextField txt) {
        impedirNumeroListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        };
        txt.addKeyListener(impedirNumeroListener);
    }
    
    public static void permitirNumero(JTextField txt) {
        permitirNumeroListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        };
        txt.addKeyListener(permitirNumeroListener);
    }
    
    public static void permitirNumeroValor(JTextField txt) {
        permitirNumeroValorListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                String content = txt.getText();
                int index = content.indexOf('.');
                long count = content.chars().filter(c -> c == '.').count();
                if (!Character.isDigit(keyChar)) {
                    if (keyChar != '.') {
                        e.consume();
                    } else if (content.length() == 0) {
                        txt.setText("0");
                    } else if (count > 0) {
                        e.consume();
                    }
                }
                
                if (index != -1 && index < content.length() - 1) {
                    content = content.substring(index + 1);
                    if (content.length() > 1) {
                        e.consume();
                    }
                }
            }
        };
        txt.addKeyListener(permitirNumeroValorListener);
    }
    
    public static void permitirNumeroFormatado(JFormattedTextField txt) {
        permitirNumeroFormatadoListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        };
        txt.addKeyListener(permitirNumeroFormatadoListener);
    }

    public static void removerImpedirNumero(JTextField txt) {
        if (impedirNumeroListener != null) {
            txt.removeKeyListener(impedirNumeroListener);
        }
    }
    
    public static void removerPermitirNumero(JTextField txt) {
        if (permitirNumeroListener != null) {
            txt.removeKeyListener(permitirNumeroListener);
        }
    }
    
    public static void removerPermitirNumeroValor(JTextField txt) {
        if (permitirNumeroValorListener != null) {
            txt.removeKeyListener(permitirNumeroValorListener);
        }
    }
    
    public static void removerPermitirNumeroFormatado(JFormattedTextField txt) {
        if (permitirNumeroFormatadoListener != null) {
            txt.removeKeyListener(permitirNumeroFormatadoListener);
        }
    }
}