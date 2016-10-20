package com.sfaci.concesionario.gui;

import com.sfaci.concesionario.base.Coche;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;

/**
 * GUI de la aplicación
 *
 * @author Santiago Faci
 * @version curso 2016-2017
 */
public class Ventana {
    JPanel panel1;
    JLabel lbEstado;
    JTextField tfMatricula;
    JTextField tfModelo;
    JTextField tfPotencia;
    JTextField tfBusqueda;
    JList lCoches;
    JButton btEliminar;
    JButton btNuevo;
    JButton btModificar;
    JButton btGuardar;
    JButton btCancelar;
    JRadioButton rbGasolina;
    JRadioButton rbDiesel;
    JCheckBox cbHibrido;JDateChooser tfCompra;
    ButtonGroup bgCombustible;
    DefaultListModel<Coche> dlmCoches;

    public Ventana() {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        bgCombustible = new ButtonGroup();
        bgCombustible.add(rbDiesel);
        bgCombustible.add(rbGasolina);

        dlmCoches = new DefaultListModel<>();
        lCoches.setModel(dlmCoches);

        tfCompra.setEnabled(false);
    }
}
