package logica;

/**
 *
 * @author George
 */
public class NaveDuplicable extends Nave implements Duplicable {

    @Override
    public Object duplicar() {
      
        NaveDuplicable nave = new NaveDuplicable ();
        
        nave.setUbicacion((Ubicacion) ((UbicacionDuplicable) this.getUbicacion()).duplicar());
        nave.setVida((Vida) ((VidaDuplicable) this.getVida()).duplicar());
        nave.setImagenNave((ImagenNave) ((ImagenNaveDuplicable) this.getImagenNave()).duplicar());
                
        return nave;
    }


}
