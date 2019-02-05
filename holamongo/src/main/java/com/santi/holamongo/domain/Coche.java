package com.santi.holamongo.domain;

import java.time.LocalDate;

import org.bson.types.ObjectId;

public class Coche {

	private ObjectId _id;
	private String marca;
	private String modelo;
	private float precio;
	private LocalDate fechaCompra;
	
	public Coche() {
		super();
	}
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
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
	
	@Override
	public String toString() {
		return marca + " " + modelo;
	}
	
	public void reparar() {
		
	}
}
