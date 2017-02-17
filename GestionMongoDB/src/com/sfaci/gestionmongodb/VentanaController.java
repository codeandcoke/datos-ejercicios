package com.sfaci.gestionmongodb;

import com.sfaci.gestionmongodb.base.Editorial;
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

        /*
        Lista la información de los libros en la tabla
         */
        ArrayList<Libro> libros = model.obtenerLibros();
        view.tbLibros.vaciar();
        for (Libro libro : libros) {
            view.tbLibros.anadirLibro(libro);
        }

        /*
        Refresca el combo de las editoriales
         */
        view.cbEditoriales.removeAllItems();
        for (Editorial editorial : model.obtenerEditoriales()) {
            view.cbEditoriales.addItem(editorial);
        }
    }

    private void cargarDatos(Libro libro) {

        view.tfTitulo.setText(libro.getTitulo());
        view.tfDescripcion.setText(libro.getDescripcion());
        view.tfAutor.setText(libro.getAutor());
        view.dcFecha.setDate(libro.getFecha());
        view.checkDisponible.setSelected(libro.isDisponible());
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
                libro.setEditorial((Editorial) view.cbEditoriales.getSelectedItem());
                model.insertarLibro(libro);
                cargarLibros();
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

        Libro libro = view.tbLibros.obtenerLibroSeleccionado();
        cargarDatos(libro);

    }
}
