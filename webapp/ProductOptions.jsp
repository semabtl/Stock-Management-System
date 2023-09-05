<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Management</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp"/>
		<div class="container">
			<div class="d-grid gap-2 col-4 mx-auto mt-5">
				<a href="AddProductPage.jsp" class="btn btn-outline-dark">Add Product</a>
				<a href="ProductListPage.jsp" class="btn btn-outline-dark">List Products</a>
				<a href="PrintBarcode.jsp" class="btn btn-outline-dark">Print Barcode</a>
			</div>
		</div>
	</body>
</html>