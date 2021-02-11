package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Personne;

public class PersonneDaoImpl implements PersonneDao {

	@Override
	public int save(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				c.setAutoCommit(false);
				PreparedStatement ps = c.prepareStatement("insert into personne (nom,prenom) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					c.commit();
					return resultat.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	@Override
	public void remove(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				if (findById(personne.getNum()) != null) {
					Statement st = c.createStatement();
					String sqlStr = "delete from personne where num=" + personne.getNum() + ";";
					int res = st.executeUpdate(sqlStr);
					if (res >=0)
						System.out.println("suppression effectué");
					else
						System.out.println("probleme de suppression");
				} else
					System.out.println("enregistrement introuvable");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				String sqlStr="update personne set nom= '"+personne.getNom()+
						"' , prenom= '"+ personne.getPrenom()+"' where num= "+personne.getNum();
				//PreparedStatement ps = c.prepareStatement("update personne set nom=? , prenom=? where num=?; ",
				//		PreparedStatement.RETURN_GENERATED_KEYS);
				Statement st=c.createStatement();
				int res=st.executeUpdate(sqlStr);
				//ps.setString(1, personne.getNom());
				//ps.setString(2, personne.getPrenom());
				//ps.setInt(3, personne.getNum());
				//int res=ps.executeUpdate();
				if (res<1)
					System.out.println("modification effectuée");
				else
					System.out.println("erreur de modification");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Personne findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from personne where num = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					Personne p = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
					return p;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Personne> getAll() {
		Connection c = MyConnection.getConnection();
		List personnes = new ArrayList<Personne>();
		if (c != null) {
			try {
				Statement st = c.createStatement();
				String sqlStr = "Select * from personne;";
				ResultSet r = st.executeQuery(sqlStr);
				while (r.next()) {
					Personne p = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
					personnes.add(p);
				}
				return personnes;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}
