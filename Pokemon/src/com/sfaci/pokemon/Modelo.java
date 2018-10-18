package com.sfaci.pokemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.sfaci.pokemon.base.Pokemon;

public class Modelo {

	private HashMap<String, Pokemon> pokemones;
	private final String NOMBRE_FICHERO = "pokemones.dat";
	
	public Modelo() throws IOException, ClassNotFoundException {
		
		if (new File(NOMBRE_FICHERO).exists()) 
			cargarDeDisco();
		else
			pokemones = new HashMap<>();
	}
	
	/**
	 * Guarda un Pokemon en el fichero
	 * @param pokemon
	 * @throws IOException
	 */
	public void guardar(Pokemon pokemon) throws IOException {
		
		pokemones.put(pokemon.getNombre(), pokemon);
		guardarADisco();
	}
	
	private void guardarADisco() throws IOException {
		
		ObjectOutputStream serializador = new ObjectOutputStream(
				new FileOutputStream(NOMBRE_FICHERO));
		serializador.writeObject(pokemones);
		serializador.close();
	}
	
	private void cargarDeDisco() 
			throws IOException, ClassNotFoundException {
		
		ObjectInputStream deserializador = new ObjectInputStream(
				new FileInputStream(NOMBRE_FICHERO));
		pokemones = (HashMap<String, Pokemon>) deserializador.readObject();
		deserializador.close();			
	}
	
	public void eliminar(Pokemon pokemon) {
		
	}
	
	public void eliminarTodo() {
		
	}
	
	public void modificarPokemon(String nombre, Pokemon pokemon) {
		
	}
	
	public Pokemon getPokemon(String nombre) {
		
		return null;
	}
	
	public ArrayList<Pokemon> getPokemones() {
		
		return new ArrayList<Pokemon>(pokemones.values());
	}
	
	public ArrayList<Pokemon> getPokemones(String busqueda) {
		
		return null;
	}
}
