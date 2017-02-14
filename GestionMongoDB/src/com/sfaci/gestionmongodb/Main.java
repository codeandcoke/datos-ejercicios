package com.sfaci.gestionmongodb;

/**
 * Created by dam on 10/02/17.
 */
public class Main {

    public static void main(String args[]) {

        Ventana view = new Ventana();
        VentanaModel model = new VentanaModel("libros");
        VentanaController controller = new VentanaController(view, model);
    }
}
