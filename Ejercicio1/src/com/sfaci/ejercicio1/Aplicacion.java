package com.sfaci.ejercicio1;

import com.sfaci.ejercicio1.gui.Ventana;
import com.sfaci.ejercicio1.gui.VentanaController;
import com.sfaci.ejercicio1.gui.VentanaModel;

/**
 * Created by dam on 21/10/16.
 */
public class Aplicacion {

    public static void main(String args[]) {

        Ventana view = new Ventana();
        VentanaModel model = new VentanaModel();
        VentanaController controller = new VentanaController(view, model);

    }
}
