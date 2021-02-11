package org.eclipse.model;

public class Etudiant extends Personne {
	private String niveau;

	public Etudiant(String nom, String prenom, String niveau) {
		super(nom, prenom);
		this.niveau = niveau;
		// TODO Auto-generated constructor stub
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public void afficherDetail() {
		System.out.println("Je suis un etudiant en "+niveau);

	}
	public void descNom()
	{
		System.out.print("je m'appelle "+this.getNom());
	}
	public void descNiveau()
	{
		System.out.println(" je suis en "+this.niveau);
	}

}
