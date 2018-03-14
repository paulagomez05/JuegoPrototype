
package main;

import presentacion.Modelo;


public class JuegoPrototipe {
  private final Modelo miApp;

    public JuegoPrototipe() {
        miApp = new Modelo ();
        miApp.iniciar();
    }
  
  
    public static void main(String[] args) {
        
        new JuegoPrototipe ();
    }
    
}