package fr.eni.project.encheres.dal.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.ConnectionProvider;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	Utilisateur utilisateur;

	@Override
	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String cp, String ville, String motDePasse, String confirmation) {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			
		
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO utilisateur(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe)VALUES(?,?,?,?,?,?,?,?,?),Statement.RETURN_GENERATED_KEYS");
			
			while (rs.next()) {
				
			
			}
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return utilisateur;	
}
}