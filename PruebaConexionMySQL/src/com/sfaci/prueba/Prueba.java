package com.sfaci.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Prueba {
	
	public static void main(String args[]) {
		
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.34.5:3306/damt",
					"damt", "damt");
			System.out.println("Conexión establecida con éxito");
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("No se ha podido encontrar el Driver de conexión");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Se ha producido un error al conectar con la Base de Datos");
			System.out.println("Comprueba que el servidor está iniciado");
		}
	}
}
