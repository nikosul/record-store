<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
<div class="row row-cols-1 row-cols-md-3 g-3">
  <div class="col">
    <div class="card h-100">
  
  <div class="card-body">
    <h5 class="card-title">Artists</h5>
    <p class="card-text">List of all artists found in the database in alphabetical order.</p>
    <div class="d-grid gap-2 col-6 mx-auto">
    <a href="artistlist" class="btn btn-primary">List of all Artists</a>
    </div>
  </div>
</div>
</div>
  <div class="col">
    <div class="card h-100">
 
  <div class="card-body">
    <h5 class="card-title">Albums</h5>
    <p class="card-text">List of all albums found in the database in alphabetical order.</p>
    <div class="d-grid gap-2 col-6 mx-auto">
    <a href="albumlist" class="btn btn-primary">List of all Albums</a>
    </div>
  </div>
</div>
</div>
  <div class="col">
    <div class="card h-100">
 
  <div class="card-body">
    <h5 class="card-title">Tracks</h5>
    <p class="card-text">List of all tracks found in the database in alphabetical order.</p>
    <div class="d-grid gap-2 col-6 mx-auto">
    <a href="tracklist" class="btn btn-primary">List of all Tracks</a>
    </div>
  </div>
  </div>
</div>
</div>

</div>	

</body>
</html>