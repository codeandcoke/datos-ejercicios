package com.sfaci.ejemplohibernate.beans;

import java.util.List;

import javax.swing.JComboBox;

public class JComboArma<Arma> extends JComboBox<Arma> {

	private List<Arma> armas;
	
	public JComboArma() {
		super();
		listar();
	}
	
	public void inicializar(List<Arma> armas) {
		this.armas = armas;
		listar();
	}
	
	public void refrescar() {
		limpiar();
		listar();
	}
	
	public void listar() {
		for (Arma arma : armas)
			addItem(arma);
	}
	
	public void limpiar() {
		removeAllItems();
	}
	
	public Arma getArmaSeleccionada() {
		Arma arma = (Arma) getSelectedItem();
		return arma;
	}
}
