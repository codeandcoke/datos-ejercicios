package com.sfaci.ejemplohibernate.beans;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelArmas extends JPanel {
	public JBotonesCrud botonesCrud;
	public JTextField tfNombre;
	public JTextField tfAtaque;
	public JTextField tfDuracion;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;

	/**
	 * Create the panel.
	 */
	public PanelArmas() {
		setLayout(null);
		
		botonesCrud = new JBotonesCrud();
		botonesCrud.setBounds(158, 11, 179, 107);
		add(botonesCrud);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(62, 10, 86, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		tfAtaque = new JTextField();
		tfAtaque.setBounds(62, 36, 86, 20);
		add(tfAtaque);
		tfAtaque.setColumns(10);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(62, 62, 86, 20);
		add(tfDuracion);
		tfDuracion.setColumns(10);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 10, 37, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ataque");
		lblNewLabel_1.setBounds(10, 36, 35, 14);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Duraci\u00F3n");
		lblNewLabel_2.setBounds(10, 62, 42, 14);
		add(lblNewLabel_2);

	}
}
