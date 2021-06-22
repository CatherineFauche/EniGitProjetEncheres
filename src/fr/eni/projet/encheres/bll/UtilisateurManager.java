package fr.eni.projet.encheres.bll;


import fr.eni.projet.encheres.BusinessException;
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


public void ConnexionUtilisateur () {
	this.utilisateurDAO = DAOFactory.getUtilisateurDAO();}

public static synchronized UtilisateurManager getInstance() throws BusinessException {
	UtilisateurManager instance = null;
	if (instance == null) {
		instance = new UtilisateurManager();
	}
	return instance;
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

}
