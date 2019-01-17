package com.sfaci.ejemplohibernate;

import javax.swing.JOptionPane;

public class Util {
	
	public static void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
