package com.sfaci.login.util;

import javax.swing.JOptionPane;

public class Util {

	public static void mensajeInformacion(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void mensajeInformacion(String mensaje) {
		mensajeInformacion("Información", mensaje);
	}
	
	public static int mensajeConfirmacion(String mensaje) {
		return JOptionPane.showConfirmDialog(null, mensaje);
	}
	
	public static void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mensajeAviso(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Aviso", 
				JOptionPane.WARNING_MESSAGE);
	}
}
