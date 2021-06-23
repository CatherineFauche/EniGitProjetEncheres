<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.projet.encheres.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="Inscription.css" />
    </head>
    <body>
    
    <c:if test="${!empty listeCodesErreur}">
			<div class="alert alert-danger" role="alert">
			  <strong>Erreur!</strong>
			  <ul>
			  	<c:forEach var="code" items="${listeCodesErreur}">
			  		<li>${LecteurMessage.getMessageErreur(code)}</li>
			  	</c:forEach>
			  </ul>
			</div>
		</c:if>
    
    
        <form method="post" action="inscription">
            <fieldset>
                <h1>ENI - Enchères</h1>
                <h3>Mon profil</h3>
                
                <label for="pseudo">Pseudo <span class="requis">*</span></label>
                <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="60" required="required" />
                <br />
                
                <label for="nom">Nom <span class="requis">*</span> </label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" required="required"/>
                <br />
                
                <label for="prenom">Prénom <span class="requis">*</span> </label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" required="required"/>
                <br />
                
                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" required="required" />
                <span class="erreur">${erreurs['motdepasse']}</span>
                <br />
                
                <label for="tel">Téléphone</label>
                <input type="text" id="tel" name="tel" value="" size="20" maxlength="20" />
                <br />
                
                <label for="rue">Rue</label>
                <input type="text" id="rue" name="rue" value="" size="20" maxlength="20" />
                <br />
                
                <label for="cp">Code Postal</label>
                <input type="text" id="cp" name="cp" value="" size="20" maxlength="20" />
                <br />
                
                <label for="cp">Ville</label>
                <input type="text" id="ville" name="ville" value="" size="20" maxlength="20" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" required="required"/>
                <span class="erreur">${erreurs['motdepasse']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" required="required" />
                <span class="erreur">${erreurs['confirmation']}</span>
                <br />

                

                <input type="submit" value="Créer" class="sansLabel" />
                <button onclick="window.location.href = 'encheres';">Retour</button>
                
                
                <br />
            </fieldset>
        </form>
    </body>
</html>