package org.eclipse.Hibernate;

import org.eclipse.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Personne personne=new Personne();
    	personne.setNom("Travolta");
    	personne.setPrenom("John");
    	Configuration configuration = new Configuration().configure();
    	//configuration.addClass(Personne.class);
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	session.persist(personne);
    	transaction.commit();
    	session.close();
    	sessionFactory.close();
    	
    	
    	
    }
}
