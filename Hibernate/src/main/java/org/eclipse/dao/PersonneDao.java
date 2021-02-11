package org.eclipse.dao;

import org.eclipse.model.Personne;
import org.hibernate.Session;

public class PersonneDao extends GenericDao<Personne, Integer> {
	public PersonneDao(Session session) {
		super(Personne.class, session);
	}
}