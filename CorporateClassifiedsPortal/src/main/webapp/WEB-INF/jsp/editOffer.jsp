<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Offer</title>
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
    <form action="/editSuccess/" method="post">
        <h3 style="color:blue;">Edit Offer</h3>
        <table class="table table-bordered thumbnail" style="margin:auto;">
            <tr class="edit">
                <th class="edit-col">Offer Id</th>
            </tr>
            <tr class="edit">
                <td class="edit-col"><input  class="form-control" type="number" id="OfferId" name="OfferId" value=${offerId} required>
                </td>
            </tr>
            <tr class="edit">
                <th class="edit-col">Offer Title</th>
            </tr>
            <tr class="edit">
                <td class="edit-col"><input class="form-control" type="text" id="offerTitle" name="offerTitle" value=${offerTitle} required>
                </td>
            </tr>
            <tr class="edit">
               
                   <!-- <td class="edit-col">Offer ClosedDate</td> -->
                   <th class="edit-col">Offer Category</th>
            </tr>
            <tr class="edit">
                 
                <!--<td class="edit-col-inp"><input type="date" id="Closeday" name="Closeday">-->
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
                <th class="edit-col">Description</th></tr>
            <tr class="edit">
                <td><textarea id="Description" name="Description" rows="4" cols="50" >${offerDescription}
                </textarea></td>
            </tr> 
            <tr class="edit">
                <td class="edit-col">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
    </div>
    <!-- Footer Section-->
    </div>
		<div style="padding-top:90px;">
		 <div class="text-center" style="background-color: rgba(0, 0, 0, 0.2);height: 50px;">
    		© 2020 Copyright:
  		</div>
  		</div> 

</body>
</html>