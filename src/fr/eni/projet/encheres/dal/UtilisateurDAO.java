package fr.eni.projet.encheres.dal;

import fr.eni.projet.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
		void creerUtilisateur(Utilisateur utilisateur);
		
		Utilisateur afficherProfil(int id);
		
		Utilisateur modifierProfil(Utilisateur utilisateur);
		
		void supprimerProfil(int id);

}
