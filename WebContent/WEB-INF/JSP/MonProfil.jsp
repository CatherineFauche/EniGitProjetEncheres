<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="connexion">
		<meta name="author" content="Catherine Fauche">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
		<link type="text/css" rel="stylesheet" href="4-col-portfolio.css" />
		<title>Page du profil</title>
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
		<h2 class="text-center">Mon Profil</h2>
		<form action="./MonProfil" method="post">
			<table>
				<tr>
					<td> </td>
					<td style='width: 190px; height: 40px'></td>
				</tr>
				<tr>
					<td>Pseudo :  </td>
					<td><input value="${userProfil.pseudo}" type="text" name="Pseudo" autofocus="autofocus" size="40" maxlength="30" >
				</tr>
				<tr>
					<td>Nom :</td>
					<td><input value="${userProfil.nom}" type="text"name="Nom"
						autofocus="autofocus" size="40" maxlength="30">
				</tr>
				<tr>
					<td>Prénom :</td>
					<td><input value="${userProfil.prenom}" type="text" name="Prenom"
						autofocus="autofocus"  size="40" maxlength="30">
				</tr>
				<tr>
					<td>Email :</td>
					<td><input value="${userProfil.email}" type="text"  name="Email"
						autofocus="autofocus" size="40" maxlength="30">
				</tr>
				<tr>
					<td>Téléphone:</td>
					<td><input value="${userProfil.telephone}" type="text" name="Telephone"
						autofocus="autofocus"  size="40" maxlength="15">
				</tr>
				<tr>
					<td>Rue:</td>
					<td><input value="${userProfil.rue}" type="text" name="Rue"
						autofocus="autofocus"  size="40" maxlength="30">
				</tr>
				<tr>
					<td>Code postal :</td>
					<td><input value="${userProfil.cp}" type="text" name="CodePostal"
						autofocus="autofocus"  size="40" maxlength="10">
				</tr>
				<tr>
					<td>Ville:</td>
					<td><input value="${userProfil.ville}" type="text" name="Ville"
						autofocus="autofocus"  size="40" maxlength="30">
				</tr>
				<tr>
					<td>
					<td style='width: 190px; height: 30px'></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center">
						<input type="button" name="submit"
						style='width: 200px; height: 50px' onclick="window.location.href = 'http://localhost:8080/EniGitProjetEncheres/ModifierProfil';" autofocus="autofocus"
						value="Modifier">
					</td>
					<td></td>
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