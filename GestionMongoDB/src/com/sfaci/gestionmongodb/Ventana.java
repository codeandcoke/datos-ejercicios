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
    JCheckBox checkDisponible;
    JDateChooser dcFecha;
    JLabel lbEstado;
    JTextField tfNombreEditorial;
    JTextField tfTelefonos;
    JComboBox<Editorial> cbEditoriales;
    TablaLibros tbLibros;

    public Ventana() {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void createUIComponents() {
        cbEditoriales = new JComboBox<Editorial>();
    }
}
