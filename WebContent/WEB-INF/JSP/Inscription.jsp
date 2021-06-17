<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="Inscription.css" />
    </head>
    <body>
        <form method="post" action="inscription">
            <fieldset>
                <h1>ENI - Enchères</h1>
                <h3>Mon profil</h3>
                
                <label for="pseudo">Pseudo <span class="requis">*</span></label>
                <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="60" />
                <br />
                
                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <br />
                
                <label for="prenom">Prénom </label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                <br />
                
                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
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
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

                

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>