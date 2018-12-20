package com.sfaci.ejemplohibernate;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sfaci.ejemplohibernate.base.Personaje;
import com.sfaci.ejemplohibernate.ui.Vista;

public class Controlador implements ActionListener, ListSelectionListener, FocusListener, KeyListener {

	private Vista vista;
	private Modelo modelo;
	
	public enum Accion {
		NUEVO, MODIFICAR, GUARDAR, ELIMINAR
	}
	private Accion accion;
	private Personaje personajeActual;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		addListeners();
		cargarDatos();
	}
	
	private void addListeners() {
		vista.btEliminar.addActionListener(this);
		vista.btGuardar.addActionListener(this);
		vista.btModificar.addActionListener(this);
		vista.btNuevo.addActionListener(this);
		
		vista.lPersonajes.addListSelectionListener(this);
		
		vista.tfNombre.addFocusListener(this);
		
		vista.tfNombre.addKeyListener(this);
	}
	
	private void cargarDatos() {
		List<Personaje> personajes = modelo.getPersonajes();
		vista.mPersonajes.removeAllElements();
		for (Personaje personaje : personajes) 
			vista.mPersonajes.addElement(personaje);
	}
	
	private void cargarPersonajeActual() {
		vista.tfNombre.setText(personajeActual.getNombre());
		vista.tfDescripcion.setText(personajeActual.getDescripcion());
		vista.tfAtaque.setText(String.valueOf(personajeActual.getAtaque()));
		vista.tfVida.setText(String.valueOf(personajeActual.getVida()));
	}
	
	private void modoEdicion(boolean edicion) {
		vista.tfNombre.setEditable(edicion);
		vista.tfDescripcion.setEditable(edicion);
		vista.tfVida.setEditable(edicion);
		vista.tfAtaque.setEditable(edicion);
	}
	
	private void nuevoPersonaje() {
		vista.tfNombre.setText("");
		vista.tfDescripcion.setText("");
		vista.tfAtaque.setText("");
		vista.tfVida.setText("");
		accion = Accion.NUEVO;
		
		modoEdicion(true);
	}
	
	private void modificarPersonaje() {
		vista.tfNombre.setEditable(true);
		vista.tfDescripcion.setEditable(true);
		vista.tfAtaque.setEditable(true);
		vista.tfVida.setEditable(true);
		accion = Accion.MODIFICAR;
		
		modoEdicion(true);
	}
	
	private void guardarPersonaje() {
		System.out.println(modelo.existePersonaje("asdasd"));
		Personaje personaje = null;
		
		if (vista.tfNombre.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "El nombre es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		switch (accion) {
			case NUEVO:
				personaje = new Personaje();
				break;
			case MODIFICAR:
				if (JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Modificar", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
					return;
				personaje = personajeActual;
				break;
			default:
				break;
		}
		
		personaje.setNombre(vista.tfNombre.getText());
		personaje.setDescripcion(vista.tfDescripcion.getText());
		personaje.setAtaque(Integer.parseInt(vista.tfAtaque.getText()));
		personaje.setVida(Integer.parseInt(vista.tfVida.getText()));
		modelo.guardar(personaje);
		
		modoEdicion(false);
		cargarDatos();
	}
	
	private void eliminarPersonaje() {
		if (JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Modificar", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
			return;
		
		modelo.eliminar(personajeActual);
		cargarDatos();
	}

	public void actionPerformed(ActionEvent event) {
		Accion accion = Accion.valueOf(event.getActionCommand());
		switch (accion) {
			case NUEVO:
				nuevoPersonaje();
				break;
			case MODIFICAR:
				modificarPersonaje();
				break;
			case GUARDAR:
				guardarPersonaje();
				break;
			case ELIMINAR:
				eliminarPersonaje();
				break;
			default:
					break;
		}
	}
	
	private void comprobarNombre() {
		if ((accion == Accion.MODIFICAR) || (accion == Accion.NUEVO)) {
			String nombre = vista.tfNombre.getText();
			if (modelo.existePersonaje(nombre)) {
				vista.tfNombre.setBorder(BorderFactory.createLineBorder(Color.RED));
				vista.btGuardar.setEnabled(false);
			}
			else {
				vista.tfNombre.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				vista.btGuardar.setEnabled(true);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		int posicion = vista.lPersonajes.getSelectedIndex();
		if (posicion == -1)
			return;
		
		personajeActual = vista.lPersonajes.getSelectedValue();
		cargarPersonajeActual();
	}

	@Override
	public void focusGained(FocusEvent event) {
	}

	@Override
	public void focusLost(FocusEvent event) {
		comprobarNombre();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		comprobarNombre();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
