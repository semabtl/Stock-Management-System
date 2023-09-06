<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Basket" %>

<% session = request.getSession(); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Basket</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp" />
		<div class="container mt-5">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Barcode</th>
			      <th scope="col">Quantity</th>
			      <th scope="col">Supplier</th>
			    </tr>
			  </thead>
			  
			  <tbody>
			  <%
			  ArrayList<Basket> basketList = (ArrayList<Basket>) session.getAttribute("basket-list");
			  
			  if(basketList != null){
			  	for(Basket product:basketList){ %>   
					<tr>
						<td><%= product.getBarcode() %></td>
						<td><%= product.getOrderQuantity() %></td>
						<td><%= product.getSupplierName() %></td>
				    </tr>	  
			 <% }			  
			  } %>
	 
			  </tbody>
			</table>
			
			<form action="" method=" ">
				<div class="form-group p-3 text-center">
					<input type="submit" name="options" value="Order" class="btn btn-outline-dark"/>
				</div>
			</form>
			
		</div>
	</body>
</html>