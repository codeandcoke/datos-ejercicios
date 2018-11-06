package com.sfaci.login.ui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Vista {

	private JFrame ventana;
	
	public Vista() {
	
		ventana = new JFrame();
		ventana.setSize(new Dimension(800, 600));
		ventana.setTitle("Mi Aplicaci\u00F3n");
		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
