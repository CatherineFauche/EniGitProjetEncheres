<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Reset Password</title>
    <link type="text/css" rel="stylesheet" href="4-col-portfolio.css" />
</head>
<body>
	<form  method="post" action="ReinitialisationMotDePasse">    
    <div align="center">
        <h2>Pas toujours facile de retenir un mot de passe !</h2>
        <p>
       Merci de renseigner votre adresse e-mail. Vous recevrez un lien valable 24h pour réinitialiser votre mot de passe.
        </p>
         
        <form id="ReinitialisationMotDePasse" action="ReinitialisationMotDePasse" method="post">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email" size="20"></td>
                </tr>
                <tr>
					<td>
					<td style='width: 190px; height: 30px'></td>
				</tr>
                <tr> 
                    <td colspan="2" align="center">
                        <button type="submit">Envoyer mot de passe</button>
                    </td>
                </tr>    
            </table>
        </form>
      </form>
    </div>
     
    
     
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#resetForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                }      
            },
             
            messages: {
                email: {
                    required: "Saisissez votre email",
                    email: "Saisissez une adresse mail valide"
                }
            }
        });
 
    });
</script>
</body>
</html>