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

<script src="<c:url value="https://code.jquery.com/jquery-3.5.1.slim.min.js integrity=sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj crossorigin=anonymous" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js integrity=sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN crossorigin=anonymous" />"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js integrity=sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF crossorigin=anonymous" />"></script>

<!-- 
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
 -->
<title>InvesTracking</title>
</head>
<body>
 <jsp:include page="header.jsp" />
 <br>
 <div class="container">
 	<div class="row gutters-sm">
            <div class="col-md-4 mb-3">
              <div class="card">
                <div class="card-body">
                  <div class="d-flex flex-column align-items-center text-center">
                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                    <div class="mt-3">
                      <h4>Kaustubh</h4>
                      <p class="text-secondary mb-1">Department</p>
                      <p class="text-muted font-size-sm">Pune</p>
                     <!--  <button class="btn btn-primary">Follow</button> -->
                    <!--   <button class="btn btn-outline-primary">Message</button>  -->
                    </div>
                  </div>
                </div>
              </div>
              </div>
              
               <div class="col-md-8">
              <div class="card mb-3">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Full Name</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                    ${userDetailsList.get(0).getUser_FirstName()}  ${userDetailsList.get(0).getUser_LastName()}
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      ${userDetailsList.get(0).getUser_Name()} 
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Wallet Balance</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                    <span class="bg-light"> ${userDetailsList.get(0).getAcc_Wallet()} </span>
                    
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Total Investment</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                  <span class="bg-light">   ${userDetailsList.get(0).getAcc_Invested()} </span>
                    </div>
                  </div>
                  <hr>
                   <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Total Profit</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                  <span class="bg-light">   ${userDetailsList.get(0).getAcc_Profit()} </span>
                    </div>
                  </div>
                </div>
              </div>
             </div>  
           </div>
 
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body text-center">
                    <h5 class="card-title m-b-0">Static Table With Checkboxes</h5>
                </div>
                <div class="table-responsive">
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th> <label class="customcheckbox m-b-20"> <input type="checkbox" id="mainCheckbox"> <span class="checkmark"></span> </label> </th>
                                <th scope="col">Investment Name</th>
                                <th scope="col">Market Capital</th>
                                <th scope="col">Holding(s)</th>
                                <th scope="col">Amount</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody class="customtable">
                         <c:forEach var="userDetails" items="${userDetailsList}">  
                            <tr>
                                <th> <label class="customcheckbox"> <input type="checkbox" class="listCheckbox"> <span class="checkmark"></span> </label> </th>
                                <td>${userDetails.getInves_Name()}</td>
                                <td>${userDetails.getInves_Market_Cap()}</td>
                                <td>${userDetails.getInves_Holding()}</td>
                                <td>${userDetails.getInves_Amount()}</td>
                                <td>
	                                <a class="btn btn-primary launch" data-toggle="modal" data-target="#exampleModal1${userDetails.getInves_Name()}">BUY</a>
	                                 <a class="btn btn-danger launch" data-toggle="modal" data-target="#exampleModal2${userDetails.getInves_Name()}">SELL</a>
	                       
                                </td>
                            </tr>
                            	
 <!-- Modal Fo Buy -->

   
 <div class="modal fade" id="exampleModal1${userDetails.getInves_Name()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     <form:form class="form-container" action="getInves" modelAttribute="invesObj"> 
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add More Crypto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
     
      <div class="modal-body">
       		<div class="text-right"> <i class="fa fa-close close" data-dismiss="modal"></i> </div>
                <div class="px-4 py-5">
                    <div class="form-group">
			            <label for="recipient-name" class="col-form-label">Invested In:  <span class="bg-light">${userDetails.getInves_Name()}</span></label>
			           <form:input  class="form-control"  path="inves_Name" value="${userDetails.getInves_Name()}" readonly="true" />
			            <label for="recipient-name" class="col-form-label">Current Market Cap:</label>
			            <form:input  class="form-control"  path="inves_Market_Cap" value="0.0"/>
			            <label for="recipient-name" class="col-form-label">Holdings:</label>
			            <form:input  class="form-control" path="inves_Holding" value="0.0"/>
			            <label for="recipient-name" class="col-form-label">Amount:</label>
			            <form:input  class="form-control" path="inves_Amount" value="0.0"/>
			            Wallet Balance : ${userDetails.getAcc_Wallet()}
			         </div>
                   
                </div>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
        <input type = "submit" class="btn btn-primary" value = "Submit"></input>
      </div>
   </form:form>
    </div>
    
  </div>
	
