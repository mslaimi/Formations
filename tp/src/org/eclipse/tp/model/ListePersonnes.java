package org.eclipse.tp.model;

/**
 * @author IB
 *
 */
public class ListePersonnes {
	private Personne[] personnes = new Personne[10];

	public ListePersonnes(Personne[] personnes) {
		if (personnes.length <= 10)
			this.personnes = personnes;
	}

	public Personne[] getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Personne[] personnes) {
		if (personnes.length <= 10)
			this.personnes = personnes;
	}

	public Personne findByNom(String s) {
		for (Personne per : this.personnes) {
			if (per.getNom() == s)
				return per;
		}
		return null;
	}

	public boolean findByCodePostal(String cp) {
		for (Personne per : this.personnes) {
			for (Adresse adr : per.getAdresses())
				if (adr.getCodePostal() == cp)
					return true;
		}
		return false;
	}
	public int  countPersonneVille(String ville) 
	{
		int count=0;
		for (Personne per : this.personnes) 
		{
			boolean found=false;
			for (Adresse adr : per.getAdresses())
			{
				if (adr.getVille() == ville)
					found=true;
			}
			if (found)
				count++;
		}
		return count;
	}
	public void editPersonneNom(String oldNom, String newNom) 
	{
		for (Personne per : this.personnes) {
			if (per.getNom()==oldNom)
				per.setNom(newNom);
		}
	}
	public void editPersonneVille(String nom, String newVille) 
	{
		for (Personne per : this.personnes) {
			if (per.getNom()==nom)
			{
				for (Adresse adr : per.getAdresses())
				{
					adr.setVille(newVille);
				}
			}
		}
	}
}
