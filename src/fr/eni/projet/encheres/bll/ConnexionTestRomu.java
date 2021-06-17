package fr.eni.projet.encheres.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.encheres.bo.Utilisateur;

public class ConnexionTestRomu {
	
	private static final String emailUtilisateur = "email";
	private static final String pseudoUtilisateur = "pseudo";
	private static final String motDePasseUtilisateur = "motDePasse";
	
	
	private Map<String,String>erreurs = new HashMap<String, String>();
	
	

	public Map<String,String> getErreurs() {
		return erreurs;
	}
	
	public Utilisateur connecterUtilisateur(HttpServletRequest request) {
		
		String email = getValeur(request, emailUtilisateur);
		String pseudo = getValeur(request, pseudoUtilisateur);
		String motDePasse = getValeur(request, motDePasseUtilisateur);
		
		Utilisateur utilisateur = new Utilisateur();
		
		try {
            validationPseudo(pseudo);
        } catch ( Exception e ) {
            setErreur(pseudo, e.getMessage() );
        }
        utilisateur.setPseudo( pseudo );
		
		 try {
	            validationEmail(email);
	        } catch ( Exception e ) {
	            setErreur(email, e.getMessage() );
	        }
	        utilisateur.setEmail( email );
	        
	      try {
	            validationMotDePasse(motDePasse);
	        } catch ( Exception e ) {
	            setErreur(motDePasse, e.getMessage() );
	        }
	        utilisateur.setMotDePasse( motDePasse );
	        
	        
	        
	        
	 return utilisateur;
		
	}
	
	private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }
	
	 private void validationMotDePasse( String motDePasse ) throws Exception {
	        if ( motDePasse != null ) {
	            if ( motDePasse.length() < 3 ) {
	                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
	            }
	        } else {
	            throw new Exception( "Merci de saisir votre mot de passe." );
	        }
	    }
	 
	 private void validationPseudo(String pseudo) throws Exception{
		 if (pseudo != null && pseudo.length() < 3 ) {
             throw new Exception( "Le pseudo doit contenir au moins 3 caractères." );
         }
     
	 }
	 private void setErreur( String champ, String message ) {
	        erreurs.put( champ, message );
	    }
	 
	 private static String getValeur( HttpServletRequest request, String attribut) {
	        String valeur = request.getParameter( attribut );
	        if ( valeur == null || valeur.trim().length() == 0 ) {
	            return null;
	        } else {
	            return valeur;
	        }
	    }
	 
	
}
