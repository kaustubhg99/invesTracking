<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<spring:url var="signout" value="/sign-out" />
<spring:url var="home" value="/home" />
<spring:url var="wallet" value="/wallet" />
<spring:url var="history" value="/history" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link href='<spring:url value="/assets/static/css/style.css"></spring:url>>' rel="stylesheet" /> -->
<!-- <link href="<c:url value='/assets/static/css/regForm.css' />" rel="stylesheet"></link> -->
<!-- <link href="<c:url value='/assets/static/css/bootstrap.min.css' />" rel="stylesheet"></link> -->
<!-- <script src="<c:url value="/assets/static/js/bootstrap.min.js" />"></script>  -->

<link href="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />" rel="stylesheet"></link>
<script src="<c:url value="https://code.jquery.com/jquery-3.5.1.slim.min.js" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" />"></script>

<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Kaustubh</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${home}">Profile <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${wallet}">Wallet</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="${history}">history</a>
      </li>
    </ul>
    <span class="navbar-text">
       <a class="nav-link" href="${signout}">Sign Out</a>
    </span>
  </div>
</nav>
</body>
</html>