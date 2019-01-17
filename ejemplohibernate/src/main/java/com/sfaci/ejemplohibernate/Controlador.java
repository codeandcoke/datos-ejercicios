package com.sfaci.ejemplohibernate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sfaci.ejemplohibernate.base.Arma;
import com.sfaci.ejemplohibernate.base.Personaje;
import com.sfaci.ejemplohibernate.beans.JComboGenerico;
import com.sfaci.ejemplohibernate.beans.PanelArmas;
import com.sfaci.ejemplohibernate.beans.PanelPersonajes;
import com.sfaci.ejemplohibernate.ui.Vista;

public class Controlador implements ActionListener, ListSelectionListener, FocusListener, KeyListener {

	private Vista vista;
	private Modelo modelo;
	
	public enum Accion {
		NUEVO, MODIFICAR, GUARDAR, ELIMINAR, PANEL_ARMAS, 
		PANEL_PERSONAJES
	}
	private Accion accion;
	private Personaje personajeActual;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		vista.jEstado.setMensajeError("Bienvenido a Personajes 1.0");
		addListeners();
		cargarDatos();
	}
	
	private void addListeners() {
		
		vista.miArmas.addActionListener(this);
		vista.miPersonajes.addActionListener(this);
	}
	
	private void cargarDatos() {
		List<Personaje> personajes = modelo.getPersonajes();
		vista.mPersonajes.removeAllElements();
		for (Personaje personaje : personajes) 
			vista.mPersonajes.addElement(personaje);
	}
	
	private void cargarPersonajeActual() {
		
	}
	
	private void modoEdicion(boolean edicion) {
		
	}
	
	private void nuevoPersonaje() {
		modoEdicion(true);
	}
	
	private void modificarPersonaje() {
		
		accion = Accion.MODIFICAR;
		
		modoEdicion(true);
	}
	
	private void guardarPersonaje() {
		
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
			case PANEL_PERSONAJES:
				PanelPersonajes panelPersonajes = new PanelPersonajes(modelo);
				vista.tpPaneles.addTab("Personajes", panelPersonajes);
				break;
			case PANEL_ARMAS:
				PanelArmas panelArmas = new PanelArmas(modelo);
				vista.tpPaneles.addTab("Armas", panelArmas);
				break;
			default:
					break;
		}
	}
	
	private void comprobarNombre() {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		
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
