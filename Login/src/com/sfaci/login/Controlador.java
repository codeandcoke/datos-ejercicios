package com.sfaci.login;

import java.sql.SQLException;

import com.sfaci.login.ui.Login;
import com.sfaci.login.ui.Vista;
import com.sfaci.login.util.Util;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		try {
			modelo.conectar();
			iniciarSesion();	
		} catch (ClassNotFoundException cnfe) {
			
		} catch (SQLException sqle) {
			
		}
	}
	
	private void iniciarSesion() {
		
		boolean autenticado = false;
		Login login = new Login();
		int intentos = 1;
		
		do {
			login.mostrarDialogo();
			String usuario = login.getUsuario();
			String contrasena = login.getContrasena();
			
			try {
				autenticado = modelo.iniciarSesion(usuario, contrasena);
				if (!autenticado) {
					if (intentos > 2) {
						Util.mensajeError("Limite de intentos superado");
						System.exit(0);
					}
					login.limpiarContrasena();
					login.setMensaje("Usuario/Contraseña incorrectos");
					intentos++;
					continue;
				}
					
				Util.mensajeInformacion("Has iniciado sesión");
			} catch (SQLException sqle) {
				Util.mensajeError("No se ha podido conectar por bla bla bla");
			}
		} while (!autenticado);
	}
}
