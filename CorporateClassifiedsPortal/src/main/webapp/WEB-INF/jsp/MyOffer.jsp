<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default" style="background-color: #0000CD;">
  		<div class="container-fluid">
    	<div class="navbar-header">
     	<a class="navbar-brand" style="color: #FDF5E6" href="viewAllOffers">CORPORATE ClASSIFIEDS</a>
     	</div>
     </nav>
    <div class="container">
    		<h3 style="color:blue;">My Offers</h3>
            <c:forEach items="${Offerlist}" var="offer">
            
            <div class="row">
			<div class="col-sm-6" >
			<div class="thumbnail" style="background-color:	#FAF0E6;">
			
                <p>Offer ID: ${offer.offerId}</p>
            <div class="item-name-div">
                <p>Title : ${offer.offerTitle}</p>
				<p>Open Date: ${offer.offerOpenDate}</p>
				<p>Close Date: ${offer.offerClosedDate}</p>
            </div>    
            <div class="item-type">
                <p>Description: ${offer.offerDescription}</p>
				<p>Category: ${offer.categoryId}</p>
            </div>
            <div class="del-cart">
                
                 <a href="editOffers/${offer.offerId}">
                 <button type="button" class="btn btn-danger">Edit Offer</button> </a>
           		
            </div>
			</div>
			</div>
			</div>
            </c:forEach>
            </div>
    	 <div style="padding-top:50px;">
		 <div class="text-center" style="background-color: rgba(0, 0, 0, 0.2);height: 50px;">
    		© 2020 Copyright:
  		</div>
  		</div>
</body>
</html> 
