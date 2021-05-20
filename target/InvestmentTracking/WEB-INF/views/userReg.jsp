<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

<!DOCTYPE html>
<html>
<head>
<!-- <link href='<spring:url value="/assets/static/css/style.css"></spring:url>>' rel="stylesheet" /> -->
 <link href="<c:url value='/assets/static/css/regForm.css' />" rel="stylesheet"></link> 

<link href="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />" rel="stylesheet"></link>
<script src="<c:url value="https://code.jquery.com/jquery-3.5.1.slim.min.js" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" />"></script>
	 	 
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>	

	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-8 col-md-4 ">
			
			 <form:form method="post" class="form-container scrollable" action="userRegForm" modelAttribute="userObj">   
			 <h2>Registration</h2>
			 <hr>
				 <div class="form-group">
				 	<div class="row">
					 	<div class="col-6">
							<label>First Name</label><br>
							<form:input class="form-control" id="exampleInputEmail1" path="user_FirstName" /><br>
						</div>
						<div class="col-6">
							<label>Last Name</label><br>
							<form:input class="form-control" id="exampleInputEmail1" path="user_LastName" /><br>
						</div>
					</div>
					</div>
					
					<label>Email</label><br>
					<form:input class="form-control" id="exampleInputEmail1" path="user_Mail" /><br>
					<label>Password</label><br>
					<form:input class="form-control" id="exampleInputEmail1" path="user_Password" /><br>
					<label>Re-enter Password</label><br>
					<form:input class="form-control" id="exampleInputEmail1" path="user_Password2" /><br>
					${objEmp.getMsg()} 
					<input type = "submit" class="btn btn-primary btn-block" value = "Submit"></input>
				
			  </form:form>    
			</section>
		</section>
	</section>	
			
	<script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
    </script>

</body>
</html>