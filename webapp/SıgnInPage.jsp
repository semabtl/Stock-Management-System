<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sıgn In</title>
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
			          <a class="nav-link" href="UserManagement.jsp">Product Management</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="UserManagement.jsp">Purchase Management</a>
			        </li>
					<li class="nav-item">
			          <a class="nav-link active" href="UserManagement.jsp">User Management</a>
			        </li>			        
		      </ul>
		    </div>
		</nav>
		<div class="container col-8 p-3">
			<div class="card w-50 mx-auto my-5 p-2">
				<div class="card-body">
					<form action="signin" method="post">
						<div class="form-group mb-3">
							<label>Name</label>
							<input type="text" class="form-control" name="new-name" required>
						</div>
						<div class="form-group mb-3">
							<label>Surname</label>
							<input type="text" class="form-control" name="new-surname" required>
						</div>
						<div class="form-group mb-3">
							<label>Company Name</label>
							<input type="text" class="form-control" name="new-company-name" required>
						</div>
						<div class="form-group mb-3">
							<label>E-Mail Address</label>
							<input type="text" class="form-control" name="new-email" required>
						</div>
						<div class="form-group mb-3">
							<label>Password</label>
							<input type="password" class="form-control" placeholder="******" name="new-password" required>
						</div>
						<div class="text-center p-3">
							<button type="submit" class="btn btn-outline-dark ">Sıgn In</button>
						</div>	
					</form>
				</div>
			</div>
		</div>		
	</body>
</html>