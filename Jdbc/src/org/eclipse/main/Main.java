package org.eclipse.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

public class Main {

	public static void main(String[] args) {
		PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();
		Personne personne = new Personne ("Wick","Johnnyy");
		int cle = personneDaoImpl.save(personne);
		if (cle != -1)
		System.out.println("personne numéro " + cle + " a été insérée");
		else
		System.out.println("probleme d'insertion");
		System.out.println("Find by Id::");
		Personne p1=personneDaoImpl.findById(cle);
		System.out.println("trouvé:"+p1);
		p1.setNom("modif");
		Personne per=new Personne(25,"abc","def");
		personneDaoImpl.remove(per);
		personneDaoImpl.update(p1);
		List liste=new ArrayList<Personne>();
		liste=personneDaoImpl.getAll();
		System.out.println("get all::");
		for (Object elt : liste) {
		System.out.println(elt);
		}
	}
	
	
	public static void premierTest()
	{
		Connection connexion = null;
		try {
			connexion = MyConnection.getConnection();
			Statement statement = connexion.createStatement();
			String request = "SELECT * FROM personne;";
			ResultSet result = statement.executeQuery(request);
			while (result.next()) {
				// on indique chaque fois le nom de la colonne et le type
				int idPersonne = result.getInt("num");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				// pareil pour tous les autres attributs
				System.out.println(idPersonne + ":" + nom + " " + prenom);
			}
			request = "INSERT INTO Personne (nom,prenom) VALUES ('Wick','Johny');";
			int nbr = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
			ResultSet resultat = statement.getGeneratedKeys();
			// on v´erifie s’il contient au moins une valeur
			if (resultat.next()) {
				System.out.println("Le num´ero g´en´er´e pour cette personne :" + resultat.getInt(1));
			}
			if (0 != nbr)
				System.out.println("insertion réussie");
			request = "INSERT INTO Personne (nom,prenom) VALUES (?,?);";
			PreparedStatement ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, "Wicky");
			ps.setString(2, "John");
			ps.executeUpdate();
			resultat = ps.getGeneratedKeys();
			if (resultat.next())
				System.out.println("Le num´ero g´en´er´e pour cette personne : " + resultat.getInt(1));
			// System.out.println("chargement ok");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
