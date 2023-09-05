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
		<jsp:include page="includes/navbar.jsp"/>
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
							  <input type="submit" value="Ekle" class="btn btn-outline-dark"/>
						  	</div>
						</form>
					</div>
				</div>
			</div>
	</body>
</html>