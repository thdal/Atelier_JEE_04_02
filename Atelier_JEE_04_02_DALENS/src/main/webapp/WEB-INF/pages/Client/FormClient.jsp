<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'un client</title>
</head>
<body>
<div class="container">
<%@include file="../commons/MenuNavBar.jsp" %>
<h1>Formulaire client</h1>
<hr>
<form action="clients?action=create" method="post">
   <label for="nomClient">Nom du client :</label> <input type="text"  name="nomClient">
   <label for="adresseClient">Adresse du client :</label>  <input type="text"  name="adresseClient">   
   <a  class="waves-effect waves-light btn">   
   	<input style="color:white;cursor:pointer" type="submit" value="Valider" />
   </a>   
 </form>
 </div>
</body>
</html>
