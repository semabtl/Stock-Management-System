<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="DAO.OrderDao"%>
<%@page import="Model.Order"%>
<%@page import="Model.Basket"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "java.text.DecimalFormat" %>
<% 
	OrderDao odao = new OrderDao(DatabaseConnection.getConnection());
	List<Order> orders = odao.getAllOrders();
	
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
		<jsp:include page="includes/navbar.jsp"/>
		<div class="container mt-5">
			<table class="table table-bordered align-middle">
				<thead class="table-secondary">
					<tr>
						<th scope="col">Order Number</th>
						<th scope="col">Order Date</th>
						<th scope="col">Product Barcode</th>
						<th scope="col">Total Cost</th>
						<th scope="col">Status</th>
					</tr>
				</thead>
		
				<tbody>
					<%
					  if(orders != null){
					  	for(Order order:orders){
					  		System.out.println(odao.getOrderedProducts(order.getOrderId()));
					  	%>
							<tr>
								<td><%= order.getOrderId() %></td>
								<td><%= order.getOrderDate() %></td>
								<td>
								
								</td>
								<td><%= df.format(order.getTotalCost()) %></td>
								<td> <%= order.getStatus() %></td>
						    </tr>	  
					 <% }			  
					  } %>
		
				</tbody>
			</table>
		</div>
		
	</body>
</html>