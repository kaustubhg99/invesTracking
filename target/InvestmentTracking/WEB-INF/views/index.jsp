<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<html>
<head>
<!-- <link href='<spring:url value="/assets/static/css/style.css"></spring:url>>' rel="stylesheet" />  --> 
 <link href="<c:url value='/assets/static/css/style.css' />" rel="stylesheet"></link> 
<link href="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />" rel="stylesheet"></link>	 
<script src="<c:url value="https://code.jquery.com/jquery-3.5.1.slim.min.js" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" />"></script>
		
</head>
<body>
<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-8">

				<form:form class="form-container" action="home" modelAttribute="userLoginObj">    
				  
							<label>User Name : </label><br>
							<form:input type="text" id="login" class="form-control" path="userName" /><br>
							<label>Password : </label><br>
							<form:input type="password" id="password" class="form-control" path="userPassword" /><br>
							${msg} <br>
							<input type = "submit" class="btn btn-primary" value = "Submit"></input>
							<a href="userReg">Registration</a>
						
				</form:form>
			</section>
		</section>
	</section>	
</body>
</html>
