package fr.eni.projet.encheres.bo;

public class Retrait {
	private Integer idArticle;
	private String rue;
	private String cp;
	private String ville;
	
	public Retrait() {
		// TODO Auto-generated constructor stub
	}

	public Retrait(Integer idArticle, String rue, String cp, String ville) {
		super();
		this.idArticle = idArticle;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Retrait [idArticle=" + idArticle + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + "]";
	}
	
	
}
