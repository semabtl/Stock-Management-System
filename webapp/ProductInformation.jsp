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
	</head>
	<body>
		<jsp:include page = "includes/navbar.jsp"/>
		
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