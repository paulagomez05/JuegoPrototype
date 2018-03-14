/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author estudiantes
 */
public class Controlador implements MouseListener, ActionListener{

    private final Vista ventana;

    public Controlador(Vista aThis) {
        ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.getModelo().cerrar();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
                int x, y;
        x = e.getX();
        y = e.getY();
        ventana.getModelo().enviarCoordenadas(x, y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
