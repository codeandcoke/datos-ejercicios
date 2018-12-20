package com.sfaci.ejemplohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.sfaci.ejemplohibernate.base.Arma;
import com.sfaci.ejemplohibernate.base.Personaje;

public class HibernateUtil {

  private static SessionFactory sessionFactory;
  private static Session session;

  public static void buildSessionFactory() {

	Configuration configuration = new Configuration();
	configuration.configure();
	// Se registran las clases que hay que mapear con cada tabla de la base de datos
	configuration.addAnnotatedClass(Personaje.class);
	configuration.addAnnotatedClass(Arma.class);
	
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	  configuration.getProperties()).build();
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
  }
	
  public static void openSession() {
    session = sessionFactory.openSession();
  }
	
  public static Session getCurrentSession() {
	
    if ((session == null) || (!session.isOpen()))
      openSession();
			
    return session;
  }
	
  public static void closeSessionFactory() {
	
    if (session != null)
      session.close();
		
    if (sessionFactory != null)
      sessionFactory.close();
  }
}