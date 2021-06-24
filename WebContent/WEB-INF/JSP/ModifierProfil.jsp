<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
       <link type="text/css" rel="stylesheet" href="Inscription.css" />
    </head>
    <body>
        <form method="post" action="ModifierProfil">
            <fieldset>
                <h1>ENI - Enchères</h1>
                <h3>Modifier mon profil</h3>
                
                <label for="pseudo">Pseudo</label>
                <input type="text" id="pseudo" name="pseudo" placeholder="${pseudo}" value="" size="20" maxlength="60" />
                <br />
                
                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="${nom}" size="20" maxlength="20" />
                <br />
                
                <label for="prenom">Prénom </label>
                <input type="text" id="prenom" name="prenom" value="${prenom}" size="20" maxlength="20" />
                <br />
                
                <label for="email">Adresse email</label>
                <input type="text" id="email" name="email" value="${email}" size="20" maxlength="60" />
                <br />
                
                <label for="tel">Téléphone</label>
                <input type="text" id="tel" name="tel" value="${telephone}" size="20" maxlength="20" />
                <br />
                
                <label for="rue">Rue</label>
                <input type="text" id="rue" name="rue" value="${rue}" size="20" maxlength="20" />
                <br />
                
                <label for="cp">Code Postal</label>
                <input type="text" id="cp" name="cp" value="${cp}" size="20" maxlength="20" />
                <br />
                
                <label for="cp">Ville</label>
                <input type="text" id="ville" name="ville" value="${ville}" size="20" maxlength="20" />
                <br />

                <label for="motdepasse">Mot de passe </label>
                <input type="password" id="motdepasse" name="motdepasse" value="${motDePasse}" size="20" maxlength="20" />
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />
                
                <label for="motdepasse">Nouveau mot de passe </label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />
                
                <label for="credit">Crédit</label>
                
                <br />

                

                <input type="submit" value="Enregistrer" class="sansLabel" /> 
                <button type="button" value ="" onclick="window.location.href = 'http://localhost:8080/EniGitProjetEncheres/MonProfil';">Supprimer mon compte</button>
                
                
                
                <br />
            </fieldset>
        </form>
    </body>
</html>