package com.sfaci.ejercicio1.gui;

import com.sfaci.ejercicio1.base.Alumno;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dam on 21/10/16.
 */
public class VentanaController implements ActionListener, ListSelectionListener {

    private Ventana view;
    private VentanaModel model;

    public VentanaController(Ventana view, VentanaModel model) {
        this.view = view;
        this.model = model;

        addListeners();

        rellenarComboCiclos();
    }

    private void rellenarComboCiclos() {

        view.cbCiclo.addItem("<Selecciona ciclo>");
        for (Alumno.Ciclo ciclo : Alumno.Ciclo.values()) {
            view.cbCiclo.addItem(ciclo.name());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Nuevo":
                setModoEdicion(true);
                break;
            case "Guardar":
                Alumno alumno = new Alumno();
                alumno.setNombre(view.tfNombre.getText());
                alumno.setApellidos(view.tfApellidos.getText());
                alumno.setFechaNacimiento(view.dcFechaNacimiento.getDate());
                alumno.setCiclo(Alumno.Ciclo.valueOf((String) view.cbCiclo.getSelectedItem()));
                model.registrar(alumno);
                refrescarLista();
                setModoEdicion(false);
                break;
            default:
                break;
        }
    }

    private void refrescarLista() {

        view.dlmAlumnos.removeAllElements();
        for (Alumno alumno : model.obtenerAlumnos()) {
            view.dlmAlumnos.addElement(alumno);
        }
    }

    private void setModoEdicion(boolean edicion) {
        view.tfNombre.setEditable(edicion);
        view.tfApellidos.setEditable(edicion);
        view.btNuevo.setEnabled(!edicion);
        view.btGuardar.setEnabled(edicion);
        view.lAlumnos.setEnabled(!edicion);
    }

    private void addListeners() {

        view.btGuardar.addActionListener(this);
        view.btNuevo.addActionListener(this);
        view.lAlumnos.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        Alumno alumno = (Alumno) view.lAlumnos.getSelectedValue();
        if (alumno == null)
            return;

        view.tfNombre.setText(alumno.getNombre());
        view.tfApellidos.setText(alumno.getApellidos());
        view.dcFechaNacimiento.setDate(alumno.getFechaNacimiento());
        view.cbCiclo.setSelectedItem(alumno.getCiclo().name());
    }
}
