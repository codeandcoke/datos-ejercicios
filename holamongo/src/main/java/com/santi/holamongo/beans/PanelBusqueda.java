package com.santi.holamongo.beans;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Panel de listado y búsqueda de elementos de la aplicación
 */
public class PanelBusqueda<T> extends JPanel implements KeyListener, MouseListener {
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
		
		inicializar();
	}
	
	/**
	 * Carga de nuevo los datos y refresca la lista
	 * @param datos
	 */
	private void inicializar() {				
		tfBusqueda.addKeyListener(this);
	}
	
	/**
	 * Lista los datos cargados en la lista
	 */
	public void listar(List<T> datos) {
		if (datos == null)
			return;
		
		limpiar();
		for (T dato : datos) 
			modeloLista.addElement(dato);
	}
	
	public void anadir(T dato) {
		modeloLista.addElement(dato);
	}
	
	/**
	 * Elimina todos los elementos de la lista
	 */
	public void limpiar() {
		modeloLista.removeAllElements();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
