

package logica;



public class Sistema {
    private boolean estaDibujando;

    private int posX, posY;
    
    public Sistema() {
        estaDibujando = true;
        posX = 0;
        posY = 0;
    }

    public boolean isEstaDibujando() {
        return estaDibujando;
    }

    public void setEstaDibujando(boolean estaDibujando) {
        this.estaDibujando = estaDibujando;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
    
}
