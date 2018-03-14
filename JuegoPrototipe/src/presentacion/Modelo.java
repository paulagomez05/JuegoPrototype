package presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import logica.Cliente;
import logica.Sistema;

/**
 *
 * @author George
 */
public class Modelo implements Runnable {

    private Sistema miSistema;
    private Vista ventanaPrincipal;
    private BufferedImage dobleBuffer;
    private Thread hiloDibujo;
    private Image nave2, nave3, imagen;
    private int posicionX, posicionY;
    private boolean estado;

    Cliente cliente = new Cliente();

    public Modelo() {
        hiloDibujo = new Thread(this);
        dobleBuffer = new BufferedImage(getVentanaPrincipal().getLienzo().getWidth(), getVentanaPrincipal().getLienzo().getHeight(), BufferedImage.TYPE_INT_ARGB);
        nave2 = new ImageIcon(this.getClass().getResource("/imagenes/nave 2.png")).getImage();
        nave3 = new ImageIcon(this.getClass().getResource("/imagenes/nave 3.png")).getImage();

    }

    public Sistema getMiSistema() {
        if (miSistema == null) {
            miSistema = new Sistema();
        }
        return miSistema;
    }

    public Vista getVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new Vista(this);
        }
        return ventanaPrincipal;
    }

    public void iniciar() {
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        getMiSistema().setEstaDibujando(true);
        getVentanaPrincipal().setSize(ancho, alto);
        getVentanaPrincipal().setVisible(true);
        duplicarNaves();
        hiloDibujo.start();
    }

    public void enviarCoordenadas(int x, int y) {
        getMiSistema().setPosX(x);
        getMiSistema().setPosY(y);
    }

    public void duplicarNaves() {

        cliente.crearNaveBase(15, 15, true, nave3);

        for (int i = 0; i < 6; i++) {
            cliente.duplicarNave();
            cliente.getNaveClon(i).getUbicacion().setPosicionX(i * 200);

        }
        for (int j = 0; j < 3; j++) {
            cliente.getNaveClon(1 + (j * 2)).getUbicacion().setPosicionY(180);

        }
    }

    public void cerrar() {
        System.exit(0);
    }

    @Override
    public void run() {

        while (getMiSistema().isEstaDibujando()) {
            dibujar();

        }

    }

    private void dibujar() {
        int x = getMiSistema().getPosX();
        int y = getMiSistema().getPosY();
        //String mensaje;

        Canvas lienzo = getVentanaPrincipal().getLienzo();
        Graphics lapiz = lienzo.getGraphics();
        Graphics lapizInvisible = dobleBuffer.getGraphics();

        Color colorTablero = new Color(144, 199, 249);
        lapizInvisible.setColor(colorTablero);
        lapizInvisible.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());

        lapizInvisible.setColor(Color.BLACK);
        //mensaje = "X: " + x + ", Y: " + y;
        //lapizInvisible.drawString(mensaje, 10, 30);

        for (int i = 0; i < 6; i++) {
            posicionX = cliente.getNaves().get(i).getUbicacion().getPosicionX();
            posicionY = cliente.getNaves().get(i).getUbicacion().getPosicionY();
            imagen = cliente.getNaves().get(i).getImagenNave().getImagen();
            estado = cliente.getNaves().get(i).getVida().isEstado();

            if ((x > (i * 190) && x < ((i + 1) * 190)) && ((y > posicionY) && (y < 200))) {
                cliente.getNaveClon(i).getVida().setEstado(false);
            }

            if (estado == false) {
                cliente.getNaveClon(i).getImagenNave().setImagen(null);
            }
            
            lapizInvisible.drawImage(imagen, posicionX, posicionY, lienzo);
        }
        
        lapiz.drawImage(dobleBuffer, 0, 0, lienzo);
        
    }
}
