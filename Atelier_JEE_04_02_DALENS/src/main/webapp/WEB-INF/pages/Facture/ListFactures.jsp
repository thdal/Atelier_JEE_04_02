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
	<h1>Liste des factures</h1>
	<hr>	
	<table>
	   <thead>
	       <tr>
	           <th>N°</th>
	           <th>Date</th>
   	           <th>Client</th>
   	           <th>Prix</th>	           
	       </tr>
	   </thead>
	   <tbody> 
	    <c:forEach items="${FacturesList}" var="f">	   
		    <tr>
		        <td><c:out value="${f.num}"/></td>
		        <td><c:out value="${f.date}"/></td>
  		        <td><c:out value="${f.client}"/></td>		        
  		        <td><c:out value="${f.prix}"/></td>		        
		    </tr>
		</c:forEach>		    
	    </tbody>
	 </table> 
</div>
</body>
</html>