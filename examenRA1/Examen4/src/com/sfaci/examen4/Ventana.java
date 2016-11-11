package com.sfaci.examen4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by dam on 11/11/16.
 */
public class Ventana implements ActionListener {
    private JPanel panel1;
    private JTextField tfNombre;
    private JTextField tfApellidos;
    private JTextField tfDireccion;
    private JTextField tfEdad;
    private JButton btGuardar;

    public Ventana() {

        btGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (tfNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ajklshda", "asd",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tfApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ajklshda", "asd",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tfEdad.getText().equals(""))
            tfEdad.setText("0");

        Persona persona = new Persona();
        persona.setNombre(tfNombre.getText());
        persona.setApellidos(tfApellidos.getText());
        persona.setDireccion(tfDireccion.getText());
        persona.setEdad(Integer.parseInt(tfEdad.getText()));

        // Guardar a fichero
        JFileChooser jfc = new JFileChooser();
        if (jfc.showSaveDialog(null) == JFileChooser.CANCEL_OPTION)
            return;

        File fichero = jfc.getSelectedFile();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fichero));
            oos.writeObject(persona);
            oos.close();
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
