package fr.eni.projet.encheres.dal;

import java.util.List;

import fr.eni.projet.encheres.BusinessException;

import fr.eni.projet.encheres.bo.Article;

import fr.eni.projet.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
		void creerUtilisateur(Utilisateur utilisateur);
		
		Utilisateur afficherProfil(int id);
		
		Utilisateur modifierProfil(Utilisateur utilisateur);
		
		void supprimerProfil(Utilisateur utilisateur);
		
		public List<Article> listeEnchere() throws BusinessException;
		
		public List<String> listeCategorie() throws BusinessException;

		public String getUtilisateur(String emailPseudo, String motDePasse) throws BusinessException;

		public List<Utilisateur> findAll() throws BusinessException;
		public Utilisateur findByPseudo(String Pseudo, String motDePasse) throws BusinessException;

}
