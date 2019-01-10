package com.sfaci.ejemplohibernate.beans;

import java.util.List;

import javax.swing.JComboBox;

/**
 * Combo genérico para listar elementos del programa como Armas o Personajes
 *
 * @param <T> El tipo de objeto que se quiere listar
 */
public class JComboGenerico<T> extends JComboBox<T> {

	private List<T> datos;
	
	public JComboGenerico() {
		super();
	}
	
	public void inicializar(List<T> datos) {
		this.datos = datos;
		listar();
	}
	
	public void refrescar() {
		limpiar();
		listar();
	}
	
	public void listar() {
		if (datos == null)
			return;
		
		for (T dato : datos)
			addItem(dato);
	}
	
	public void limpiar() {
		removeAllItems();
	}
	
	public T getDatoSeleccionado() {
		T dato = (T) getSelectedItem();
		return dato;
	}
}
