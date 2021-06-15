package fr.eni.projet.encheres.dal;

import fr.eni.projet.encheres.dal.jdbc.UtilisateurDAOImpl;

public class DAOFactory {
	
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}

}
