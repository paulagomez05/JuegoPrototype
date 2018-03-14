
package logica;

/**
 *
 * @author George
 */
public class UbicacionDuplicable extends Ubicacion implements Duplicable {
  
    public UbicacionDuplicable(int posicionX, int posicionY) {
        super(posicionX, posicionY);
    }

    @Override
    public Object duplicar() {
        
                Ubicacion ubicacion = new UbicacionDuplicable (getPosicionX(), getPosicionY());
                return ubicacion;
    
    }
  
    
    
      
}
