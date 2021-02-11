package org.eclipse.main;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.adapter.EtudiantAdapter;
import org.eclipse.interfaces.IPersonne;
import org.eclipse.model.Enseignant;
import org.eclipse.model.Etudiant;
import org.eclipse.model.Fan;
import org.eclipse.model.Match;
import org.eclipse.model.Personne;
import org.eclipse.model.PersonneFactory;
import org.eclipse.model.Singleton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testObserver();
		
	}
	public static void testObserver()
	{
		Match match =new Match("0-0");
		Fan f1=new Fan("alex");
		Fan f2=new Fan("john");
		Fan f3=new Fan("max");
		match.subscribe(f1);
		match.setScore("1-0");
		match.subscribe(f2);
		match.subscribe(f3);
		match.setScore("1-1");
		match.unsubscribe(f3);
		match.setScore("2-1");
	}
	public static void testAdapter()
	{
		List<IPersonne> liste=new ArrayList();
		liste.add(new Enseignant("wick","john","math"));
		liste.add(new Enseignant("doe","john","science"));
		liste.add(new EtudiantAdapter(new Etudiant("snow","john","3eme")));
		liste.add(new EtudiantAdapter(new Etudiant("blabla","john","5eme")));
		for (IPersonne p:liste)
			p.descriptionPersonne();
	}
	public static void testSingleton()
	{
		Singleton s=Singleton.getInstance();
		System.out.println(s);
		s.setVar(10);
		String str;
		Singleton s2=Singleton.getInstance();
		System.out.println(s2);
	}
	public static void testFactory()
	{
		List<Personne> liste=new ArrayList();
		for (int i=0;i<10;i++)
		{
			Personne p=PersonneFactory.getPersonne(buildRandomString(5), buildRandomString(5), buildRandomString(5), "Etudiant");
			liste.add(p);
		}
		for (Personne p:liste)
			p.afficherDetail();
		
	}
	public static String buildRandomString(int length)
	{
		String str="";
		String chaine="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i=0;i<length;i++)
		{
			double index=Math.random()*(chaine.length()-1);
			str+=chaine.charAt((int)index);
		}
		
		return str;
	}

}
