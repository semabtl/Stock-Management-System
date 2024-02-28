<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="DAO.ProductDao"%>
<%@page import="DAO.UserDao"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
  
<% 
	ProductDao pdao = new ProductDao(DatabaseConnection.getConnection()); 
	UserDao udao = new UserDao(DatabaseConnection.getConnection());
	String email = (String) session.getAttribute("email");
	int userId = udao.findUserIdByEmail(email);
	List<Product> products = pdao.getAllProductsOfUser(userId);	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>All Products</title>
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
		<% if(!products.isEmpty()){  %>
			<table class="table table-bordered table-sm ">
			  <thead class="table-secondary text-center">
			    <tr>
			      <th scope="col">Product Name</th>
			 	  <th></th>
			    </tr>
			  </thead>
			  <tbody class="text-center">
			  <% 
				for(Product p:products){
			  %>
			    <tr>
			      <td><%= p.getName() %></td>
			      <td>
			      	<a href="show-information?productId=<%=p.getProductId() %>" class="btn btn-outline-dark mt-2">Show Details</a>
			      </td>  
			    </tr>
			   <% } %>
			  </tbody>
			</table>
		<% } else{ %>
			<h3 class="text-center">There are no products!</h3>
		<% } %>
		</div>
	</body>
</html>