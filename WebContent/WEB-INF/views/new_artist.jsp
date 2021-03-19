<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"/>
<title>Record Store</title>
</head>
<body>
<div class="container">
<h1>Add artist</h1>
<p>Type the name of an artist to add it to the database</p>	 
	<c:if test="${ error != null }">
		<p>Error: <c:out value ="${ error }"/></p>
	</c:if>

	<form class="row g-3" method="post">
	<div class="col-auto">
		<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="artistName" />
	</div>
	<div class="col-auto">	
		<button class="btn btn-outline-success" type="submit" >Search</button>
	</div>
	</form>		
</div>
</body>
</html>