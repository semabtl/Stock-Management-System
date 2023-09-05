<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DAO.ProductDao"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="Model.Product"%>
    
<%
	int selectedProductId = (int) session.getAttribute("product-id");
	ProductDao pdao = new ProductDao(DatabaseConnection.getConnection());
	
	Product product = pdao.getProductById(selectedProductId);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Details</title>
	</head>
	<body>
		<jsp:include page = "includes/navbar.jsp"/>
		<div class = "card" style = "width: 300px; margin: auto; margin-top: 50px; padding:20px;">
		  <div class = "card-body">
		    <h5 class = "card-title text-center text-uppercase mb-3"><%= product.getName() %></h5>
		    <p class = "card-text fw-bold">Category: <%= product.getCategory() %></p>
			<p class = "card-text fw-bold">Cost Price: <%= product.getCostPrice()%></p>
			<p class = "card-text fw-bold">Selling Price: <%= product.getSellingPrice() %></p>
			<p class = "card-text fw-bold">Quantity: <%= product.getQuantity() %></p>
			
		  </div>
		</div>
	</body>
</html>