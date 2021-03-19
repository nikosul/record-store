<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"/>
<title>Record Store</title>
</head>
<body>
<div class="container">
	<div class="d-grid gap-2 d-md-block">
		<a href="artist/new" class="btn btn-success" type="button">Create new artist</a>
		<a href="deleteartist" class="btn btn-danger" type="button">Delete artist</a>
		<a href="searchartist" class="btn btn-primary" type="button">Search artist</a>
	</div>
	<table class="table">
	<thead>
	<tr>
		<th scope="col">Artist Name</th>
	</tr>	
	<c:forEach items ="${ artistList }" var = "artist">
	<tr>
		<td>
		<a href="artist?id=${artist.id}">
		<c:out value="${artist.getName() }" /></a>
		</td>
	</c:forEach>
</table>
</div>
</body>
</html>