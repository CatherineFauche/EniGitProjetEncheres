package fr.eni.projet.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.CodesResultatDAL;
import fr.eni.projet.encheres.dal.ConnectionProvider;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	Utilisateur utilisateur;

	private static final String SELECT_AFFICHAGE_ENCHERE = "SELECT no_article, nom_article, date_fin_encheres,"
			+ "prix_initial, etat_vente, pseudo, a.no_categorie FROM articles_vendus a LEFT JOIN utilisateurs u"
			+ " ON a.no_utilisateur=u.no_utilisateur LEFT JOIN categories c ON a.no_categorie=c.no_categorie";

	

	@Override
	public void creerUtilisateur(Utilisateur utilisateur) {

		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(
						"INSERT INTO utilisateurs(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe)VALUES(?,?,?,?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);) {

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
			if (rs.next()) {
				utilisateur.setId(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur afficherProfil(int id) {

		Utilisateur utilisateur = null;

		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx
						.prepareStatement("SELECT *  FROM utilisateurs where no_utilisateur = ?");) {

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {

					utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
							rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
							rs.getString("code_postal"), rs.getString("ville"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return utilisateur;
	}

	@Override
	public Utilisateur modifierProfil(Utilisateur utilisateur) {

		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(
						"UPDATE utilisateurs set pseudo=?,nom=?,prenom=?,email=?,rue=?,code_postal=?,ville=?,mot_de_passe=? where no_utilisateur=?");) {

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

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public void supprimerProfil(Utilisateur utilisateur) {

		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM utilisateurs WHERE no_utilisateur=?");) {
			pstmt.setString(1, "utilisateur");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getUtilisateur(String emailPseudo, String motDePasse) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pstmt = cnx
					.prepareStatement("Select pseudo from utilisateurs where (pseudo=? or email=?) and mot_de_passe=?");
			pstmt.setString(1, emailPseudo);
			pstmt.setString(2, emailPseudo);
			pstmt.setString(3, motDePasse);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("pseudo");

			} else {
				BusinessException be = new BusinessException();
				be.addError("Identifiant ou Mot de passe Inconnu");
				throw be;
			}

		} catch (SQLException e) {
			BusinessException be = new BusinessException();
			be.addError("Error -- no User");
			throw be;
		}
	}

	@Override
	public List<Utilisateur> findAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findByPseudo(String emailPseudo, String motDePasse) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Retourne la liste d'enchere
	 */
	public List<Article> listeEnchere() throws BusinessException {
		List<Article> listeEnchere = new ArrayList<Article>();
		try (Connection cnx = ConnectionProvider.getConnection(); Statement stmt = cnx.createStatement()) {

			ResultSet rs = stmt.executeQuery(SELECT_AFFICHAGE_ENCHERE);
			Integer idArticle;
			String nomArticle;
			LocalDate dateFin;
			int prixInitial;
			int etatVente;
			String pseudo;
			int categorie;

			while (rs.next()) {
				idArticle = rs.getInt("no_article");
				nomArticle = rs.getString("nom_article");
				dateFin = rs.getDate("date_fin_encheres").toLocalDate();
				prixInitial = rs.getInt("prix_initial");
				etatVente = rs.getInt("etat_vente");
				pseudo = rs.getString("pseudo");
				categorie = rs.getInt("no_categorie");

				if (dateFin.isAfter(LocalDate.now())) {
					Article article = new Article(idArticle, nomArticle, dateFin, prixInitial, etatVente, pseudo,
							categorie);
					listeEnchere.add(article);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return listeEnchere;
	}

	/*
	 * Retourne la liste des cat�gories
	 */
	@Override
	public List<String> listeCategorie() throws BusinessException {
		List<String> listeCategorie = new ArrayList<String>();
		try (Connection cnx = ConnectionProvider.getConnection(); Statement stmt = cnx.createStatement()) {

			ResultSet rs = stmt.executeQuery("SELECT * FROM categories");
			String nomCategorie;

			while (rs.next()) {
				nomCategorie = rs.getString("libelle");
				listeCategorie.add(nomCategorie);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return listeCategorie;
	}

	@Override
	public Utilisateur selectAffichageProfil(String pseudo) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pstmt = cnx
					.prepareStatement("select pseudo, nom, prenom, email, telephone, rue, code_postal, ville "
							+ " from utilisateurs where pseudo = ?");

			{
				pstmt.setString(1, pseudo);
				ResultSet rs = pstmt.executeQuery();
				{
					if (rs.next()) {
					
						Utilisateur utilisateur = mapping(rs);
						return utilisateur;

					} else {
						BusinessException be = new BusinessException();
						be.addError("Profil Inconnu");
						throw be;
					}

				}
			}
		} catch (SQLException e) {
			BusinessException be = new BusinessException();
			be.addError("Error -- no Profil");
			throw be;
		}

	}

	private Utilisateur mapping(ResultSet rs) throws SQLException {
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String code_postal = rs.getString("code_postal");
		String ville = rs.getString("ville");

		return new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville);

	}


}