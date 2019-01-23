package com.sfaci.ejemplohibernate.beans;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.sfaci.ejemplohibernate.Modelo;

/**
 * Panel de listado y búsqueda de elementos de la aplicación
 */
public class PanelBusqueda<T> extends JPanel implements KeyListener {
	public JTextField tfBusqueda;
	public JScrollPane scrollPane;
	public JList<T> lista;
	public DefaultListModel<T> modeloLista;
	
	private List<T> datos;

	public PanelBusqueda() {
		setLayout(new BorderLayout(0, 0));
		
		tfBusqueda = new JTextField();
		add(tfBusqueda, BorderLayout.SOUTH);
		tfBusqueda.setColumns(10);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		lista = new JList<>();
		scrollPane.setViewportView(lista);
		modeloLista = new DefaultListModel<>();
		lista.setModel(modeloLista);
	}
	
	/**
	 * Carga de nuevo los datos y refresca la lista
	 * @param datos
	 */
	public void inicializar(List<T> datos) {
		this.datos = datos;
		
		modeloLista = new DefaultListModel<>();
		lista.setModel(modeloLista);
		
		tfBusqueda.addKeyListener(this);
		
		refrescar();
	}
	
	/**
	 * Lista los datos cargados en la lista
	 */
	public void listar() {
		if (datos == null)
			return;
		
		for (T dato : datos) 
			modeloLista.addElement(dato);
	}
	
	/**
	 * Elimina todos los elementos de la lista
	 */
	public void limpiar() {
		modeloLista.removeAllElements();
	}
	
	/**
	 * Refresca el listado
	 */
	public void refrescar() {
		limpiar();
		listar();
	}
	
	/**
	 * Devuelve el elemento seleccionado de la lista
	 * @return
	 */
	public T getSeleccionado() {
		return lista.getSelectedValue();
	}
	
	/**
	 * Comprueba si hay algún elemento seleccionado en la lista
	 * @return
	 */
	public boolean estaSeleccionado() {
		return lista.getSelectedIndex() != -1;
	}
	
	private void buscar() {
		
	}
	
	/**
	 * Añade un MouseListener a la lista
	 * @param listener
	 */
	public void addListener(MouseListener listener) {
		lista.addMouseListener(listener);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (tfBusqueda.getText().length() < 3)
			return;
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			buscar();
		}
	}
}
