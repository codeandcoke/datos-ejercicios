package com.sfaci.ejemplohibernate.base;

public class Arma {
	
	private long id;
	private String nombre;
	private int ataque;
	private int duracion;
	
	private Personaje personaje;
	
	public Arma() {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	

}
