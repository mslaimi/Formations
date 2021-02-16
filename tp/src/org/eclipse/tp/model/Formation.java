package org.eclipse.tp.model;

/**
 * @author IB
 *
 */
public class Formation {
private String intitule;
private int nbJours;
private Stagiaire [] stagiaires;

public Formation(String intitule, int nbJours, Stagiaire[] stagiaires) {
	this.intitule = intitule;
	this.nbJours = nbJours;
	this.stagiaires = stagiaires;
}

public String getIntitule() {
	return intitule;
}

public void setIntitule(String intitule) {
	this.intitule = intitule;
}

public int getNbJours() {
	return nbJours;
}

public void setNbJours(int nbJours) {
	this.nbJours = nbJours;
}

public Stagiaire[] getStagiaires() {
	return stagiaires;
}

public void setStagiaires(Stagiaire[] stagiaires) {
	this.stagiaires = stagiaires;
}

public float calculerMoyenneFormation()
{
	float somme=0;
	for (Stagiaire s : this.stagiaires)
	{
		somme+=s.calculerMoyenne();
	}
			
	return (float)somme/this.stagiaires.length;
}
public int getIndexMax()
{
	float val=-1;
	int ind=-1;
	for (int i=0; i<stagiaires.length;i++)
	{
		if (stagiaires[i].calculerMoyenne()>val)
		{
			val=stagiaires[i].calculerMoyenne();
			ind=i;
		}
	}
	return ind;
}
public String afficherNomMax()
{
	return stagiaires[this.getIndexMax()].getNom();
}
public int afficherMinMax()
{
	return stagiaires[this.getIndexMax()].trouverMin();
}
public float trouverMoyenneParNom(String nom)
{
	for (Stagiaire s : this.stagiaires)
	{
		if (s.getNom()==nom)
			return s.calculerMoyenne();
	}
	
	return -1;
}
}
