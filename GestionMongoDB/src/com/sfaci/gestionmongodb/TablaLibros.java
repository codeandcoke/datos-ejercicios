package com.sfaci.gestionmongodb;

import com.sfaci.gestionmongodb.base.Libro;
import com.sfaci.gestionmongodb.util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;

import static com.sfaci.gestionmongodb.util.Constantes.*;

/**
 * Created by dam on 14/02/17.
 */
public class TablaLibros extends JTable {

    private DefaultTableModel dtm;
    private HashMap<String, Libro> libros;

    public TablaLibros() {
        super();
        libros = new HashMap<>();

        dtm = new DefaultTableModel();
        dtm.addColumn(TITULO);
        dtm.addColumn(DESCRIPCION);
        dtm.addColumn(AUTOR);
        dtm.addColumn(FECHA);
        dtm.addColumn(DISPONIBLE);
        setModel(dtm);
    }

    public void vaciar() {
        dtm.setNumRows(0);
    }

    public void anadirLibro(Libro libro) {

        String[] fila = new String[]{
                libro.getTitulo(),
                libro.getDescripcion(),
                libro.getAutor(),
                Util.formatFecha(libro.getFecha()),
                String.valueOf(libro.isDisponible())
        };
        dtm.addRow(fila);

        libros.put(libro.getTitulo(), libro);
    }

    public Libro obtenerLibroSeleccionado() {

        int filaSeleccionada = getSelectedRow();
        if (filaSeleccionada == -1)
            return null;

        return obtenerLibro(filaSeleccionada);
    }

    public Libro obtenerLibro(int fila) {

        String tituloSeleccionado =
                (String) getValueAt(fila, 0);
        Libro libro = libros.get(tituloSeleccionado);

        return libro;
    }
}
