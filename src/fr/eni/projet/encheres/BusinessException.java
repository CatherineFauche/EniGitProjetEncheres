package fr.eni.projet.encheres;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<Integer> listeCodesErreur;
	private List<String> errors;
	
	public BusinessException() {
		super();
		this.listeCodesErreur=new ArrayList<>();
	}
	
	public BusinessException(String string) {
		
	}
	public void AddressException(String string) {
		
	}
	
	public void addError(String error) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(error);
	}

	/**
	 * 
	 * @param code Code de l'erreur. 
	 * Doit avoir un message associ� dans un fichier properties.
	 */
	public void ajouterErreur(int code)
	{
		if(!this.listeCodesErreur.contains(code))
		{
			this.listeCodesErreur.add(code);
		}
	}
	
	public boolean hasErreurs()
	{
		return this.listeCodesErreur.size()>0;
	}
	
	public List<Integer> getListeCodesErreur()
	{
		return this.listeCodesErreur;
	}
	
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}

	public List<String> getErrors() {
		return errors;
	}

	

	}

