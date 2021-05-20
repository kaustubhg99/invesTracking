<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value='/assets/static/css/style.css' />" rel="stylesheet"></link>

<link href="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='https://use.fontawesome.com/releases/v5.2.0/css/all.css' />" rel="stylesheet"></link>

<script src="<c:url value="https://code.jquery.com/jquery-3.5.1.slim.min.js integrity=sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj crossorigin=anonymous" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js integrity=sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN crossorigin=anonymous" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js integrity=sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF crossorigin=anonymous" />"></script>

<title>Transaction History</title>
</head>
<body>
 <jsp:include page="header.jsp" />
 	<br>
  <div class="container">
 	<div class="row gutters-sm">
      <div class="col-md-4">
     	 <div class="card">
           <div class="card-body">
			<h3> <i class="fa fa-credit-card" aria-hidden="true"></i> Profit</h3>
			<c:forEach var="profit" items="${profitList}">  
			<div class="row">
               <div class="col-sm-6">
                	<h6 class="mb-0"> ${profit.getProfit_Name()}</h6>
               </div>
               <div class="col-sm-4 text-secondary">
             	 ${profit.getProfit_Amount()}
               </div>
            </div>
		   </c:forEach>
		   </div>
		 </div>
	  </div>
	  
	   <div class="col-md-8">
         <div class="card mb-3">
           <div class="card-body">
           <c:forEach var="investmentTxn" items="${investmentTxnList}">  
             <div class="row">
               <div class="col-sm-3">
                <div class="col-sm-9 text-secondary">
             	  ${investmentTxn.getInves_Txn_Id()}
               </div>
                 <h6 class="mb-0">${investmentTxn.getTxn_Date()}</h6>
               </div>
               <div class="col-sm-3 text-secondary">
             	 ${investmentTxn.getTxn_Action()}
               </div>
                <div class="col-sm-3 text-secondary">
             	 ${investmentTxn.getTxn_Amount()}
               </div>
                <div class="col-sm-3 text-secondary">
            	  ${investmentTxn.getInves_Name()}
               </div>
             </div>
             <hr>
             </c:forEach>
             </div>
             
        
          </div>
        </div>
	  
	 </div>
  </div>

</body>
</html>