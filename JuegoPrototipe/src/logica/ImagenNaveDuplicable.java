package logica;

import java.awt.Image;

/**
 *
 * @author George
 */
public class ImagenNaveDuplicable extends ImagenNave implements Duplicable {

    public ImagenNaveDuplicable(Image imagen) {
        super(imagen);
    }

    @Override
    public Object duplicar() {

        ImagenNave imagenNave = new ImagenNaveDuplicable(getImagen());
        return imagenNave;
    }

}
