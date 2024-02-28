<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%session = request.getSession(); %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Error</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container text-center pt-5 mt-5">
			<h3>An error occured. Please turn back to the Homepage.</h3>
			<a href="index.jsp" class="btn btn-outline-dark mt-5">Go to the Homepage</a>
		</div>
	</body>
</html>