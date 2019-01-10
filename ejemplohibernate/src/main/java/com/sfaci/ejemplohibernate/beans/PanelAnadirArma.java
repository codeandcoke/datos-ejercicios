package com.sfaci.ejemplohibernate.beans;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Dimension;

/**
 * Panel para añadir y gestionar las armas de un personaje
 */
public class PanelAnadirArma extends JPanel {
	public JPanel panel;
	public JComboGenerico comboGenerico;
	public JButton btnNewButton;
	public JScrollPane scrollPane;
	public JList list;

	public PanelAnadirArma() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		comboGenerico = new JComboGenerico();
		comboGenerico.setPreferredSize(new Dimension(100, 20));
		panel.add(comboGenerico);
		
		btnNewButton = new JButton("+");
		panel.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		scrollPane.setViewportView(list);

	}

}
