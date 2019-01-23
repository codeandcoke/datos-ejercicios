package com.sfaci.ejemplohibernate.beans;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sfaci.ejemplohibernate.Modelo;
import com.sfaci.ejemplohibernate.base.Arma;

/**
 * Panel para añadir y gestionar las armas de un personaje
 * Contiene un Combo para listarlas, un botón para añadirlas y una lista
 * para mostrarlas
 */
public class PanelAnadirArma extends JPanel implements ActionListener {
	public JPanel panel;
	public JComboGenerico<Arma> cbArmas;
	public JButton btAnadir;
	public JScrollPane scrollPane;
	public JList<Arma> lArmas;
	public DefaultListModel<Arma> modeloLista;
	public JButton btEliminar;

	public PanelAnadirArma() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		cbArmas = new JComboGenerico<>();
		cbArmas.setPreferredSize(new Dimension(100, 20));
		panel.add(cbArmas);
		
		btAnadir = new JButton("+");
		panel.add(btAnadir);
		
		btEliminar = new JButton("-");
		panel.add(btEliminar);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		lArmas = new JList<>();
		scrollPane.setViewportView(lArmas);
		modeloLista = new DefaultListModel<>();
		lArmas.setModel(modeloLista);

		inicializar();
	}
	
	private void inicializar() {
		Modelo modelo = new Modelo();
		List<Arma> armas = modelo.getArmasLibres();
		cbArmas.inicializar(armas);
		
		btAnadir.addActionListener(this);
		btEliminar.addActionListener(this);
	}
	
	public List<Arma> getListadoArmas() {
		List<Arma> armas = new ArrayList<>();
		for (int i = 0; i < modeloLista.size(); i++) {
			armas.add(modeloLista.getElementAt(i));
		}
		
		return armas;
	}
	
	public void anadirArmas(List<Arma> armas) {
		modeloLista.removeAllElements();
		for (Arma arma : armas)
			modeloLista.addElement(arma);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch (actionCommand) {
		case "+":
			Arma armaSeleccionada = cbArmas.getDatoSeleccionado();
			if (armaSeleccionada == null)
				return;
			
			if (modeloLista.contains(armaSeleccionada))
				return;
			
			modeloLista.addElement(armaSeleccionada);
			break;
		case "-":
			if (lArmas.getSelectedIndex() == -1)
				return;
			
			cbArmas.addItem(modeloLista.remove(lArmas.getSelectedIndex()));
			break;
		}
	}

}
