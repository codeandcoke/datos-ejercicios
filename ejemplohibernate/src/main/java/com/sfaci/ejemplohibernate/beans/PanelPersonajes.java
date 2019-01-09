package com.sfaci.ejemplohibernate.beans;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.sfaci.ejemplohibernate.base.Arma;
import javax.swing.JButton;
import javax.swing.JList;
import com.sfaci.ejemplohibernate.base.Personaje;
import java.util.List;

public class PanelPersonajes extends JPanel {
	public JBotonesCrud botonesCrud;
	public JTextField tfNombre;
	public JTextField tfDescripcion;
	public JTextField tfVida;
	public JTextField tfAtaque;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JComboArma comboArma;

	/**
	 * Create the panel.
	 */
	public PanelPersonajes() {
		setLayout(null);
		
		botonesCrud = new JBotonesCrud();
		botonesCrud.setBounds(170, 11, 185, 116);
		add(botonesCrud);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(74, 11, 86, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(74, 37, 86, 20);
		add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		tfVida = new JTextField();
		tfVida.setBounds(74, 63, 86, 20);
		add(tfVida);
		tfVida.setColumns(10);
		
		tfAtaque = new JTextField();
		tfAtaque.setBounds(74, 89, 86, 20);
		add(tfAtaque);
		tfAtaque.setColumns(10);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 10, 37, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Descripci\u00F3n");
		lblNewLabel_1.setBounds(10, 36, 54, 14);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Vida");
		lblNewLabel_2.setBounds(10, 65, 20, 14);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ataque");
		lblNewLabel_3.setBounds(10, 88, 35, 14);
		add(lblNewLabel_3);
		
		comboArma = new JComboArma((List) null);
		comboArma.setBounds(10, 130, 104, 18);
		add(comboArma);

	}
}
