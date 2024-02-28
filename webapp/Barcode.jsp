<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="DAO.ProductDao"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="Model.Product"%>
<%
	int selectedProductId = (int) session.getAttribute("product-id-for-barcode");
	ProductDao pdao = new ProductDao(DatabaseConnection.getConnection());
	Product product = pdao.getProductById(selectedProductId);	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Barcode</title>
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
		<div class="container text-center " style="margin-top: 200px; border:2px solid; width: 200px; height: 50px;">
			<h3 class="pt-2"><%=product.getBarcode() %></h3>
		</div>
	</body>
</html>