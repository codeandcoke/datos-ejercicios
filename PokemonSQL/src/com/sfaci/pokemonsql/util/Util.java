package com.sfaci.pokemonsql.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

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
	
	/**
	 * Copia una imagen desde la ruta original a la carpeta de imagenes
	 * con el nombre de fichero que se le pasa
	 * @param rutaOrigen La ruta absoluta a la imagen
	 * @param nombreDestino El nombre del fichero en la carpeta imagenes del programa
	 * @throws IOException 
	 */
	public static void copiarImagen(String rutaOrigen, String nombreDestino) 
			throws IOException {
		
		Path origen = FileSystems.getDefault().getPath(rutaOrigen);
		
		FileOutputStream destino = new FileOutputStream(
				new File(System.getProperty("user.dir") + 
						File.separator + "imagenes" + File.separator + nombreDestino));
		Files.copy(origen, destino);
	}
}
