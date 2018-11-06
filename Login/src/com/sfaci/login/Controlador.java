package com.sfaci.login;

import com.sfaci.login.ui.Login;
import com.sfaci.login.ui.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		
		modelo.conectar();
		iniciarSesion();
		
	}
	
	private void iniciarSesion() {
		Login login = new Login();
	
	}
}
