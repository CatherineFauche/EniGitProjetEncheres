package fr.eni.projet.encheres.bll;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.DAOFactory;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	
	private static UtilisateurManager instance;
	private UtilisateurDAO utilisateurDAO;
	private static final String REMEMBER_LOGIN = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
	
	
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	
	/**
	 * Singleton
	 * @return
	 * @throws BusinessException
	 */
	    public static synchronized UtilisateurManager getInstance() throws BusinessException{
	        if (instance == null) {
	            instance = new UtilisateurManager();
	        }
	        return instance;
	    }
	
	public Utilisateur creer(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp,
			String ville, String motDePasse) {
		//TO do valider tous les champs / contraintes de la base
		// Les lister et renvoyer vers la couche présentation
		
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, motDePasse);
		this.utilisateurDAO.creerUtilisateur(utilisateur);
		
		return utilisateur;
	}
	
	public void supprimerProfil() {
		
		Utilisateur utilisateur = new Utilisateur();
		this.utilisateurDAO.supprimerProfil(utilisateur);
	}



	public List<Article> recupererListeEnchere() throws BusinessException {
		List<Article> listeEnchere = new ArrayList<>();
		listeEnchere = utilisateurDAO.listeEnchere();
		return listeEnchere;
	}
	
	public List<String> recupererListeCategorie() throws BusinessException {
		List<String> listeCategorie = new ArrayList<>();
		listeCategorie = utilisateurDAO.listeCategorie();
		return listeCategorie;
	}
	
	





public String validateConnection(String emailPseudo, String motDePasse) throws BusinessException {
	
	if (emailPseudo == null || motDePasse == null || emailPseudo.isEmpty() || motDePasse.isEmpty()){
    	throw new BusinessException("L'adresse e-mail ou le pseudo ainsi que le mot de passe ne peuvent pas être vide");
	}else if (emailPseudo.length() > 30) {
    	throw new BusinessException("L'adresse e-mail ou le pseudo sont trop long");
	}else if (motDePasse.length() > 30) {
    	throw new BusinessException("Le mot de passe est trop long.");
	}
	
	
String pseudo = utilisateurDAO.getUtilisateur(emailPseudo, motDePasse);
 
	return pseudo;
}

public Utilisateur afficherProfil (String pseudo) throws BusinessException {
	

	return utilisateurDAO.selectAffichageProfil(pseudo);
}


public static void storeUserCookie(HttpServletResponse response, Utilisateur user) {
	
	
}


public static void deleteUserCookie(HttpServletResponse response) {
	
	
}

}


