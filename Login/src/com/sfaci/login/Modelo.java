package com.sfaci.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo {

	private final String IP = "192.168.34.5";
	private final String BASE_DATOS = "sfaci";
	private final String USUARIO = "sfaci";
	private final String CONTRASENA = "4fu3r4";
	
	private Connection conexion;
	
	private void cargarConfiguracion() {
		
	}
	
	public void conectar() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://" + IP + "/" + 
				BASE_DATOS, USUARIO, CONTRASENA);
	}
	
	public void desconectar() throws SQLException {
		
		conexion.close();
	}
	
	public boolean iniciarSesion(String usuario, String contrasena) 
		throws SQLException {
		
		String sql = "SELECT id FROM usuarios WHERE usuario = ? " +
					"AND contrasena = SHA1(?)";
		
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setString(1, usuario);
		sentencia.setString(2, contrasena);
		
		ResultSet resultado = sentencia.executeQuery();
		if (!resultado.next())
			return false;
		
		return true;
	}
}
