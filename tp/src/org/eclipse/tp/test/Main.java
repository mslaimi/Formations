package org.eclipse.tp.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import org.eclipse.tp.model.Adresse;
import org.eclipse.tp.model.Formation;
import org.eclipse.tp.model.ListePersonnes;
import org.eclipse.tp.model.Personne;
import org.eclipse.tp.model.Point;
import org.eclipse.tp.model.Stagiaire;
import org.eclipse.tp.model.TroisPoints;

/**
 * @author IB
 *
 */
public class Main {

	public static void main(String[] args) {
		/**main
		 * test des differentes classes
		 */
		/*HashMap<String, Integer> repetition = new HashMap();
		repetition.put("Java", 2);
		repetition.put("PHP", 5);
		repetition.put("C++", 1);
		repetition.put("HTML", 4);
		for (Entry<String, Integer> entry : repetition.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++)
				System.out.print(entry.getKey());
			System.out.print(" ");
		}
		
		List list = Arrays.asList(2,5,"Bonjour",true,'c',"3","b",false,10,15,7,"Hello");
		HashMap<String,Integer> types=new HashMap();
		
		for(int i = 0; i < list.size(); i++)
		{
			String type=list.get(i).getClass().getSimpleName();
			if(types.containsKey(type))
				types.put(type, types.get(type)+1);
			else
				types.put(type, 1);
		}
		
		for (Entry<String, Integer> entry : types.entrySet()) {
				System.out.println(entry.getKey()+" : "+entry.getValue());
		}*/
		int x = 5, y = 0;
		try {
		System.out.println(x/y);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		System.out.println("Fin de calcul");
	}

	
	
	public static void testPersonne() {
		Adresse adr1 = new Adresse("Paix", "75000", "Paris");
		Adresse adr2 = new Adresse("Voltaire", "75000", "Paris");
		Adresse adr3 = new Adresse("Paix", "36000", "Nice");
		Adresse adr4 = new Adresse("Voltaire", "92000", "Nanterre");
		Adresse[] tabAdr1 = { adr1, adr2 };
		Adresse[] tabAdr2 = { adr3, adr4 };
		Personne p1 = new Personne("Doe", "M", tabAdr1);
		Personne p2 = new Personne("Dupont", "M", tabAdr2);
		Personne p3 = new Personne("Robin", "F", tabAdr1);
		Personne p4 = new Personne("Dupont", "F", tabAdr2);
		Personne[] tabP = { p1, p2, p3, p4 };
		ListePersonnes listeP = new ListePersonnes(tabP);
		System.out.println(listeP.countPersonneVille("Paris"));
		System.out.println(listeP.findByCodePostal("36000"));
		System.out.println(listeP.findByCodePostal("90000"));
		listeP.editPersonneNom("Doe", "Pierre");
		System.out.println(p1.getNom());
		listeP.editPersonneVille("Dupont", "Marseille");
		System.out.println(listeP.findByNom("Dupont").getAdresses()[0].getVille());

	}

	public static void testPoint() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("entrez les coordonnées des 3 points:");
		System.out.print("abs premier point:");
		double a1 = scanner.nextDouble();
		System.out.print("ord premier point:");
		double b1 = scanner.nextDouble();
		System.out.print("abs deuxieme point:");
		double a2 = scanner.nextDouble();
		System.out.print("ord deuxieme point:");
		double b2 = scanner.nextDouble();
		System.out.print("abs troisieme point:");
		double a3 = scanner.nextDouble();
		System.out.print("ord troisieme point:");
		double b3 = scanner.nextDouble();
		scanner.close();
		Point p1 = new Point(a1, b1);
		Point p2 = new Point(a2, b2);
		Point p3 = new Point(a3, b3);
		TroisPoints p = new TroisPoints(p1, p2, p3);
		System.out.print("milieu " + p1.toString() + " et " + p2.toString() + " (1 et 2 ) : ");
		System.out.println(p1.calculerMilieu(p2).toString());
		System.out.print("milieu " + p1.toString() + " et " + p3.toString() + "  (1 et 3): ");
		System.out.println(p1.calculerMilieu(p3).toString());
		System.out.print("milieu " + p2.toString() + " et " + p3.toString() + " (2 et 3): ");
		System.out.println(p2.calculerMilieu(p3).toString());
		System.out.print("distance entre " + p1.toString() + " et " + p2.toString() + ": ");
		System.out.println(p1.calculerDistance(p2));
		System.out.print("distance entre " + p1.toString() + " et " + p3.toString() + ": ");
		System.out.println(p1.calculerDistance(p3));
		System.out.print("distance entre " + p2.toString() + " et " + p3.toString() + ": ");
		System.out.println(p2.calculerDistance(p3));
		if (p.testerAlignement())
			System.out.println("les trois points sont alignés");
		else
			System.out.println("les trois points ne sont pas alignés");
		if (p.estTriangleEquilateral())
			System.out.println("les trois points forment un triangle equilateral");
		else
			System.out.println("les trois points ne forment pas un triangle equilateral");

	}

	public static void testFormation() {
		int[] tNote1 = { 10, 15, 9 };
		int[] tNote2 = { 12, 7, 11 };
		int[] tNote3 = { 10, 9, 11 };
		int[] tNote4 = { 8, 15, 13 };
		Stagiaire s1 = new Stagiaire("Dupont", tNote1);
		Stagiaire s2 = new Stagiaire("Robin", tNote2);
		Stagiaire s3 = new Stagiaire("Petit", tNote3);
		Stagiaire s4 = new Stagiaire("Robin", tNote4);
		Stagiaire[] tabStagiaires = { s1, s2, s3, s4 };
		Formation formation = new Formation("java", 5, tabStagiaires);
		System.out.print("Moyenne de " + s1.getNom() + ":" + s1.calculerMoyenne());
		System.out.println(" avec une note max : " + s1.trouverMax() + " et min : " + s1.trouverMin());

		System.out.println("Moyenne de la formation :" + formation.calculerMoyenneFormation());
		System.out.println(
				"meilleure moyenne attribuée à :" + formation.afficherNomMax() + "(" + formation.getIndexMax() + ")");
		System.out.println("letudiant Robin a la moyenne :" + formation.trouverMoyenneParNom("Robin"));
	}

}
