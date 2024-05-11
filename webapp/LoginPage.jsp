<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Model.User"%>
<%
	//It is checked whether the user is logged in or not.
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Log In</title>
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
			          <a class="nav-link" href="LoginPage.jsp">Product Management</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="LoginPage.jsp">Purchase Management</a>
			        </li>
					<li class="nav-item">
			          <a class="nav-link" href="UserManagement.jsp">User Management</a>
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
			          <a class="nav-link" href="UserManagement.jsp">User Management</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="logout">Log out</a>
			        </li>
        		<%} %>
		      </ul>
		    </div>
		</nav>
		
		<div class="container col-8 p-3">
			<div class="card w-50 mx-auto my-5 p-2">
				<div class="card-body">
					<form action="login" method="post">
						<div class="form-group p-2">
							<label>E-Mail Address</label>
							<input type="email" class="form-control" name="login-email" required>
						</div>
						<div class="form-group p-2">
							<label>Password</label>
							<input type="password" class="form-control" name="login-password" required>
						</div>
						<div class="text-center p-2">
							<button type="submit" class="btn btn-outline-dark ">Log In</button>
						</div>
					</form>
				</div>
			</div>
		</div>			
	</body>
</html>