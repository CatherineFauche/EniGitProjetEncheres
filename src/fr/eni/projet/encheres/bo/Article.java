package fr.eni.projet.encheres.bo;

import java.time.LocalDate;

public class Article {
	//Attribut
	private Integer idArticle;
	private String nomArticle;
	private String descritpion;
	private LocalDate dateDepart;
	private LocalDate dateFin;
	private int prixInitial;
	private int  prixVente;
	private int etatVente;
	private String pseudo;
	private int idCategorie;
	
	
	//Constructeur
	public Article() {	}

	
	
	public Article(Integer idArticle, String nomArticle, String descritpion, LocalDate dateDepart, LocalDate dateFin,
			int prixInitial, int prixVente, int etatVente, String pseudo, int idCategorie) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.descritpion = descritpion;
		this.dateDepart = dateDepart;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.pseudo = pseudo;
		this.idCategorie = idCategorie;
	}


	//contructeur affichage enchères page navigation
	public Article(Integer idArticle, String nomArticle, LocalDate dateFin, int prixInitial, int etatVente,
			String pseudo, int categorie) {
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.etatVente = etatVente;
		this.pseudo = pseudo;
		this.idCategorie = categorie;
	}



	//Getter/setter	
	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public String getIdUtilisateur() {
		return pseudo;
	}

	public void setIdUtilisateur(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(int etatVente) {
		this.etatVente = etatVente;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", descritpion=" + descritpion
				+ ", dateDepart=" + dateDepart + ", dateFin=" + dateFin + ", prixInitial=" + prixInitial
				+ ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", pseudo=" + pseudo + ", idCategorie="
				+ idCategorie + "]";
	}

}
