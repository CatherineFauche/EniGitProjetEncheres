package fr.eni.projet.encheres.bll;


import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.DAOFactory;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	//private static UtilisateurManager instance;
	
	//Utilisateur utilisateur = new Utilisateur();
	
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur creer(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp,
			String ville, String motDePasse) {
		//TO do valider tous les champs / contraintes de la base
		// Les lister et renvoyer vers la couche présentation
		
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, motDePasse);
		//TODO appeler la dal
		this.utilisateurDAO.creerUtilisateur(utilisateur);
		
		return utilisateur;
		
	}
}
