<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.projet.encheres.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>ENI Enchères</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <style>
      html, body {
      min-height: 100%;
      }
      body, div, form, input, select, textarea, label { 
      padding: 0;
      margin: 0;
      outline: none;
      font-family: Roboto, Arial, sans-serif;
      font-size: 14px;
      color: #666;
      line-height: 22px;
      }
      h1 {
      position: absolute;
      margin:0;
      font-size: 60px;
      color: #fff;
      z-index: 2;
      line-height: 83px;
      top:30px;
      }
      legend {
      padding: 10px;      
      font-family: Roboto, Arial, sans-serif;
      font-size: 18px;
      color: #fff;
      background-color: #1c87c9;
      }
      textarea {
      width: calc(100% - 12px);
      padding: 5px;
      }
      .testbox {
      display: flex;
      justify-content: center;
      align-items: center;
      height: inherit;
      padding: 20px;
      }
      form {
      width: 100%;
      padding: 20px;
      border-radius: 6px;
      background: #fff;
      box-shadow: 0 0 8px #006622; 
      }
      
      .banner {
      position: relative;
      height: 250px;
      background-image: url("./Images/marteaux.jpg");  
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
      text-align: center;
      }
      .banner::after {
      content: "";
      background-color: rgba(0, 0, 0, 0.4); 
      position: absolute;
      width: 100%;
      height: 100%;
      }
      input, select, textarea {
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 3px;
      }
      input {
      width: calc(100% - 10px);
      padding: 5px;
      }
      input[type="date"] {
      padding: 4px 5px;
      }
      textarea {
      width: calc(100% - 12px);
      padding: 5px;
      }
      .item:hover p, .item:hover i, .question:hover p, .question label:hover, input:hover::placeholder {
      color:  #006622;
      }
      .checkbox input[type=checkbox] {
      display:inline-block;
      height:15px;
      width:15px;
      margin-right:5px;
      vertical-align:text-top;
      }
      .item input:hover, .item select:hover, .item textarea:hover {
      border: 1px solid transparent;
      box-shadow: 0 0 3px 0  #006622;
      color: #006622;
      }
      .item {
      position: relative;
      margin: 10px 0;
      }
      .item span {
      color: red;
      }
      .week {
      display:flex;
      justfiy-content:space-between;
      }
      .colums {
      display:flex;
      justify-content:space-between;
      flex-direction:row;
      flex-wrap:wrap;
      }
      .colums div {
      width:48%;
      }
      input[type=radio], input[type=checkbox]  {
      display: none;
      }
      label.radio {
      position: relative;
      display: inline-block;
      margin: 5px 20px 15px 0;
      cursor: pointer;
      }
      .question span {
      margin-left: 30px;
      }
      .question-answer label {
      display: block;
      }
      label.radio:before {
      content: "";
      position: absolute;
      left: 0;
      width: 17px;
      height: 17px;
      border-radius: 50%;
      border: 2px solid #ccc;
      }
      input[type=radio]:checked + label:before, label.radio:hover:before {
      border: 2px solid  #006622;
      }
      label.radio:after {
      content: "";
      position: absolute;
      top: 6px;
      left: 5px;
      width: 8px;
      height: 4px;
      border: 3px solid  #006622;
      border-top: none;
      border-right: none;
      transform: rotate(-45deg);
      opacity: 0;
      }
      input[type=radio]:checked + label:after {
      opacity: 1;
      }
      .flax {
      display:flex;
      justify-content:space-around;
      }
      .btn-block {
       margin-top: 10px;
       text-align: center;
      }
      button {
      margin-left: 40px;
      width: 150px;
      padding: 10px;
      border: none;
      border-radius: 5px; 
      background:  #1c87c9;
      font-size: 16px;
      color: #fff;
      cursor: pointer;
      }
      button:hover {
      background:  #0692e8;
      }
      @media (min-width: 568px) {
      .name-item, .city-item {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      }
      .name-item input, .name-item div {
      width: calc(50% - 20px);
      }
      .name-item div input {
      width:97%;}
      .name-item div label {
      display:block;
      padding-bottom:5px;
      }
      #conteneur { 
      text-align:center; 
      margin: auto;
      }
      }
    </style>
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
    <div class="testbox">
    <form method="post" action="inscription">
      <div class="banner">
        <h1>ENI Enchères</h1>
      </div>
      <br/>
      <fieldset>
        <legend>Mon profil</legend>
        <div class="colums">
          <div class="item">
            <label for="pseudo">Pseudo<span>*</span></label>
            <input id="pseudo" type="text" name="pseudo" required="required"/>
          </div>
          <div class="item">
            <label for="nom"> Nom<span>*</span></label>
            <input id="nom" type="text" name="nom" required="required" />
          </div>
          <div class="item">
            <label for="prenom">Prénom<span>*</span></label>
            <input id="prenom" type="text"   name="prenom"required="required" />
          </div>
          <div class="item">
            <label for="email">Email<span>*</span></label>
            <input id="email" type="tel"   name="email"/>
          </div>
          <div class="item">
            <label for="tel">Téléphone</label>
            <input id="tel" type="text"   name="tel" />
          </div>
          <div class="item">
            <label for="rue">Rue</label>
            <input id="rue" type="text"   name="rue" />
          </div>
          <div class="item">
            <label for="cp">Code postal</label>
            <input id="cp" type="text"   name="cp" />
          </div>
          <div class="item">
            <label for="ville">Ville</label>
            <input id="ville" type="text"   name="ville" />
          </div>
             <div class="item">
            <label for="motdepasse">Mot de passe<span>*</span></label>
            <input id="motdepasse" type="password"   name="motdepasse" required="required" />
          </div>
          <div class="item">
            <label for="confirmation">Confirmation<span>*</span></label>
            <input id="confirmation" type="password"   name="confirmation" required="required" />
          </div>

      </fieldset>
      <br/>
      
      <div class="container" id=container>
      
     <center> <button type="submit" href="">Créer</button>

      <button onclick="window.location.href = 'encheres';">Annuler</button> <center/>



      </div>
    </form>
    </div>
  </body>
</html>