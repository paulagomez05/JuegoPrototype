/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Canvas;
import javax.swing.JButton;

/**
 *
 * @author estudiantes
 */
public class Vista extends javax.swing.JFrame {

    private Controlador control;
    private final Modelo modelo;
    
    public Vista(Modelo aThis) {
        modelo = aThis;
        initComponents();
        capturarEventos();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }

    public Canvas getLienzo() {
        return lienzo;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new java.awt.Canvas();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(lienzo);
        lienzo.setBounds(10, 10, 1250, 690);

        btnCerrar.setText("Cerrar");
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(1120, 710, 130, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables

    private void capturarEventos() {

        lienzo.addMouseListener(getControl ());
        btnCerrar.addActionListener(getControl());
    }
}
