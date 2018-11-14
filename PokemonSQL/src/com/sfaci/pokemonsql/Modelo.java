package com.sfaci.pokemonsql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sfaci.pokemonsql.base.Pokemon;
import com.sfaci.pokemonsql.base.Pokemon.Tipo;

public class Modelo {
	
	private static final String FICHERO_CONFIGURACION = "pokemonsql.conf";
	private Connection conexion;
		
	public void conectar() throws ClassNotFoundException, SQLException, IOException {
		
		Properties props = new Properties();
		props.load(new FileInputStream(FICHERO_CONFIGURACION));
		String host = props.getProperty("host");
		String usuario = props.getProperty("usuario");
		String baseDatos = props.getProperty("base_datos");
		String contrasena = props.getProperty("contrasena");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + 
				baseDatos, usuario, contrasena);
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
		boolean encontrado = resultado.next();
		sentencia.close();
		
		if (!encontrado)
			return false;
		
		return true;
	}
	
	public void guardar(Pokemon pokemon) throws SQLException {
		
		String sql = "INSERT INTO pokemones (nombre, tipo, nivel, peso, imagen) " +
					"VALUES (?, ?, ?, ?, ?)";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setString(1, pokemon.getNombre());
		sentencia.setString(2, pokemon.getTipo().name());
		sentencia.setInt(3, pokemon.getNivel());
		sentencia.setFloat(4, pokemon.getPeso());
		sentencia.setString(5, pokemon.getImagen());
		sentencia.executeUpdate();
		sentencia.close();
	}
	
	public void modificar(Pokemon pokemon) throws SQLException {
		
		String sql = "UPDATE pokemones SET nombre = ?, tipo = ?, nivel = ? " +
					"peso = ?, imagen = ? WHERE id = ?";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setString(1, pokemon.getNombre());
		sentencia.setString(2, pokemon.getTipo().name());
		sentencia.setInt(3, pokemon.getNivel());
		sentencia.setFloat(4, pokemon.getPeso());
		sentencia.setString(5, pokemon.getImagen());
		sentencia.setLong(6, pokemon.getId());
		sentencia.executeUpdate();
		sentencia.close();
	}
	
	public void eliminar(Pokemon pokemon) throws SQLException {
		
		String sql = "DELETE FROM pokemones WHERE id = ?";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setLong(1, pokemon.getId());
		sentencia.executeUpdate();
		sentencia.close();
	}
	
	public List<Pokemon> getPokemones() throws SQLException {
		
		Pokemon pokemon = null;
		List<Pokemon> pokemones = new ArrayList<>();
		String sql = "SELECT id, nombre, nivel, peso, tipo, imagen FROM pokemones";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		ResultSet resultado = sentencia.executeQuery();
		while (resultado.next()) {
			pokemon = obtenerPokemon(resultado);
			pokemones.add(pokemon);
		}
		
		return pokemones;
	}
	
	public List<Pokemon> getPokemones(String busqueda) throws SQLException {
		
		Pokemon pokemon = null;
		List<Pokemon> pokemones = new ArrayList<>();
		String sql = "SELECT id, nombre, nivel, peso, tipo, imagen " 
				+ "FROM pokemones WHERE busqueda = ?";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setString(1, busqueda);
		ResultSet resultado = sentencia.executeQuery();
		while (resultado.next()) {
			pokemon = obtenerPokemon(resultado);
			pokemones.add(pokemon);
		}
		
		return pokemones;
	}
	
	private Pokemon obtenerPokemon(ResultSet resultado) throws SQLException {
		
		Pokemon pokemon = new Pokemon();
		pokemon.setId(resultado.getLong(1));
		pokemon.setNombre(resultado.getString(2));
		pokemon.setNivel(resultado.getInt(3));
		pokemon.setPeso(resultado.getFloat(4));
		pokemon.setTipo(Tipo.valueOf(resultado.getString(5)));
		pokemon.setImagen(resultado.getString(6));
		
		return pokemon;
	}
}
