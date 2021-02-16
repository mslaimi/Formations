package org.eclipse.tp.model;

/**
 * @author IB
 *
 */
public class Personne {
private String nom;
private String sexe;
private Adresse [] adresses;
public Personne(String nom, String sexe, Adresse[] adresses) {
	this.nom = nom;
	if (sexe == "M" || sexe == "F")
		this.sexe = sexe;
	this.adresses = adresses;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	if (sexe == "M" || sexe == "F")
			this.sexe = sexe;
}
public Adresse[] getAdresses() {
	return adresses;
}
public void setAdresses(Adresse[] adresses) {
	this.adresses = adresses;
}

}
