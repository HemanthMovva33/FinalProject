<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Offer</title>
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
	<div class="container-fluid"> 
	<form method="post" action="/addOffer/">
		<h3 style="color:blue;">Add Offer</h3>
		<table class="table table-bordered thumbnail" style="margin:auto;">
		
			<tr class="edit">
				<td class="edit-col">Offer Title</td>
			</tr>
			<tr class="edit">
				<td class="edit-col"><input class="form-control" type="text" id="title" name="offerTitle" required>
				</td>
			</tr>
			<tr class="edit">
		   		<td class="edit-col">Offer OpenDate</td>
		   		<td class="edit-col">Offer ClosedDate</td>
		   		<td class="edit-col">Offer Category</td>
			</tr>
			<tr class="edit">
				 <td class="edit-col-inp"><input type="datetime-local" id="Openday" name="Openday">
				</td>
				<td class="edit-col-inp"><input type="datetime-local" id="Closeday" name="Closeday">
				</td>
				                <td class="edit-col-inp"><select id="category" name="Category">
                        <option id="category" name="category" value="none" selected disabled hidden>Select</option>
                        <option id="category" name="category" value=1>Electronics</option>
                        <option id="category" name="category" value=2>Vehicles</option>
                        <option id="category" name="category" value=3>Properties</option>
                        <option id="category" name="category" value=4>Others</option>        
                </select></td>
		
			</tr>
			<tr class="edit">
				<td class="edit-col">Description</td></tr>
			<tr class="edit">
				<td><textarea id="Description" name="Description" rows="4" cols="50">
				</textarea></td>
			</tr> 
			<tr class="edit">
				<td class="edit-col">
					
					<input type="submit" class="btn btn-primary" value="Add Offer"/>
				</td>
			</tr>
		</table>
	</form>
	</div>
	<!-- Footer Section-->
      </div>
		<div style="padding-top:170px;">
		 <div class="text-center" style="background-color: rgba(0, 0, 0, 0.2);height: 50px;">
    		© 2020 Copyright:
  		</div>
  		</div> 
</body>
</html>
