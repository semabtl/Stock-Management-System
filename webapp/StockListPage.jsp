<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="DAO.StockDao"%>
<%@page import="DAO.UserDao"%>
<%@page import="DAO.ProductDao"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="Model.Stock"%>
<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
<% 
	UserDao udao = new UserDao(DatabaseConnection.getConnection());
	StockDao sdao = new StockDao(DatabaseConnection.getConnection());
	ProductDao pdao = new ProductDao(DatabaseConnection.getConnection());
	
	String email = (String) session.getAttribute("email");
	int userId = udao.findUserIdByEmail(email);
	List<Stock> stockProducts = sdao.getStockOfUser(userId);	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Stock</title>
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
		          <a class="nav-link active" href="ProductOptions.jsp">Product Management</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="PurchaseOptions.jsp">Purchase Management</a>
		        </li>
		        <li class="nav-item">
			      <a class="nav-link" href="logout">Log out</a>
			    </li>
		      </ul>
		    </div>
		</nav>
		<div class  = "container mt-5 col-6">
		<% if(!stockProducts.isEmpty()){  %>
			<table class="table table-bordered table-sm ">
			  <thead class="table-secondary text-center">
			    <tr>
			      <th scope="col">Barcode</th>
			      <th scope="col">Product Name</th>
			 	  <th scope="col">Quantity</th>
			    </tr>
			  </thead>
			  <tbody class="text-center">
			  <% 
				for(Stock s:stockProducts){
					Product p = pdao.getProductById(s.getProductId());
			  %>
			    <tr>
			      <td><%= p.getBarcode() %></td>
			      <td><%= p.getName() %></td>
			      <td><%= s.getQuantity() %></td> 
			    </tr>
			   <% } %>
			  </tbody>
			</table>
		<% } else{ %>
			<h3 class="text-center">There are no products in stock!</h3>
		<% } %>
		</div>
	</body>
</html>