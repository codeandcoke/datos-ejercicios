package com.santi.holamongo.domain;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;

public class Propietario implements Comparable {

	private ObjectId id;
	private String nombre;
	private Set<Coche> coches;
	
	public Propietario() {
		coches = new HashSet<>();
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Coche> getCoches() {
		return coches;
	}
	public void setCoches(Set<Coche> coches) {
		this.coches = coches;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Propietario))
			return false;
		
		Propietario propietario = (Propietario) obj;
		if (nombre.equals(propietario.getNombre()))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
}
