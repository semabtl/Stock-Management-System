<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Basket" %>
<%@page import= "java.text.DecimalFormat" %>

<% 
	session = request.getSession(); 
	final DecimalFormat df = new DecimalFormat("0.00000");
	ArrayList<Basket> basketList = (ArrayList<Basket>) session.getAttribute("basket-list");
%>

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
			<div class="row">
				<div class="col-md-11">
					<a href="AddNewOrderPage.jsp" class="btn btn-outline-dark mb-3">Back</a>
				</div>
				<div class="col-md-1">
					<% if(basketList != null){ %>
						<form action="add-new-order" method="POST">
							<input type="submit" name="options" value="Order" class="btn btn-outline-dark"/>
						</form>
					<% } %>
				</div>	
			</div>
			
			
			<table class="table table-bordered align-middle">
			  <thead class="table-secondary">
			    <tr>
			      <th scope="col">Barcode</th>
			      <th scope="col">Quantity</th>
			      <th scope="col">Supplier</th>
			      <th scope="col">Cost</th>
			      <th></th>
			    </tr>
			  </thead>
			  
			  <tbody>
			  <%
			  if(basketList != null){
			  	for(Basket product:basketList){ %>   
					<tr>
						<td><%= product.getBarcode() %></td>
						<td><%= product.getOrderQuantity() %></td>
						<td><%= product.getSupplierName() %></td>
						<td><%= df.format(product.getTotalCost()) %></td>
						<td>
							<div class="text-center">
								<a href="delete-from-basket?id=<%= product.getProductId() %>" class="btn btn-outline-danger">Delete</a>
							</div>
							
						</td>
				    </tr>	  
			 <% }			  
			  } %>
	 
			  </tbody>
			</table>
			
			
			
		</div>
	</body>
</html>