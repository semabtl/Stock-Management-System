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
		<div class  = "container mt-5 col-6">
			<table class="table table-bordered table-sm ">
			  <thead class="table-secondary text-center">
			    <tr>
			      <th scope="col">Product Name</th>
			 	  <th></th>
			    </tr>
			  </thead>
			  <tbody class="text-center">
			  <% 
				if(!products.isEmpty()){ 
					for(Product p:products){
			  %>
			    <tr>
			      <td><%= p.getName() %></td>
			      <td>
			      	<a href="show-information?productId=<%=p.getProductId() %>" class="btn btn-outline-dark mt-2">Show Details</a>
			      </td>  
			    </tr>
			   <% } 
			}	%>
			  </tbody>
			</table>
			
		</div>
	</body>
</html>