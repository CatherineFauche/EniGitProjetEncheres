package fr.eni.projet.encheres.bo;

import java.time.LocalDate;


public class Enchere {
	private Integer idUtilisateur;
	private Integer idArticle;
	private LocalDate dateEnchere;
	private int montantEnchere;
	
	
	public Enchere() {	}
	
	public Enchere(Integer idUtilisateur, Integer idArticle, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.idArticle = idArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [idUtilisateur=" + idUtilisateur + ", idArticle=" + idArticle + ", dateEnchere=" + dateEnchere
				+ ", montantEnchere=" + montantEnchere + "]";
	}
	
	
}
