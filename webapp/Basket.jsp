<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Basket" %>
<%@ page import="DAO.ProductDao" %>
<%@ page import="Connection.DatabaseConnection" %>
<% 
	ArrayList<Basket> basket_list = (ArrayList<Basket>) session.getAttribute("basket-list");
	List<Basket> basketProduct = null;
	if(basket_list != null){
		ProductDao pdao = new ProductDao(DatabaseConnection.getConnection());
		basketProduct = pdao.getBasketProducts(basket_list);
		request.setAttribute("basket_list", basket_list);
	}
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp" />
		<div class="container mt-5">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Barcode</th>
			      <th scope="col">Quantity</th>
			      <th scope="col">Supplier</th>
			    </tr>
			  </thead>
			  
			  <tbody>
			  <%
			  if(basket_list != null){%>
				  <%out.print("a");
				 for(Basket b:basketProduct){ %>
				  <%out.print("b"); 
				  out.print(b.getBarcode());
				  System.out.println("Barcode: " + b.getBarcode());
				  %>
				  
					  <tr>
					  	<td><%= b.getBarcode() %></td>
					    <td><%= b.getQuantity() %></td>
					    <td>suppliername?</td>
					  </tr>
			   <% }
			  } %>
			  
   
			  </tbody>
			</table>
		</div>
		

	</body>
</html>