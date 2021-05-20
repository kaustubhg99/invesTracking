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

<title>Wallet</title>
</head>
<body>
 <jsp:include page="header.jsp" />
 	<br>
  <div class="container">
 	<div class="row gutters-sm">
      <div class="col-md-4 mb-3">
     	 <div class="card">
           <div class="card-body">
			<h3> <i class="fa fa-credit-card" aria-hidden="true"></i> Balance :  ${walletsTransactionList.get(0).getWallet_Balance()}</h3>
			<button class="btn btn-primary launch" data-toggle="modal" data-target="#exampleModal1">Add Amount</button>
			<button class="btn btn-warning launch" data-toggle="modal" data-target="#exampleModal2">Withdraw Amount</button>
		   </div>
		 </div>
	  </div>
	  
	   <div class="col-md-8">
         <div class="card mb-3">
           <div class="card-body">
             <c:forEach var="walletsTransaction" items="${walletsTransactionList}">  
             <div class="row">
               <div class="col-sm-4">
                <div class="col-sm-9 text-secondary">
             	 ${walletsTransaction.getWallet_txn()}
               </div>
                 <h6 class="mb-0"> ${walletsTransaction.getWallet_date()}</h6>
               </div>
               <div class="col-sm-4 text-secondary">
             	  ${walletsTransaction.getWallet_action()}
               </div>
                <div class="col-sm-4 text-secondary">
             	 ${walletsTransaction.getWallet_Amount()}
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

<!-- Modal For Add Balance -->

   
 <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     <form:form class="form-container" action="addBalance" modelAttribute="walletTxnObj"> 
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Balance To Wallet</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
     
      <div class="modal-body">
       		<div class="text-right"> <i class="fa fa-close close" data-dismiss="modal"></i> </div>
                <div class="px-4 py-5">
                    <div class="form-group">
			            <label for="recipient-name" class="col-form-label">Enter Amount :</label>
			            <form:input  class="form-control" path="wallet_Amount" value="0.0"/>
			         </div>
                   
                </div>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <input type = "submit" class="btn btn-primary" value = "Submit"></input>
      </div>
   </form:form>
    </div>
    
  </div>
	
</div>
   
     
 <!-- ------------------------------------------ --> 
 <!-- Modal For Withdraw Balance -->

   
 <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     <form:form class="form-container" action="withdrawBalance" modelAttribute="walletTxnObj"> 
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Withdraw Balance From Wallet</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
     
      <div class="modal-body">
       		<div class="text-right"> <i class="fa fa-close close" data-dismiss="modal"></i> </div>
                <div class="px-4 py-5">
                    <div class="form-group">
			            <label for="recipient-name" class="col-form-label">Enter Amount :</label>
			            <form:input  class="form-control" path="wallet_Amount" value="0.0"/>
			         </div>
                   
                </div>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <input type = "submit" class="btn btn-primary" value = "Submit"></input>
      </div>
   </form:form>
    </div>
    
  </div>
	
</div>
   
     
 <!-- ------------------------------------------ --> 
 

</html>