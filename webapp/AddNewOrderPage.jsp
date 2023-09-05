<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Order</title>
	</head>
	<body>
	<jsp:include page="includes/navbar.jsp"/>
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