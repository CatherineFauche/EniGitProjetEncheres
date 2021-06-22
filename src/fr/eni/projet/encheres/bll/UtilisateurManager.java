package fr.eni.projet.encheres.bll;


import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.DAOFactory;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	
	private static UtilisateurManager instance;
	private UtilisateurDAO utilisateurDAO;
	
	
	
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
	
	
}
