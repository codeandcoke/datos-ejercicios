package com.santi.holamongo.domain;

import java.time.LocalDate;

import org.bson.types.ObjectId;

public class Coche implements Comparable {

	private ObjectId id;
	private String marca;
	private String modelo;
	private float precio;
	private LocalDate fechaCompra;
	private Propietario propietario;
	
	public Coche() {
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId _id) {
		this.id = _id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coche))
			return false;
		
		Coche coche = (Coche) obj;
		if (marca.equals(coche.getMarca()) && (modelo.equals(coche.getModelo())))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		return marca + " " + modelo;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
