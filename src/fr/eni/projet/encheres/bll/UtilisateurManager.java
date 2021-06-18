package fr.eni.projet.encheres.bll;


import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.DAOFactory;
import fr.eni.projet.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	
	
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
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
}
