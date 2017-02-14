package com.sfaci.gestionmongodb;

import com.sfaci.gestionmongodb.base.Libro;
import com.sfaci.gestionmongodb.util.Util;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by dam on 10/02/17.
 */
public class VentanaController implements ActionListener,
        ListSelectionListener {

    private Ventana view;
    private VentanaModel model;

    public VentanaController(Ventana view, VentanaModel model) {
        this.view = view;
        this.model = model;

        addListeners();
        cargarLibros();
    }

    private void addListeners() {
        view.btNuevo.addActionListener(this);
        view.btGuardar.addActionListener(this);
        view.btModificar.addActionListener(this);
        view.btEliminar.addActionListener(this);

        view.tbLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel lsm = view.tbLibros.getSelectionModel();
        lsm.addListSelectionListener(this);

    }

    private void cargarLibros() {

        ArrayList<Libro> libros = model.obtenerLibros();
        view.dtmLibros.setNumRows(0);
        for (Libro libro : libros) {
            String[] fila = new String[]{
                    libro.getTitulo(),
                    libro.getDescripcion(),
                    libro.getAutor(),
                    Util.formatFecha(libro.getFecha()),
                    String.valueOf(libro.isDisponible())
            };
            view.dtmLibros.addRow(fila);
        }
    }

    private void cargarDatos(int fila) {

        view.tfTitulo.setText((String) view.tbLibros.getValueAt(fila, 0));
        view.tfDescripcion.setText((String) view.tbLibros.getValueAt(fila, 1));
        view.tfAutor.setText((String) view.tbLibros.getValueAt(fila, 2));
        try {
            view.dcFecha.setDate(
                    Util.parseFecha((String) view.tbLibros.getValueAt(fila, 3)));
        } catch(ParseException pe) {
            Util.mensajeError("Formato de fecha",
                    "Formato de fecha incorrecto. No se ha podido cargar");
        }
        view.checkDisponible.setSelected(
                Boolean.parseBoolean((String) view.tbLibros.getValueAt(fila, 4)));
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

    @Override
    public void valueChanged(ListSelectionEvent e) {

        int filaSeleccionada = view.tbLibros.getSelectedRow();
        cargarDatos(filaSeleccionada);

    }
}
