package com.sfaci.ejemplohibernate.beans;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel con botones para lanzar las acciones de edición
 * de los elementos de la aplicación
 */
public class JBotonesCrud extends JPanel {
	public JButton btNuevo;
	public JButton btGuardar;
	public JButton btModificar;
	public JButton btCancelar;
	public JButton btEliminar;

	public JBotonesCrud() {
		setLayout(null);
		
		btNuevo = new JButton("Nuevo");
		btNuevo.setActionCommand("nuevo");
		btNuevo.setBounds(10, 10, 71, 23);
		add(btNuevo);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setActionCommand("guardar");
		btGuardar.setBounds(10, 39, 71, 23);
		add(btGuardar);
		
		btModificar = new JButton("Modificar");
		btModificar.setActionCommand("modificar");
		btModificar.setBounds(87, 10, 75, 23);
		add(btModificar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setActionCommand("cancelar");
		btCancelar.setBounds(87, 39, 75, 23);
		add(btCancelar);
		
		btEliminar = new JButton("Eliminar");
		btEliminar.setActionCommand("eliminar");
		btEliminar.setBounds(51, 68, 86, 23);
		add(btEliminar);		
	}
	
	public void addListeners(ActionListener listener) {
		btNuevo.addActionListener(listener);
		btGuardar.addActionListener(listener);
		btModificar.addActionListener(listener);
		btEliminar.addActionListener(listener);
		btCancelar.addActionListener(listener);
	}
	
	public void modoEdicion(boolean edicion) {
		btNuevo.setEnabled(!edicion);
		btGuardar.setEnabled(edicion);
		btModificar.setEnabled(!edicion);
		btEliminar.setEnabled(!edicion);
		btCancelar.setEnabled(edicion);
	}
}
