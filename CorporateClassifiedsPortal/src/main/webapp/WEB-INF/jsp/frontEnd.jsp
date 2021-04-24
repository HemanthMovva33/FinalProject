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
<body>

	 <nav class="navbar navbar-default" style="background-color: #0000CD;">
  		<div class="container-fluid">
    	<div class="navbar-header">
     	<a class="navbar-brand" style="color: #FDF5E6" href="viewAllOffers">CORPORATE ClASSIFIEDS</a>
    	</div>
    	<ul class="nav justify-content-end navbar-nav ">
      		<li class="nav-item"><a style="color: #FDF5E6" href="viewMyProfile">View My Profile</a></li>
      		<li class="nav-item"><a style="color: #FDF5E6" href="viewMyOffers">View	My Offers</a></li>
      		<li class="nav-item"><a style="color: #FDF5E6" href="addOffers">Add New Offer</a></li>
      		<li class="nav-item"><a style="color: #FDF5E6" href="#">View Offers By Category
      			<form method="GET" action="viewOffersByCategory">
				
				<select style="color: #0000CD" name="Category" id="Category">
					<option value=="none" selected disabled hidden></option>
					<option value=1>Electronics</option>
					<option value=2>Vehicles</option>
					<option value=3>Properties</option>
					<option value=4>Others</option>
				</select>
			 	<input type="submit" value="Submit" style="color: #0000CD">
			 	</form>
      			</a></li>
      		<li class="nav-item"><a style="color: #FDF5E6" href="viewOffersByTopLikes" class="text-right">Most Popular Offers</a></li>
      		<li class="nav-item"><a style="color: #FDF5E6" href="viewOffersByTopLikes">Filter By Date</a>
      			<input type="datetime-local" id="date" name="date">
      			<a href="viewOffersByDate/${date}">
      			<input type="submit" value="Submit" style="color: #0000CD"></a>
      		</li>
    	</ul>
  		</div>
		</nav>

	<div class="container">
	
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
				<jsp:useBean id="now" class="java.util.Date" />
					<a href="incrimentLikes/${offer.offerId}/${now}" >
					<button type="button" class="btn btn-danger">Likes</button> </a>
							<span>${offer.offerLikes}</span>
				</div>
			</div>
			</div>
			</div>
		</c:forEach>
		</div>
		<br><br><br><br>
		 <div class="text-center" style="background-color: rgba(0, 0, 0, 0.2);height: 50px;">
    		© 2020 Copyright:
  		</div>
</body>
</html>
