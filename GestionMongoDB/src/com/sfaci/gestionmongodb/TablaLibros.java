package com.sfaci.gestionmongodb;

import com.sfaci.gestionmongodb.base.Libro;
import com.sfaci.gestionmongodb.util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import static com.sfaci.gestionmongodb.util.Constantes.*;

/**
 * Created by dam on 14/02/17.
 */
public class TablaLibros extends JTable {

    private DefaultTableModel dtm;
    private ArrayList<Libro> libros;

    public TablaLibros() {
        super();
        libros = new ArrayList<>();

        dtm = new DefaultTableModel();
        dtm.addColumn(TITULO);
        dtm.addColumn(DESCRIPCION);
        dtm.addColumn(AUTOR);
        dtm.addColumn(FECHA);
        dtm.addColumn(DISPONIBLE);
        setModel(dtm);
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

        libros.add(libro);
    }

    public Libro obtenerLibroSeleccionado() {

        return null;
    }

    public Libro obtenerLibro(int fila) {

        return null;

    }
}
