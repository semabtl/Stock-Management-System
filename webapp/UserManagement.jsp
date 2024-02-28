<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Model.User"%>
<%
	//Kullanıcının giriş yapıp yapmadığı kontrol edilir.
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User Management</title>
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
		        <%if(auth == null){ %>
			        <li class="nav-item">
			          <a class="nav-link" href="UserManagement.jsp">Product Management</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="UserManagement.jsp">Purchase Management</a>
			        </li>
					<li class="nav-item">
			          <a class="nav-link active" href="UserManagement.jsp">User Management</a>
			        </li>			        
		        <%}
		        else{ %>
			        <li class="nav-item">
			          <a class="nav-link" href="ProductOptions.jsp">Product Management</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="PurchaseOptions.jsp">Purchase Management</a>
			        </li>
					<li class="nav-item">
			          <a class="nav-link active" href="UserManagement.jsp">User Management</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="logout">Log out</a>
			        </li>
        		<%} %>
		      </ul>
		    </div>
		</nav>
		
		<div class="container">
			<div class="d-grid gap-2 col-4 mx-auto mt-5">
				<a href="LoginPage.jsp" class="btn btn-outline-dark">Log in</a>
				<a href="SıgnInPage.jsp" class="btn btn-outline-dark">Sign in</a>
			</div>
		</div>
		
	</body>
</html>