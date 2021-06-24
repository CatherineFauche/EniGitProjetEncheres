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
<link type="text/css" rel="stylesheet" href="4-col-portfolio.css" />
<title>Page du profil</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/MonProfil" method="post">
		<h2 class="text-center">ENI-Enchères - Mon Profil</h2>
	
		<table>
			<tr>
				<td>
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
				<td colspan="2" style="text-align: center"><input type="submit" name="submit"
					style='width: 200px; height: 50px' onclick="window.location.href = 'ModifierProfil';" autofocus="autofocus"
					value="Modifier"></td>
				<td></td>
		</table>
	</form> 
</body>
</html>