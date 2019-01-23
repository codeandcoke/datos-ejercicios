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
	
	/**
	 * Guarda un personaje (y todas las armas asociadas) en la base de datos
	 * @param personaje
	 */
	public void guardar(Personaje personaje) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.save(personaje);
		for (Arma arma : personaje.getArmas()) {
			arma.setPersonaje(personaje);
			sesion.save(arma);
		}
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	/**
	 * Elimina un personaje de la base de datos
	 * @param personaje
	 */
	public void eliminar(Personaje personaje) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.delete(personaje);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void eliminarTodo() {
		
	}
	
	/**
	 * Comprueba si existe un personaje con el nombre que se pasa como parámetro
	 * @param nombre
	 * @return
	 */
	public boolean existePersonaje(String nombre) {
		Session sesion = HibernateUtil.getCurrentSession();
		Query<Personaje> query = sesion.createQuery("FROM Personaje WHERE nombre = :nombre");
		query.setParameter("nombre", nombre);
		Personaje personaje = query.uniqueResult();

		return (personaje != null);
	}
	
	/**
	 * Obtiene todos los personajes que hay en la base de datos
	 * @return
	 */
	public List<Personaje> getPersonajes() {
		
		Session sesion = HibernateUtil.getCurrentSession();
		ArrayList<Personaje> personajes = (ArrayList<Personaje>) sesion.createQuery("FROM Personaje").list();
		return personajes;
	}
	
	public List<Personaje> getPersonajes(String busqueda) {
		
		return null;
	}
	
	/**
	 * Guarda un arma en la base de datos
	 * @param arma
	 */
	public void guardar(Arma arma) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.save(arma);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	/**
	 * Elimina el arma que se pasa como parámetro
	 * @param arma
	 */
	public void eliminar(Arma arma) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.delete(arma);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	/**
	 * Obtiene todas las armas que hay en la base de datos
	 * @return
	 */
	public List<Arma> getArmas() {
		Session sesion = HibernateUtil.getCurrentSession();
		ArrayList<Arma> armas = (ArrayList<Arma>) sesion.createQuery("FROM Arma").list();
		return armas;
	}
	
	/**
	 * Obtiene todas las armas que están sin asociar con un personaje
	 * @return
	 */
	public List<Arma> getArmasLibres() {
		Session sesion = HibernateUtil.getCurrentSession();
		List<Arma> armas = (ArrayList<Arma>) 
				sesion.createQuery("FROM Arma a WHERE a.personaje IS NULL").list();
		return armas;
	}
}
