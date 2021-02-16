package org.eclipse.tp.model;

import java.util.Arrays;

/**
 * @author IB
 *
 */
public class Stagiaire {
private String nom;
private int [] notes=new int[3];

public Stagiaire(String nom, int[] note) {
	this.nom = nom;
	this.notes = note;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public int[] getNote() {
	return notes;
}

public void setNote(int[] note) {
	this.notes = note;
}

public float calculerMoyenne()
{
	int somme=0;
	for (int n : this.notes)
	{
		somme+=n;
	}
	return (float) somme/notes.length;
}
public int trouverMax()
{
	int max=notes[0];
	for (int n : notes)
	{
		if (n>max)
			max=n;
	}
	return max;
}
public int trouverMin()
{
	int min=notes[0];
	for (int n : notes)
	{
		if (n<min)
			min=n;
	}
	return min;
}

@Override
public String toString() {
	return "Stagiaire [nom=" + nom + ", note=" + Arrays.toString(notes) + "]";
}

}
