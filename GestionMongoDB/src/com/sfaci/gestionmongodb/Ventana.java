package com.sfaci.gestionmongodb;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
        dtmLibros.addColumn("Título");
        dtmLibros.addColumn("Descripción");
        dtmLibros.addColumn("Autor");
        dtmLibros.addColumn("Fecha");
        dtmLibros.addColumn("Disponible");
        tbLibros.setModel(dtmLibros);
    }
}
