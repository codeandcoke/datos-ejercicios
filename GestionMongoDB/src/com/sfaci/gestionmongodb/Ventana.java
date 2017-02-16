package com.sfaci.gestionmongodb;

import com.sfaci.gestionmongodb.base.Editorial;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static com.sfaci.gestionmongodb.util.Constantes.*;

/**
 * Created by dam on 10/02/17.
 */
public class Ventana {
    JPanel panel;
    JButton btNuevo;
    JButton btGuardar;
    JButton btModificar;
    JButton btEliminar;
    JTextField tfBuscar;
    JTabbedPane tabbedPane1;
    JTextField tfTitulo;
    JTextField tfDescripcion;
    JTextField tfAutor;
    JTable tbLibros;
    JCheckBox checkDisponible;
    JDateChooser dcFecha;
    JLabel lbEstado;
    JTextField tfNombreEditorial;
    JTextField tfTelefonos;
    JComboBox<Editorial> cbEditoriales;

    DefaultTableModel dtmLibros;

    public Ventana() {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        prepararTabla();
    }

    private void prepararTabla() {
        dtmLibros = new DefaultTableModel();
        dtmLibros.addColumn(TITULO);
        dtmLibros.addColumn(DESCRIPCION);
        dtmLibros.addColumn(AUTOR);
        dtmLibros.addColumn(FECHA);
        dtmLibros.addColumn(DISPONIBLE);
        dtmLibros.addColumn(EDITORIAL);
        tbLibros.setModel(dtmLibros);
    }

    private void createUIComponents() {
        cbEditoriales = new JComboBox<Editorial>();
    }
}
