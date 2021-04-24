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
     	<a class="navbar-brand" style="color: #FDF5E6" href="#">CORPORATE ClASSIFIEDS</a>
     	</div>
     </nav>
<!-- login form -->
	<div class="container"> 
	<h3 style="color:blue;">Login</h3>
	<form name="Myform" onsubmit="return validateForm()" method="POST">
	<div class="form-group">
      <label for="username">Username</label>
      <input type="text" class="form-control" id="username" placeholder="Enter your name" name="username">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="submit" class="btn btn-default">Login</button>
	</form>
	</div>
<!-- Footer Section-->
      <div style="padding-top:370px;">
		 <div class="text-center" style="background-color: rgba(0, 0, 0, 0.2);height: 50px;">
    		© 2020 Copyright:
  		</div>
  		</div>
</body>
</html>
