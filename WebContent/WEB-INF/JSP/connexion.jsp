<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="connexion">
		<meta name="author" content="Catherine Fauche">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
		<link type="text/css" rel="stylesheet" href="4-col-portfolio.css" />
		<title>Page de connexion</title>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-md navbar-light bg-dark">
				<a class="navbar-brand text-white" href="encheres">
			    	<h3>ENI-Encheres</h3>
			    </a>
			    <button type="button" class="navbar-toggler bg-light" data-toggle="collapse" data-target="#nav">
			    	<span class="navbar-toggler-icon"></span>
			    </button>
			</nav>
		</header>
		<div class="row py-2"></div>
		<h2 class="text-center">Page d'authentification</h2>
		<form action="connexion" method="post">
			
			<c:if test="${not empty errors}">
				<c:forEach var="msg" items="${errors}">
					<div class="errors"><p style="color:red; text-align:center;">Une erreur a été rencontrée: ${msg}</div>
				</c:forEach>
			</c:if>
			
			<table>
				<tr>
					<td>
					<td style='width: 190px; height: 40px'></td>
				</tr>
				<tr>
					<td>Identifiant :</td>
					<td><input type="text" name="emailPseudo" autofocus="autofocus"
						required="required" value="${emailPseudo}" size="38" maxlength="30">
				</tr>
				<tr>
					<td>Mot de passe :</td>
					<td><input type="password" name="MotDePasse"
						autofocus="autofocus" required="required" size="38" maxlength="30">
				</tr>
				<tr>
					<td>
					<td style='width: 190px; height: 30px'></td>
				</tr>
				<tr>
					<td rowspan="2"><input type="submit" name="submit"
						style='width: 200px; height: 50px' autofocus="autofocus"
						value="Connexion"></td>
					<td style="text-align: center"><input id="login-remember"
						type="checkbox" name="remember" value="1" />Se souvenir de moi</td>
				</tr>
				<tr>
					<td style="text-align: center"><a
						href="ReinitialisationMotDePasse">Mot
							de passe oublié</a></td>
				</tr>
				<tr>
					<td>
					<td style='width: 190px; height: 40px'></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center">
						<a href="inscription">
							<input type="submit" name="submit" onclick="window.location.href = 'inscription';" style='width: 630px; height: 50px' value="Créer un compte">
						</a>
					</td>
				</tr>
			</table>
		</form>
		<div class="row py-2"></div>
		<footer class="py-3 bg-dark">
	      	<div class="container">
	       		<p class="m-0 text-center text-white">Copyright &copy; ENI - Groupe C 2021</p>
	    	</div>
	    </footer>
	</body>
</html>