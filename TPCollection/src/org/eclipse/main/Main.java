package org.eclipse.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.eclipse.model.ListePersonnes;
import org.eclipse.model.Nombre;
import org.eclipse.model.Operation;
import org.eclipse.model.Personne;
import org.elipse.exception.OperationException;
import org.elipse.exception.PersonneException;

public class Main {

	public static void main(String[] args) {
		// exHashMap();
		// exPersonne();
		 //exOperation();
		exListePersonne();
	}

	public static void exListePersonne() {
		Scanner scanner = new Scanner(System.in);
		ListePersonnes liste = new ListePersonnes();
		boolean stop = false;
		try {
			while (!stop) {
				System.out.print("saisir le nombre de personnes: ");
				int nbre = scanner.nextInt();
				for (int i = 1; i <= nbre; i++) {
					System.out.print("entrez le nom de la personne n" + i);
					String nom = scanner.next();
					System.out.print("entrez le prenom de la personne n" + i);
					String prenom = scanner.next();
					Personne p = new Personne(i, nom, prenom);
					liste.ajouterPersonne(p);
				}

				System.out.println("voulez vous recommencer?(o/n): ");
				char choix = scanner.next().charAt(0);
				if (choix == 'n' || choix == 'N') {
					stop = true;
					for (Entry<String, Personne> entry : liste.getPersonnes().entrySet())
						System.out.println(entry.getValue().toString());
				} else {
					System.out.println("liste des personnes ajoutées:");
					for (Entry<String, Personne> entry : liste.getPersonnes().entrySet())
						System.out.println(entry.getValue().toString());
					System.out.println("on recommence:");
					liste.reinitialiser();
				}

			}
		} catch (

		PersonneException e) {
			System.out.println(e.getMessage());
		} finally {
			// scanner.close();
		}
	}

	public static void exOperation() {
		Scanner scanner = new Scanner(System.in);
		boolean stop = false;
		try {
			while (!stop) {
				System.out.print("saisir un premier nombre : ");
				int var1 = scanner.nextInt();
				System.out.print("saisir un deuxieme nombre : ");
				int var2 = scanner.nextInt();
				Nombre nbre = new Nombre(var1, var2);
				Operation op = new Operation(nbre);
				System.out.println("choix de l'operation:");
				System.out.println(
						"tapez 1 pour la division et 2 pour calculer la racine carée de la somme (3 pour quitter): ");
				int choix = scanner.nextInt();
				switch (choix) {
				case 1:
					System.out.println("le resultat de la division = " + op.division());
					break;
				case 2:
					System.out.println("racine carrée de la somme = " + op.racineDeLaSomme());
					break;
				case 3:
					stop = true;
					break;
				default:
					System.out.println("mauvais choix! ");
					System.out.println(" voulez vous continuer? (o/n)");
					char suite = scanner.next().charAt(0);
					if (suite == 'n' || suite == 'N')
						stop = true;
					break;
				}
			}
		} catch (OperationException e) {
			//System.out.println(e.getMessage());
		} finally {
			 scanner.close();
		}
	}

	public static void exHashMap() {
		Map<Integer, String> stringInt = new HashMap<Integer, String>();
		stringInt.put(7, "Paris");
		stringInt.put(5, "Rome");
		stringInt.put(1, "Manchester");
		stringInt.put(3, "Barcelone");
		String str = "Manchester ou Barcelone mais jamais Paris ni Rome .";
		StringTokenizer st = new StringTokenizer(str);
		String newStr = "";
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (stringInt.containsValue(token)) {
				for (Entry<Integer, String> entry : stringInt.entrySet()) {
					if (token.equals(entry.getValue().toString())) {
						newStr = newStr + entry.getKey().toString() + " ";
						break;
					}
				}
			} else
				newStr = newStr + token + " ";
		}
		System.out.println(newStr);

	}

	public static void exPersonne() {
		Personne p1 = new Personne(1, "Snow", "Jon");
		Personne p2 = new Personne(2, "Allen", "Barry");
		Personne p3 = new Personne(3, "Wick", "John");
		Personne p4 = new Personne(4, "Maitre", "Yoda");
		Map<String, Personne> personnes = new HashMap<>();
		personnes.put(p1.getNomPrenom(), p1);
		personnes.put(p2.getNomPrenom(), p2);
		personnes.put(p3.getNomPrenom(), p3);
		personnes.put(p4.getNomPrenom(), p4);
		for (Entry<String, Personne> entry : personnes.entrySet()) {
			if (entry.getValue().getNum() % 2 == 0)
				System.out.println(entry.getKey());
			else
				System.out.println(entry.getValue().toString());
		}
	}

}
