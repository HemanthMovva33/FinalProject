<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
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
    <div  class="container">
    	 <h3 style="color:blue;text-align:center;">My Profile</h3>
         <table class="table table-bordered">
            <tr>
                <th>Employee ID</th>
                <td>${employeeid}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${firstname}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${lastname}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${email}</td>
            </tr>
            <tr>
                <th>Points</th>
                <td>${Points}</td>
            </tr>
        </table>
    </div>
    <!-- Footer Section-->
    <br><br><br><br>
    	 <div style="padding-top:255px;">
		 <div class="text-center" style="background-color: rgba(0, 0, 0, 0.2);height: 50px;">
    		© 2020 Copyright:
  		</div>
  		</div>
    </body>
    </html> 
