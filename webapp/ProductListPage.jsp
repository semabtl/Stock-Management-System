<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DAO.ProductDao"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
  
<% 
	ProductDao pdao = new ProductDao(DatabaseConnection.getConnection()); 
	List<Product> products = pdao.getAllProducts();
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>All Products</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page = "includes/navbar.jsp" />
		<div class  = "container">
			<div class = "row">
			<% 
			if(!products.isEmpty()){ 
				for(Product p:products){
			%>
				<div class = "col-sm-3">
					<div class="card m-3 pt-5 text-center" style="height: 15rem;">
				      <div class="card-body">
				        <h5 class="card-title"> Product Name: <%= p.getName() %></h5>
				       <!-- Quantity:  p getQuantity()   --> 
				        <a href="show-information?productId=<%=p.getProductId() %>" class="btn btn-outline-dark mt-2">Show Details</a>
				      
				      </div>
					</div>
				</div>
			<% } 
			}	%>
			</div>
		</div>
	</body>
</html>