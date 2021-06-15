package fr.eni.projet.encheres.dal;

import fr.eni.projet.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp,
			String ville, String motDePasse, String confirmation);

}
