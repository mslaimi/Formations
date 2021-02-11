package org.eclipse.model;

import org.eclipse.interfaces.IPersonne;

public class Enseignant extends Personne implements IPersonne{

	private String specialite;
	
	
	public Enseignant(String nom, String prenom, String specialite) {
		super(nom, prenom);
		this.specialite = specialite;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	@Override
	public void afficherDetail() {
		System.out.println("je suis un prof de "+specialite);

	}

	@Override
	public void descriptionPersonne() {
		System.out.println("je m'appelle "+this.getNom());
		
	}

}
