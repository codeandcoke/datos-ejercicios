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

    DefaultTableModel dtm;

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
        dtm = new DefaultTableModel();
        dtm.addColumn("Título");
        dtm.addColumn("Descripción");
        dtm.addColumn("Autor");
        dtm.addColumn("Fecha");
        dtm.addColumn("Disponible");
        tbLibros.setModel(dtm);
    }
}
