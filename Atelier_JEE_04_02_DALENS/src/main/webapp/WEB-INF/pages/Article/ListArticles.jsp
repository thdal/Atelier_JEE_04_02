<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des articles</title>
</head>
<body>
<div class="container">
<%@include file="../commons/MenuNavBar.jsp" %>
<h1>Liste des articles</h1>
<hr>
<table>
   <thead>
       <tr>
           <th>Numero</th>       
           <th>Nom</th>
           <th>Code Barre</th>
           <th>Prix</th>
           
       </tr>
   </thead>
   <tbody> 
    <c:forEach items="${ArticlesList}" var="a" varStatus="loop">   
	    <tr>
	    	<td><c:out value="${loop.index}"/></td>
	        <td><c:out value="${a.nom}"/></td>
	        <td><c:out value="${a.codeBarre}"/></td>        
	        <td><c:out value="${a.prix}"/></td>        	        
	    </tr>
	</c:forEach>	    
    </tbody>
 </table>
 
<a style="margin-top:25px"" class="waves-effect waves-light btn" href="articles?action=create">Ajouter un article</a>
</div>
</body>
</html>