package com.sfaci.ejemplohibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sfaci.ejemplohibernate.base.Arma;
import com.sfaci.ejemplohibernate.base.Personaje;

public class Modelo {
	
	public Modelo() {
		conectar();
	}
	
	@Override
	public void finalize() {
		desconectar();
	}
	
	private void conectar() {
		HibernateUtil.buildSessionFactory();
	}
	
	private void desconectar() {
		HibernateUtil.closeSessionFactory();
	}
	
	public void guardar(Personaje personaje) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.save(personaje);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void eliminar(Personaje personaje) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.delete(personaje);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void eliminarTodo() {
		
	}
	
	public boolean existePersonaje(String nombre) {
		Session sesion = HibernateUtil.getCurrentSession();
		Query<Personaje> query = sesion.createQuery("FROM Personaje WHERE nombre = :nombre");
		query.setParameter("nombre", nombre);
		Personaje personaje = query.uniqueResult();

		return (personaje != null);
	}
	
	public List<Personaje> getPersonajes() {
		
		Session sesion = HibernateUtil.getCurrentSession();
		ArrayList<Personaje> personajes = (ArrayList<Personaje>) sesion.createQuery("FROM Personaje").list();
		return personajes;
	}
	
	public List<Personaje> getPersonajes(String busqueda) {
		
		return null;
	}
	
	public void nueva(Arma arma) {
		
	}
	
	public void modificar(Arma arma) {
		
	}
	
	public void eliminar(Arma arma) {
		
	}
	
	public List<Arma> getArmas() {
		
		return null;
	}
}
