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
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public static synchronized UtilisateurManager getInstance() throws BusinessException {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public void creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String cp, String ville, String motDePasse, String confirmation) throws BusinessException {

		BusinessException exception = new BusinessException();

		this.validationPseudo(pseudo, exception);
		this.validationMotDePasse(motDePasse, confirmation, exception);
		this.validationEmail(email, exception);
		this.validationNom(nom, exception);
		this.validationPrenom(prenom, exception);
		this.validationTelephone(telephone, exception);

		if (!exception.hasErreurs()) {
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville,
					motDePasse);
			this.utilisateurDAO.creerUtilisateur(utilisateur);
		} else {
			throw exception;
		}
	}

	public void supprimerProfil(String pseudo) {
		this.utilisateurDAO.supprimerProfil(pseudo);

	}

	public void modifierProfil(String pseudo, String newPseudo, String newNom, String newPrenom, String newEmail,
			String newTelephone, String newRue, String newCp, String newVille, String motDePasseActuel,
			String nouveauMotDePasse, String nouveauMotDePasseConfirmation) throws BusinessException {

		Utilisateur u = this.utilisateurDAO.getByPseudo(pseudo);
		BusinessException exception = new BusinessException();

		if (newPseudo.equals(u.getPseudo())) {
			exception.ajouterErreur(CodesResultatBLL.DEJA_VOTRE_PSEUDO);
		}
		if (newEmail.equals(u.getEmail())) {
			exception.ajouterErreur(CodesResultatBLL.DEJA_VOTRE_EMAIL);
		}

		if (newPseudo.length() > 0) {
			this.validationPseudo(newPseudo, exception);
		}
		if (newEmail.length() > 0) {
			this.validationEmail(newEmail, exception);
		}
		if (newNom.length() < 1) {
			newNom = u.getNom();
		}
		if (newPrenom.length() < 1) {
			newPrenom = u.getPrenom();
		}
		if (newTelephone.length() < 1) {
			newTelephone = u.getTelephone();
		}
		if (newRue.length() < 1) {
			newRue = u.getRue();
		}
		if (newCp.length() < 1) {
			newCp = u.getCp();
		}
		if (newVille.length() < 1) {
			newVille = u.getVille();
		}
		if (motDePasseActuel.equals(u.getMotDePasse())) {
			this.validationMotDePasse(nouveauMotDePasse, nouveauMotDePasseConfirmation, exception);

		} else if (nouveauMotDePasse.length() < 1) {
			nouveauMotDePasse = u.getMotDePasse();
		} else {
			exception.ajouterErreur(CodesResultatBLL.MDP_FAUX);
		}
		if (!exception.hasErreurs()) {

			if (newPseudo.length() > 0 && newEmail.length() > 0) {

				this.utilisateurDAO.modifierProfil(newPseudo, newNom, newPrenom, newEmail, newTelephone, newRue, newCp,
						newVille, nouveauMotDePasse, pseudo);
			} else {
				throw exception;
			}

			if (newPseudo.length() < 1 && newEmail.length() > 0) {

				this.utilisateurDAO.modifierProfilUn(newNom, newPrenom, newEmail, newTelephone, newRue, newCp, newVille,
						nouveauMotDePasse, pseudo);
			} else {
				throw exception;
			}
			if (newPseudo.length() > 0 && newEmail.length() < 1) {

				this.utilisateurDAO.modifierProfilDeux(newPseudo, newNom, newPrenom, newTelephone, newRue, newCp,
						newVille, nouveauMotDePasse, pseudo);
			} else {
				throw exception;
			}
			if (newPseudo.length() < 1 && newEmail.length() < 1) {

				this.utilisateurDAO.modifierProfilTrois(newNom, newPrenom, newTelephone, newRue, newCp, newVille,
						nouveauMotDePasse, pseudo);

			} else {
				throw exception;

			}
		}
	}

	private void validationPseudo(String pseudo, BusinessException businessException) throws BusinessException {
		if (pseudo == null) {
			businessException.ajouterErreur(CodesResultatBLL.PSEUDO_NULL_ERREUR);
		}

		if (this.utilisateurDAO.validationPseudo(pseudo) == true) {
			businessException.ajouterErreur(CodesResultatBLL.PSEUDO_DEJA_EXISTANT);
		}

	}

	public boolean pseudoExiste(String pseudo, BusinessException businessException) throws BusinessException {
		if (this.utilisateurDAO.pseudoExiste(pseudo) == false) {
			businessException.ajouterErreur(CodesResultatBLL.PSEUDO_INCONNU);
		}
		return true;

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

		if (emailPseudo == null || motDePasse == null || emailPseudo.isEmpty() || motDePasse.isEmpty()) {
			throw new BusinessException(
					"L'adresse e-mail ou le pseudo ainsi que le mot de passe ne peuvent pas être vide");
		} else if (emailPseudo.length() > 30) {
			throw new BusinessException("L'adresse e-mail ou le pseudo sont trop long");
		} else if (motDePasse.length() > 30) {
			throw new BusinessException("Le mot de passe est trop long.");
		}
		String pseudo = utilisateurDAO.getUtilisateur(emailPseudo, motDePasse);

		return pseudo;
	}

	private void validationEmail(String email, BusinessException businessException) throws BusinessException {
		if (email == null) {
			businessException.ajouterErreur(CodesResultatBLL.EMAIL_NULL_ERREUR);
		}

		if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			businessException.ajouterErreur(CodesResultatBLL.EMAIL_NON_VALIDE);
		}
		if (this.utilisateurDAO.validationEmail(email) == true) {
			businessException.ajouterErreur(CodesResultatBLL.EMAIL_DEJA_EXISTANT);
		}

	}

	private void validationMotDePasse(String motDePasse, String confirmation, BusinessException businessException) {

		if (motDePasse == null || confirmation == null) {
			businessException.ajouterErreur(CodesResultatBLL.MDP_NULL_ERREUR);
		}
		if (!motDePasse.equals(confirmation)) {
			businessException.ajouterErreur(CodesResultatBLL.MDP_DIFFERENT_CONFIRMATION);
			if (motDePasse.length() < 4) {
				businessException.ajouterErreur(CodesResultatBLL.MDP_TAILLE_ERREUR);
			}
		}
	}

	private void validationNom(String nom, BusinessException businessException) {
		if (nom == null) {
			businessException.ajouterErreur(CodesResultatBLL.NOM_NULL_ERREUR);
		}

	}

	private void validationPrenom(String prenom, BusinessException businessException) {
		if (prenom == null) {
			businessException.ajouterErreur(CodesResultatBLL.PRENOM_NULL_ERREUR);
		}
	}

	private void validationTelephone(String telephone, BusinessException businessException) {
		if (telephone != "") {
			if ((!telephone.matches("^\\d+$"))) {
				businessException.ajouterErreur(CodesResultatBLL.TELEPHONE_NON_VALIDE);
			}
		}
	}

}
