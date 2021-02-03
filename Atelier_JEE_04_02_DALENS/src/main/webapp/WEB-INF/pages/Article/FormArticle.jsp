<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'un article</title>
</head>
<body>
<div class="container">
<%@include file="../commons/MenuNavBar.jsp" %>
<h1>Formulaire article</h1>
<hr>
<form action="articles?action=create" method="post">
   <label for="nomArticle">Nom de l'article :</label> <input type="text"  name="nomArticle">
   <label for="cbArticle">Code barre de l'article :</label>  <input type="text"  name="cbArticle">
   <label for="prixArticle">Prix de l'article :</label>  <input type="number" max="2147483647"  name="prixArticle"> 
   <input style="cursor:pointer" type="submit" value="Valider" />
 </form>
 </div>
</body>
</html>
