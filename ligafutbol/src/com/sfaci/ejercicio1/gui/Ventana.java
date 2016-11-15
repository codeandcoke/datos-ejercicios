package com.sfaci.ejercicio1.gui;

import com.sfaci.ejercicio1.base.Alumno;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;

/**
 * Created by dam on 21/10/16.
 */
public class Ventana {
    JPanel panel1;
    JTextField tfNombre;
    JTextField tfApellidos;
    JComboBox cbCiclo;
    JList lAlumnos;
    JDateChooser dcFechaNacimiento;
    JButton btNuevo;
    JButton btGuardar;

    DefaultListModel<Alumno> dlmAlumnos;

    public Ventana() {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        inicializar();
    }

    private void inicializar() {

        dlmAlumnos = new DefaultListModel<>();
        lAlumnos.setModel(dlmAlumnos);
    }
}
