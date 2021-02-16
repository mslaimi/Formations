package org.eclipse.model;

import java.util.HashMap;
import java.util.Map;

import org.elipse.exception.PersonneException;

public class ListePersonnes {
	Map <String, Personne> personnes = new HashMap<>() ;
	public ListePersonnes()
	{
		
	}
	public void ajouterPersonne(Personne p) throws PersonneException 
	{
		if (p.getNom().isEmpty() || p.getPrenom().isEmpty()) 
			throw new PersonneException();
		personnes.put(p.getNomPrenom(), p);
	}
	public Map<String, Personne> getPersonnes() {
		return personnes;
	}
	
	public void reinitialiser()
	{
		this.personnes.clear();
	}
}
