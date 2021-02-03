<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des clients</title>
</head>
<body>
<div class="container">
<%@include file="../commons/MenuNavBar.jsp" %>
<h1>Liste des clients</h1>
<hr>
<table>
   <thead>
       <tr>
           <th>Nom</th>
           <th>Adresse</th>
       </tr>
   </thead>
   <tbody> 
    <c:forEach items="${ClientsList}" var="c">   
   
	    <tr>
	        <td><c:out value="${c.nom}"/></td>
	        <td><c:out value="${c.adresse}"/></td>        
	    </tr>
	        </c:forEach>
	    
    </tbody>
 </table>
 
<a style="margin-top:25px" class="waves-effect waves-light btn" href="clients?action=create">Ajouter un client</a>
</div>
</body>
</html>