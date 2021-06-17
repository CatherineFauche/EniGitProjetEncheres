package fr.eni.projet.encheres.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.ConnectionProvider;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	Utilisateur utilisateur;

	@Override
	public void creerUtilisateur(Utilisateur utilisateur) {
		
		
		try (Connection cnx = ConnectionProvider.getConnection();) {
			
		
			
			PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO utilisateurs(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe)VALUES(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCp());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				utilisateur.setId(rs.getInt(1));
			}
			
			
			
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
			
}
}