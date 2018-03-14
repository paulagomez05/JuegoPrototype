package logica;

/**
 *
 * @author George
 */
public class VidaDuplicable extends Vida implements Duplicable {

    public VidaDuplicable(boolean estado) {
        super(estado);
    }

    @Override
    public Object duplicar() {
        
        Vida vida = new VidaDuplicable (isEstado());
        return vida;

    }

}
