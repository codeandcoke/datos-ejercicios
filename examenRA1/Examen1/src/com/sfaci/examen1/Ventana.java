package com.sfaci.examen1;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by dam on 11/11/16.
 */
public class Ventana implements ActionListener {
    private JTextField tfMarca;
    private JTextField tfModelo;
    private JTextField tfPrecio;
    private JComboBox cbMoviles;
    private JDateChooser dcFecha;
    private JButton btRegistrar;
    private JPanel panel;
    private JButton btEliminar;

    private ArrayList<Movil> moviles;

    public Ventana() {

        moviles = new ArrayList<>();
        btRegistrar.addActionListener(this);
        btEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btRegistrar) {
            Movil movil = new Movil();
            movil.setMarca(tfMarca.getText());
            movil.setModelo(tfModelo.getText());
            movil.setPrecio(Float.parseFloat(tfPrecio.getText()));
            movil.setFechaCompra(dcFecha.getDate());
            moviles.add(movil);
        }
        else if (e.getSource() == btEliminar) {

            int posicion = cbMoviles.getSelectedIndex();
            moviles.remove(posicion);
        }

        refrescarCombo();
    }

    private void refrescarCombo() {

        cbMoviles.removeAllItems();
        for (Movil movil : moviles) {
            cbMoviles.addItem(movil);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
