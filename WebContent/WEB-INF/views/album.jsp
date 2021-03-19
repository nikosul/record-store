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
	<div class="d-grid gap-2 d-md-block">
		<a href="searchalbum" class="btn btn-success" type="button">Search album</a>
	</div>
	<table class="table">
	<thead>
	<tr>
		<th scope="col">Album Name</th>
	</tr>
	<c:forEach items ="${ albumList }" var = "album">
	<tr>
	<td>
		<a href="album?id=${album.id}">
		<c:out value ="${ album.getName() }" /></a>
	</td>	
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>