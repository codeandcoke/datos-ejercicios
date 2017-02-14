package com.sfaci.gestionmongodb;

import com.sfaci.gestionmongodb.base.Libro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dam on 10/02/17.
 */
public class VentanaController implements ActionListener {

    private Ventana view;
    private VentanaModel model;

    public VentanaController(Ventana view, VentanaModel model) {
        this.view = view;
        this.model = model;

        addListeners();
    }

    private void addListeners() {
        view.btNuevo.addActionListener(this);
        view.btGuardar.addActionListener(this);
        view.btModificar.addActionListener(this);
        view.btEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Nuevo":
                view.tfTitulo.setText("");
                view.tfDescripcion.setText("");
                view.tfAutor.setText("");
                view.dcFecha.setDate(null);
                view.checkDisponible.setSelected(false);
                break;
            case "Guardar":
                Libro libro = new Libro();
                libro.setTitulo(view.tfTitulo.getText());
                libro.setDescripcion(view.tfDescripcion.getText());
                libro.setAutor(view.tfAutor.getText());
                libro.setFecha(view.dcFecha.getDate());
                libro.setDisponible(view.checkDisponible.isSelected());
                model.insertarLibro(libro);
                break;
            case "Modificar":
                break;
            case "Eliminar":
                break;
            default:
                break;
        }
    }
}
