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
	
	private static final String SELECT_BY_ID =	"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM utilisateurs WHERE no_utilisateur=?";

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
	
	public Utilisateur mapping (ResultSet rs) throws SQLException {
		Utilisateur utilisateur = null;
		int idU = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("pseudo");
		String prenom = rs.getString("pseudo");
		String email = rs.getString("pseudo");
		String telephone = rs.getString("pseudo");
		String rue = rs.getString("pseudo");
		String cp = rs.getString("pseudo");
		String ville = rs.getString("pseudo");
		String mdp = rs.getString("pseudo");
		int credit = rs.getInt("credit");
		byte admin = rs.getByte("administrateur");
		
		
		return utilisateur;
	}

	@Override
	public Utilisateur selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	public Utilisateur selectById(int id) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = mapping(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_IDENTIFIANT_ERREUR);
			throw businessException;
		}
		
		return utilisateur;
	} */
}