</div>
   
     
 <!-- ------------------------------------------ --> 
 
 <!-- Modal sell Buy -->

   
 <div class="modal fade" id="exampleModal2${userDetails.getInves_Name()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     <form:form class="form-container" action="sellInves" modelAttribute="invesObj"> 
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Sell Crypto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
     
      <div class="modal-body">
       		<div class="text-right"> <i class="fa fa-close close" data-dismiss="modal"></i> </div>
                <div class="px-4 py-5">
                    <div class="form-group">
			            <label for="recipient-name"  class="col-form-label">Invested In: <span class="bg-light">${userDetails.getInves_Name()}</span></label>
			             <form:input  class="form-control"  path="inves_Name" value="${userDetails.getInves_Name()}" readonly="true"/>
			            <label for="recipient-name" class="col-form-label">Current Market Cap:</label>
			            <form:input  class="form-control"  path="inves_Market_Cap" value="${userDetails.getInves_Market_Cap()}" />
			            <label for="recipient-name" class="col-form-label" >Holdings:</label>
			            <form:input  class="form-control" path="inves_Holding" value="${userDetails.getInves_Holding()}" />
			            <label for="recipient-name" class="col-form-label">Amount:</label>
			            <form:input  class="form-control" path="inves_Amount" value="${userDetails.getInves_Amount()}" />
			            Wallet Balance : ${userDetails.getAcc_Wallet()}
			         </div>
                   
                </div>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
        <input type = "submit" class="btn btn-primary" value = "Submit"></input>
      </div>
   </form:form>
    </div>
    	
  </div>
	
</div>
   
     
 <!-- ------------------------------------------ --> 
                           
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
             <button type="button" class="btn btn-primary btn-buy  launch" data-toggle="modal" data-target="#exampleModal3">ADD NEW CRYPTO</button>
        </div>
        
    </div>
     <!-- Modal NEW Buy -->

   
 <div class="modal fade" id="exampleModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel3" aria-hidden="true">
    
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     <form:form class="form-container" action="addInves" modelAttribute="invesObj"> 
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add New Crypto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
     
      <div class="modal-body">
       		<div class="text-right"> <i class="fa fa-close close" data-dismiss="modal"></i> </div>
                <div class="px-4 py-5">
                    <div class="form-group">
			            <label for="recipient-name"  class="col-form-label">Invested In: <span class="bg-light">${userDetails.getInves_Name()}</span></label>
			             <form:input  class="form-control"  path="inves_Name" value="${userDetails.getInves_Name()}"/>
			             
			            
			            <label for="recipient-name" class="col-form-label">Current Market Cap:</label>
			            <form:input  class="form-control"  path="inves_Market_Cap" value="${userDetails.getInves_Market_Cap()}" />
			            <label for="recipient-name" class="col-form-label" >Holdings:</label>
			            <form:input  class="form-control" path="inves_Holding" value="${userDetails.getInves_Holding()}" />
			            <label for="recipient-name" class="col-form-label">Amount:</label>
			            <form:input  class="form-control" path="inves_Amount" value="${userDetails.getInves_Amount()}" />
			            Wallet Balance :  ${userDetailsList.get(0).getAcc_Wallet()}
			         </div>
                   
                </div>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
        <input type = "submit" class="btn btn-primary" value = "Submit"></input>
      </div>
   </form:form>
    </div>
    	
  </div>
	
</div>
   
     
 <!-- ------------------------------------------ --> 
                           
</div> 
</body>

<script type="text/javascript">

jQuery(document).ready(function($) {

    $("#inves-buy-form").submit(function(event) {

        // Disble the search button
      //  enableSearchButton(false);

        // Prevent the form from submitting via the browser.
        event.preventDefault();

        storeViaAjax();

    });

});

function storeViaAjax() {

    var search = {}
    search["inves_Name"] = $("#inves_Name").val();
    search["inves_Market_Cap"] = $("#inves_Market_Cap").val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/getInves",
        data : JSON.stringify(search),
        dataType : 'json',
        timeout : 100000,
    });

}

</script>

</html>