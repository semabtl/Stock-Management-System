<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="DAO.ProductDao"%>
<%@page import="DAO.StockDao"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="Model.Product"%>
    
<%
	int selectedProductId = (int) session.getAttribute("product-id");
	ProductDao pdao = new ProductDao(DatabaseConnection.getConnection());
	StockDao sdao = new StockDao(DatabaseConnection.getConnection());
	
	Product product = pdao.getProductById(selectedProductId);
	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Details</title>
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
		
		<div class="container mt-5" style = "width: 300px; margin: auto; margin-top: 50px; padding:20px;">
			<h5 class = "card-title text-center text-uppercase mb-3"><%= product.getName() %></h5>
			<table class="table table-bordered table-striped table-sm">
			  <tbody>
			    <tr>
			      <th scope="row">Category:</th>
			      <td><%= product.getCategory() %></td>
			    </tr>
			    <tr>
			      <th scope="row">Cost Price:</th>
			      <td><%= product.getCostPrice() %></td>
			    </tr>
			    <tr>
			      <th scope="row">Selling Price:</th>
			      <td><%= product.getSellingPrice() %></td>
			    </tr>
			  </tbody>
			</table>
		</div>
		
	</body>
</html>