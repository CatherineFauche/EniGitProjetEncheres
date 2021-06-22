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
							<c:when test="${!empty sessionScope.pseudo}">
								<li class="nav-item">
							    	<a class="nav-link text-light px-3" href="encheres">Enchères</a>
							    </li>
							    <li class="nav-item">
							    	<a class="nav-link text-light px-3" href="#">Vendre un article</a>
							    </li>
							    <li class="nav-item">
							    	<a class="nav-link text-light px-3" href="#">Mon profil</a>
							    </li>
							    <li class="nav-item">
							    	<a class="nav-link text-light px-3" href="Deconnexion">Déconnection</a>
							    </li>
							</c:when>
							<c:otherwise>
								<li class="nav-item">
								 	<a class="nav-link text-light px-3" href="Connexion">S'inscrire - Connection</a>
								</li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</nav>
		</header> 
		<div class="row py-2"></div>
		<h2 class="text-center">Liste des enchères</h2>
		
		<c:if test="${ !empty sessionScope.pseudo}">
			<p> Bonjour ${sessionScope.pseudo}, que les ventes soient bonnes !! </p>
		</c:if>
		
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
			
			<div class="container bg-light" id="recherche-accueil">
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
							    	<select name="categorie" id="categorie" class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">
									<option value="all">--Toutes catégories--</option>
                                    <c:forEach items="${listeCategorie}" var="item">
                                    	<option value="${item}">${item}</option>
                                    </c:forEach>
                                </select>
								</div> 
								
						    </div>
						    <c:if test="${!empty sessionScope.pseudo}">
								<div class="row">
									<div class="btn-group">
							   			<div class="col-4">
							   				<div class="form-check">
												<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioAchat" checked>
												<label class="form-check-label" for="flexRadioAchat">
													Achat
												</label>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="" id="defaultCheckeouverte" checked>
													<label class="form-check-label" for="defaultCheckeouverte">
														Enchères ouvertes
													</label>
												</div>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="" id="defaultCheckeactuelle">
													<label class="form-check-label" for="defaultCheckeactuelle">
														Mes enchères en cours
													</label>
												</div>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="" id="defaultCheckeremportee">
													<label class="form-check-label" for="defaultCheckeremportee">
														Mes enchères remportées
													</label>
												</div>
											</div>
							   			</div>
							   			<div class="col-4">
							   				<div class="form-check">
												<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioVente">
												<label class="form-check-label" for="flexRadioVente">
													Mes Ventes
												</label>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="" id="defaultCheckvactuelle">
													<label class="form-check-label" for="defaultCheckvactuelle">
														Mes ventes en cours
													</label>
												</div>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="" id="defaultCheckvfuture">
													<label class="form-check-label" for="defaultCheckvfuture">
														Ventes non débutées
													</label>
												</div>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="" id="defaultCheckvterminee">
													<label class="form-check-label" for="defaultCheckvterminee">
														Ventes terminées
													</label>
												</div>
											</div>
							   			</div>
						   			</div>
						    	</div>
							</c:if>						    
						</div>
						<div class="col-3">
							<div class="row py-4"></div>
							<input type="submit" class="btn bg-dark text-light"></input>
							<a href="#" class="badge text-success" title="Filtrer"></a>
						</div>
					</div>
				</form>
			</div>
			
			<div class="row py-3"></div>
			
			<div class="row">
				<c:choose>
					<c:when test="${!empty sessionScope.pseudo}">
						<p class="text-center">Si ce message s'affiche c'est que la session est ouverte. Les enchères arrivent, soyez prêt.e.s !</p>
						<c:forEach var="current" items="${ListeEnchere}">
							<div class="container">
								<div class="row">
									<div class="col-6">
										<div class="card flex-row  bg-light">
											<img src="..."  alt="...">
										  	<div class="card-body">
											  	<ul class="list-group">
											  		<li class="list-group-item"><a href="#" class="card-link"><h5 class="card-title">${current.nomArticle }</h5></a></li>
											    	<li class="list-group-item">Prix : ${current.prixInitial } crédits</li>
											    	<li class="list-group-item">Fin de l'enchère : ${current.dateFin }</li>
											    	<li class="list-group-item">Vendeur : <a href="#" class="card-link">${current.pseudo }</a></li>
											 	</ul>
										 	</div>
										 </div>
									 </div>
								 </div>
							</div>
							<div class="row py-3"></div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-center">Si ce message s'affiche c'est que la session est fermée. Les enchères arrivent, soyez prêt.e.s !</p>
						<c:forEach var="current" items="${ListeEnchere}" >
							<div class="container">
								<div class="row">
									<div class="col-6">
										<div class="card flex-row">
											<img src="..."  alt="...">
										  	<div class="card-body">
											  	<ul class="list-group">
											  		<li class="list-group-item"><h5 class="card-title">${current.nomArticle }</h5></li>
											    	<li class="list-group-item">Prix : ${current.prixInitial } crédits</li>
											    	<li class="list-group-item">Fin de l'enchère : ${current.dateFin }</li>
											    	<li class="list-group-item">Vendeur : ${current.pseudo }</li>
											 	</ul>
										 	</div>
										 </div>
							 		</div>
							 	</div>
							</div>
							<div class="row py-3"></div>
						</c:forEach>
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