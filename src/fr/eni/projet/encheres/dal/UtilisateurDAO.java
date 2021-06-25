package fr.eni.projet.encheres.dal;

import java.util.List;

import fr.eni.projet.encheres.BusinessException;

import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
		void creerUtilisateur(Utilisateur utilisateur)throws  BusinessException;
	
		Utilisateur afficherProfil(int id);
		
		void modifierProfil(String newPseudo, String newNom, String newPrenom, String newEmail, String newTelephone, String newRue, String newCp, String newVille,String nouveauMotDePasse,String pseudo) throws BusinessException;
		
		void supprimerProfil(String pseudo);
		
		public List<Article> listeEnchere() throws BusinessException;
		
		public List<Categorie> listeCategorie() throws BusinessException;

		public String getUtilisateur(String emailPseudo, String motDePasse) throws BusinessException;

		public List<Utilisateur> findAll() throws BusinessException;
		
		public Utilisateur findByPseudo(String Pseudo, String motDePasse) throws BusinessException;
		
		boolean validationPseudo(String pseudo) throws BusinessException;
		
		boolean pseudoExiste(String pseudo)throws BusinessException;;

		boolean validationEmail(String email)throws BusinessException;

		Utilisateur getByPseudo(String pseudo) throws BusinessException;


		
		Utilisateur selectAffichageProfil(String pseudo) throws BusinessException;
		


		void modifierProfilUn(String newNom, String newPrenom, String newEmail, String newTelephone, String newRue,
				String newCp, String newVille, String nouveauMotDePasse, String pseudo) throws BusinessException;

		void modifierProfilDeux(String pseudo, String newNom, String newPrenom, String newTelephone, String newRue,
				String newCp, String newVille, String nouveauMotDePasse, String pseudo2) throws BusinessException;

		void modifierProfilTrois(String newNom, String newPrenom, String newTelephone, String newRue, String newCp,
				String newVille, String nouveauMotDePasse, String pseudo) throws BusinessException;

		
		public List<Article> filtreEnchereParCategorie(int categorieFiltre) throws BusinessException;
}
