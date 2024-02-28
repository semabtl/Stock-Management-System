<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="DAO.OrderDao"%>
<%@page import="DAO.UserDao"%>
<%@page import="Model.Order"%>
<%@page import="Model.Basket"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "java.text.DecimalFormat" %>
<% 
	session = request.getSession(); 
	OrderDao odao = new OrderDao(DatabaseConnection.getConnection());
	UserDao udao = new UserDao(DatabaseConnection.getConnection());
	String email = (String) session.getAttribute("email");
	int userId = udao.findUserIdByEmail(email);
	
	List<Order> orders = odao.getAllOrdersOfUser(userId);
	
	final DecimalFormat df = new DecimalFormat("0.00000");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Orders</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light d-flex justify-content-end" style="background-color: #C0DBEA">
		  <div class="container-fluid">
		    <a class="navbar-brand fw-bold" href="index.jsp">Stock Management System</a>
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link" aria-current="page" href="index.jsp">Homepage</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="ProductOptions.jsp">Product Management</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" href="PurchaseOptions.jsp">Purchase Management</a>
		        </li>
		        <li class="nav-item">
			      <a class="nav-link" href="logout">Log out</a>
			    </li>
		      </ul>
		    </div>
		</nav>
		<div class="container mt-5 col-10">
		<%  if(!orders.isEmpty()){  %>
			  <table class="table table-bordered align-middle">
				<thead class="table-secondary text-center">
					<tr>
						<th scope="col">Order Number</th>
						<th scope="col">Order Date</th>
						<th scope="col">Product Barcode</th>
						<th scope="col">Supplier</th>
						<th scope="col">Total Cost</th>
					</tr>
				</thead>
		
				<tbody class="text-center">
			  	<% for(Order order:orders){
			  		ArrayList<Integer> orderedProducts = odao.getOrderedProducts(order.getOrderId());
			  	%>
					<tr>
						<td><%= order.getOrderId() %></td>
						<td><%= order.getOrderDate() %></td>
						
						<!-- Sipariş verilen ürünlerin barkodları tek tek tabloya yerleştirilir. -->
						<td>
							<table class="table table-borderless mb-0">
								<tbody>
									<%for(Integer productBarcode:orderedProducts){ %>
									<tr>
										<td><%=productBarcode %></td>
									</tr>
									<%} %>
								</tbody>
							</table>
						</td>
						
						<!-- Sipariş verilen ürünlerin satıcıları tek tek tabloya yerleştirilir. -->
						<td>
							<table class="table table-borderless mb-0">
								<tbody>
									<%for(Integer productBarcode:orderedProducts){ %>
									<tr>
										<td><%= odao.getSupplierName(order.getOrderId(), productBarcode) %></td>
									</tr>
									<%} %>
								</tbody>
							</table>
						</td>
						<td><%= df.format(order.getTotalCost()) %></td>
				    </tr>	  
			 <% } %>		  
			  	</tbody>
			</table>
			<% } else{ %>
				<h3 class="text-center">There are no orders yet!</h3>
			<% } %>
		</div>
		
	</body>
</html>