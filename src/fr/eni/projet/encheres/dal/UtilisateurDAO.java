package fr.eni.projet.encheres.dal;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
		void creerUtilisateur(Utilisateur utilisateur);
		
		Utilisateur selectById(int id) throws BusinessException;

}
