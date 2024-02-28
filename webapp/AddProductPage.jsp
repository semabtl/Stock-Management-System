<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add Product</title>
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
		<div class="container">
				<div class="card w-50 mx-auto my-5 p-3">
					<div class="card-body">
						<form action="add-product" method="post">
							<div class="form-group p-3">
								<label>Product Name</label>
								<input type="text" class="form-control" name="new-name" required>
							</div>
							<div class="form-group p-3">
								<label>Category</label>
								<input type="text" class="form-control" name="new-category" required>
							</div>
							<div class="form-group p-3">
								<label>Cost Price</label>
								<input type="text" class="form-control" placeholder="Örn: 1234.56" name="new-costPrice" required>
							</div>
							<div class="form-group p-3">
								<label>Selling Price</label>
								<input type="text" class="form-control" name="new-sellingPrice" required>
							</div>
							<div class="form-group p-3">
								<label>Quantity</label>
								<input type="text" class="form-control" name="new-quantity" required>
							</div>
							<div class="form-group p-3 text-center">
							  <input type="submit" value="Add" class="btn btn-outline-dark"/>
						  	</div>
						</form>
					</div>
				</div>
			</div>
	</body>
</html>