package logica;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author George
 */
public class Cliente {

    private NaveDuplicable naveBase;
    private ArrayList<Nave> naves;


    public Cliente() {
        naves = new ArrayList<Nave>();
    }

    public void crearNaveBase(int posicionXUbicacion, int posicionYUbicacion, boolean estadoVida, Image imagenImagenNave) {

        naveBase = new NaveDuplicable();

        naveBase.setUbicacion(new UbicacionDuplicable(posicionXUbicacion, posicionYUbicacion));
        naveBase.setVida(new VidaDuplicable(estadoVida));
        naveBase.setImagenNave(new ImagenNaveDuplicable(imagenImagenNave));

    }

    public void duplicarNave() {

        NaveDuplicable nave1Duplicada = (NaveDuplicable) naveBase.duplicar();
        naves.add(nave1Duplicada);

    }

    ////////////////////////////////////////////////////////////////////////////

    public NaveDuplicable getNaveBase() {
        return naveBase;
    }

    public void setNaveBase(NaveDuplicable naveBase) {
        this.naveBase = naveBase;
    }

    public ArrayList<Nave> getNaves() {
        return naves;
    }

    public void setNaves(ArrayList<Nave> naves) {
        this.naves = naves;
    }
    
    public NaveDuplicable getNaveClon(int indice) {
		
		return (NaveDuplicable)naves.get(indice);
		
	}
    
    
    
}
