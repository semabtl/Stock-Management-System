<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Order</title>
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
		          <a class="nav-link" href="ProductOptions.jsp">Product Management</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" href="PurchaseOptions.jsp">Purchase Management</a>
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
					<form action="add-to-basket">
						<div class="form-group p-3">
							<label>Barcode</label>
							<input type="text" class="form-control" name="new-barcode" required>
						</div>
						<div class="form-group p-3">
							<label>Quantity</label>
							<input type="text" class="form-control" name="new-quantity" required>
						</div>
						<div class="form-group p-3">
							<label>Supplier's Name</label>
							<input type="text" class="form-control" name="new-supplier" required>
						</div>
						<div class="form-group p-3">
							<label>Date</label>
							<input type="text" class="form-control" placeholder="e.g. 29.08.2023" name="new-date" required>
						</div>
						<div class="form-group p-3 text-center">
							<input type="submit" name="options" value="Add to Basket" class="btn btn-outline-dark"/>
						</div>
					</form>
					
					<div class="p-3 text-center">
							<a href="Basket.jsp" class="btn btn-outline-dark">Go to Basket</a>
					</div>
					
				</div>
			</div>
		</div>
	</body>
</html>