package com.sfaci.examen3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by dam on 11/11/16.
 */
public class Ventana implements ActionListener {
    private JPanel panel1;
    private JTextField tfUsuarios;
    private JTextField tfIP;
    private JTextField tfPuerto;
    private JButton btGuardar;

    public Ventana() {

        btGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Properties props = new Properties();
            props.setProperty("usuarios", tfUsuarios.getText());
            props.setProperty("ip", tfIP.getText());
            props.setProperty("puerto", tfPuerto.getText());
            props.store(new FileOutputStream("configuracion.props"), "Configuracion");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
