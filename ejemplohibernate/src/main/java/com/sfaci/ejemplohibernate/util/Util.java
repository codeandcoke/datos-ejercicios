package com.sfaci.ejemplohibernate.util;

import javax.swing.JOptionPane;

public class Util {
	
	public static final int SI = JOptionPane.YES_OPTION;
	public static final int NO = JOptionPane.NO_OPTION;
	
	public static void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static int mensajeConfirmacion() {
		return JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Confirmar", JOptionPane.YES_NO_OPTION);
	}
}
