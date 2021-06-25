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
		
		<script>
		    function func(){
		    	/* on met dans une variable le groupe de btn radio */
		        var type = document.getElementsByName("flexRadioDefault");
		    	/* Cas où Achat est actif */
		        if (type[0].checked) {
		        	/* désactive les check de vente */
		            document.getElementById("defaultCheckvactuelle").disabled = true;
		            document.getElementById("defaultCheckvfuture").disabled = true;
		            document.getElementById("defaultCheckvterminee").disabled = true;
		            /* active les check d'achat */
		            document.getElementById("defaultCheckeouverte").disabled = false;
		            document.getElementById("defaultCheckeactuelle").disabled = false;
		            document.getElementById("defaultCheckeremportee").disabled = false;
		            /* décoche les check de vente */
		            document.getElementById("defaultCheckvactuelle").checked = false;
		            document.getElementById("defaultCheckvfuture").checked = false;
		            document.getElementById("defaultCheckvterminee").checked = false;
		        }
		        /* Cas où Vente est actif */
		        else if (type[1].checked) {
		        	/* désactive les check d'achat */
		            document.getElementById("defaultCheckeouverte").disabled = true;
		            document.getElementById("defaultCheckeactuelle").disabled = true;
		            document.getElementById("defaultCheckeremportee").disabled = true;
		            /* active les check de vente */
		            document.getElementById("defaultCheckvactuelle").disabled = false;
		            document.getElementById("defaultCheckvfuture").disabled = false;
		            document.getElementById("defaultCheckvterminee").disabled = false;
		            /* décoche les check d'achat */
		            document.getElementById("defaultCheckeouverte").checked = false;
		            document.getElementById("defaultCheckeactuelle").checked = false;
		            document.getElementById("defaultCheckeremportee").checked = false;
		        }
    		}
		</script>
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

							    	<a class="nav-link text-light px-3" href="MonProfil">Mon profil</a>

							    </li>
							    <li class="nav-item">
							    	<a class="nav-link text-light px-3" href="Deconnexion">Déconnection</a>
							    </li>
							</c:when>
							<c:otherwise>
								<li class="nav-item">
								 	<a class="nav-link text-light px-3" href="connexion">S'inscrire - Connection</a>
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
			<p class="text-center"> Bonjour ${sessionScope.pseudo}, que les ventes soient bonnes !! </p>
		</c:if>
		
		<div class="row py-3"></div>
		
		<!-- message erreur -->
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
				<form action="encheres" method="POST">
					<div class="row ">
						<div class="col-9">
							<div class="row">
						   		<h4>Filtres :</h4>
						    </div>
						    
						    <div class="row">
						    	<div class="col-6">
						   			<input type="text" class="form-control" name="inputFiltre" placeholder="Le nom de l'article contient">
						   		</div>
						    </div>
						    
						    <div class="row">
						    	<div class="col-4">
							    	<select name="categorieFiltre" id="categorie" class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">
										<option value="0">--Toutes catégories--</option>
	                                    <c:forEach items="${listeCategorie}" var="item">
	                                    	<option value="${item.idCategorie}">${item.nomCategorie}</option>
	                                    </c:forEach>
                                	</select>
								</div> 
						    </div>
						    
						    <c:if test="${!empty sessionScope.pseudo}">
								<div class="row">
									<div class="btn-group">
							   			<div class="col-4">
							   				<div class="form-check">
												<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioAchat" onchange="func();">
												<label class="form-check-label" for="flexRadioAchat">
													Achat
												</label>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="1" id="defaultCheckeouverte">
													<label class="form-check-label" for="defaultCheckeouverte">
														Enchères ouvertes
													</label>
												</div>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="2" id="defaultCheckeactuelle">
													<label class="form-check-label" for="defaultCheckeactuelle">
														Mes enchères en cours
													</label>
												</div>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="3" id="defaultCheckeremportee">
													<label class="form-check-label" for="defaultCheckeremportee">
														Mes enchères remportées
													</label>
												</div>
											</div>
							   			</div>
							   			<div class="col-4">
							   				<div class="form-check">
												<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioVente" onchange="func();">
												<label class="form-check-label" for="flexRadioVente">
													Mes Ventes
												</label>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="1" id="defaultCheckvactuelle" name="checkvactuelle">
													<label class="form-check-label" for="defaultCheckvactuelle">
														Mes ventes en cours
													</label>
												</div>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="2" id="defaultCheckvfuture" name="checkvfuture">
													<label class="form-check-label" for="defaultCheckvfuture">
														Ventes non débutées
													</label>
												</div>
												<div class="row">
													<input class="form-check-input" type="checkbox" value="3" id="defaultCheckvterminee" name="checkvterminee">
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
						
						<div class="col-3 col-lg-3 position-relative">
							<input type="submit" value="Filtrer" class="btn bg-dark text-light position-absolute top-50 start-50 translate-middle">
						</div>
						
					</div>
				</form>
			</div>
			
			<div class="row py-3"></div>
			
			
				<c:choose>
					<c:when test="${!empty sessionScope.pseudo}">
						<p class="text-center">Les enchères arrivent, soyez prêt.e.s !</p>
						<div class="row">
							<c:forEach var="current" items="${ListeEnchere}">
								<div class="col-12 col-lg-6 mb-2 mt-2">
									<div class="card flex-row  bg-light">
										<img src="#"  alt="image article">
									  	<div class="card-body">
									  		<a href="#" class="card-link"><h5 class="card-title">${current.nomArticle }</h5></a><br>
									    	Prix : ${current.prixInitial } crédits<br>
									    	Fin de l'enchère : ${current.dateFin }<br>
									    	Vendeur : <a href="MonProfil?pseudo=${current.pseudo }" class="card-link">${current.pseudo }</a><br>
									 	</div>
									 </div>
								 </div>
							</c:forEach>
						</div>
					</c:when>
					<c:otherwise>
						<p class="text-center">Les enchères arrivent, soyez prêt.e.s !</p>
						<div class="row">
							<c:forEach var="current" items="${ListeEnchere}">
								<div class="col-12 col-lg-6 mb-2 mt-2">
									<div class="card flex-row  bg-light">
										<img src="#"  alt="image article">
									  	<div class="card-body">
									  		<h5 class="card-title">${current.nomArticle }</h5><br>
									    	Prix : ${current.prixInitial } crédits<br>
									    	Fin de l'enchère : ${current.dateFin }<br>
									    	Vendeur : ${current.pseudo }<br>
									 	</div>
									 </div>
								 </div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			
		    
		    <div class="row py-3"></div>			
		
		<footer class="py-3 bg-dark">
	      	<div class="container">
	       		<p class="m-0 text-center text-white">Copyright &copy; ENI - Groupe C 2021</p>
	    	</div>
	    </footer>
	    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" 
	    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" 
	    crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
	</body>
</html>