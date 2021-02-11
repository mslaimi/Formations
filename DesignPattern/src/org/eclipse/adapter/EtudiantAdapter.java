package org.eclipse.adapter;

import org.eclipse.interfaces.IPersonne;
import org.eclipse.model.Etudiant;

public class EtudiantAdapter implements IPersonne{

	private Etudiant etudiant;
	
	public EtudiantAdapter(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public void descriptionPersonne() {
		this.etudiant.descNom();
		this.etudiant.descNiveau();
		
	}

}
