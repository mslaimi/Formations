package org.eclipse.Hibernate;

import java.util.List;

import org.eclipse.config.HibernateUtil;
import org.eclipse.dao.PersonneDao;
import org.eclipse.model.Personne;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Personne personne = new Personne();
		personne.setNom("Ferdinand");
		personne.setPrenom("Rio");
		PersonneDao personneDao = new PersonneDao(session);
		int cle = 0;
		try {
			cle = personneDao.save(personne);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cle);
		Personne personne2 = personneDao.findById(1);
		personne2.setNom("Turing");
		try {
			personneDao.save(personne2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testHibernate() {
		Personne personne1 = new Personne();
		personne1.setNom("Travolta");
		personne1.setPrenom("John");
		Configuration configuration = new Configuration().configure();
		// configuration.addClass(Personne.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sqlRequete = "select * from Personne";
		SQLQuery query = session.createSQLQuery(sqlRequete);
		query.addEntity(Personne.class);
		List<Personne> personnes = (List<Personne>) query.list();
		for (Personne personne : personnes)
			System.out.println(personne);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
