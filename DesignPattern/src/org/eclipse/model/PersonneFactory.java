package org.eclipse.model;

public class PersonneFactory {
	public static Personne getPersonne(String nom, String prenom, String valeur, String type) {
		if ("Etudiant".equalsIgnoreCase(type))
			return new Etudiant(nom, prenom, valeur);
		else if ("Enseignant".equalsIgnoreCase(type))
			return new Enseignant(nom, prenom, valeur);
return null;
	}
}
