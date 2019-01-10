package com.sfaci.ejemplohibernate.beans;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;

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
		btNuevo.setBounds(10, 10, 71, 23);
		add(btNuevo);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(10, 39, 71, 23);
		add(btGuardar);
		
		btModificar = new JButton("Modificar");
		btModificar.setBounds(87, 10, 75, 23);
		add(btModificar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(87, 39, 75, 23);
		add(btCancelar);
		
		btEliminar = new JButton("Eliminar");
		btEliminar.setBounds(51, 68, 86, 23);
		add(btEliminar);

	}
}
