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
	
	/**
	 * Carga los datos del Combo y lo refresca
	 * @param datos
	 */
	public void inicializar(List<T> datos) {
		this.datos = datos;
		refrescar();
	}
	
	/**
	 * Refresca el listado del combo
	 */
	public void refrescar() {
		limpiar();
		listar();
	}
	
	/**
	 * Lista los datos en el combo
	 */
	public void listar() {
		if (datos == null)
			return;
		
		for (T dato : datos)
			addItem(dato);
	}
	
	/**
	 * Elimina los datos listados en el combo
	 */
	public void limpiar() {
		removeAllItems();
	}
	
	/**
	 * Devuelve el elemento seleccionado en el combo
	 * @return
	 */
	public T getDatoSeleccionado() {
		T dato = (T) getSelectedItem();
		return dato;
	}
}
