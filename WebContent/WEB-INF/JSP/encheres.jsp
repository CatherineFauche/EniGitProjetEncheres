<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.projet.encheres.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/8ed12d656b.js" crossorigin="anonymous"></script>
		<title>Enchères</title>
	</head>
	
	<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-light bg-dark">
			<a class="navbar-brand text-white" href="https://www.eni-ecole.fr/">
		    	<h3>ENI-Encheres</h3>
		    </a>
		    <button type="button" class="navbar-toggler bg-light" data-toggle="collapse" data-target="#nav">
		    	<span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse justify-content-between" id="nav">
				<ul class="navbar-nav">
					<c:choose>
						<c:when test="${!empty sessionScope.identifiant && !empty sessionScope.password}">
							<li class="nav-item">
						    	<a class="nav-link text-light px-3" href="#">Enchères</a>
						    </li>
						    <li class="nav-item">
						    	<a class="nav-link text-light px-3" href="#">Vendre un article</a>
						    </li>
						    <li class="nav-item">
						    	<a class="nav-link text-light px-3" href="#">Mon profil</a>
						    </li>
						    <li class="nav-item">
						    	<a class="nav-link text-light px-3" href="#">Déconnection</a>
						    </li>
						</c:when>
						<c:otherwise>
							<li class="nav-item">
							 	<a class="nav-link text-light px-3" href="#">S'inscrire - Connection</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>
	</header> 
	
		<h2 class="text-center">Liste des enchères</h2>
		
		
		<div class="col-12">
			<!-- message erreur -->
			<div class="row py-3"></div>
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
			
			<div class="container">
				<form action="#">
					<div class="row ">
						<div class="col-9">
							<div class="row">
						   		Filtres :
						    </div>
						    <div class="row">
						    	<div class="col-6">
						   			<input type="text" class="form-control" placeholder="Le nom de l'article contient">
						   		</div>
						    </div>
						    <div class="row">
						    	<div class="col-4">
							    	<select name="categories" id="categorie-select">
									    <option value="all">--Toutes catégories--</option>
									    <option value="informatique">Informatique</option>
									    <option value="meuble">Ameublement</option>
									    <option value="vetement">Vêtements</option>
									    <option value="sportLoisir">Sport&Loisirs</option>
									</select>
								</div>
						    </div>
						    <c:if test="${!empty sessionScope.identifiant && !empty sessionScope.password}">
								<div class="row">
						   			<div class="col-6">
						   				<input type="radio" name="choice" value="Achat" id="achat" required="required">
										<label for="achat">Achat</label>
										<input type="checkbox" name="choiceBis" value="eouverte" id="eouverte">
										<label for="eouverte">Enchères ouvertes</label>
										<input type="checkbox" name="choiceBis" value="eactuelle" id="eactuelle">
										<label for="eactuelle">Mes enchères en cours</label>
										<input type="checkbox" name="choiceBis" value="eremportee" id="eremportee">
										<label for="eremportee">Mes enchères remportées</label>
						   			</div>
						   			<div class="col-6">
						   				<input type="radio" name="choice" value="Vente" id="vente">
										<label for="vente">Mes Vente</label>
										<input type="checkbox" name="choiceBis" value="vactuelle" id="vactuelle">
										<label for="vactuelle">Mes ventes en cours</label>
										<input type="checkbox" name="choiceBis" value="vfuture" id="vfuture">
										<label for="vfuture">Ventes non débutées</label>
										<input type="checkbox" name="choiceBis" value="vterminee" id="vterminee">
										<label for="vterminee">Ventes terminées</label>
						   			</div>
						    	</div>
							</c:if>						    
						</div>
						<div class="col-3">
							<a href="#" class="badge" title="Filtrer">
								<i class="fas fa-search fa-3x text-muted"></i>
							</a>
						</div>
					</div>
				</form>
			</div>
			
			<div class="row">
				<c:choose>
					<c:when test="${!empty sessionScope.identifiant && !empty sessionScope.password}">
						<p class="text-center">Si ce message s'affiche c'est que la session est ouverte.</p>
					</c:when>
					<c:otherwise>
						<p class="text-center">Il n'y a aucunes enchères actuellement.</p>
					</c:otherwise>
				</c:choose>
			</div>
			
			
		    
		    
		    <div class="row py-3"></div>			
		</div>
	<footer class="py-3 bg-dark">
      	<div class="container">
       		<p class="m-0 text-center text-white">Copyright &copy; ENI - Groupe C 2021</p>
    	</div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
	</body>
</html>