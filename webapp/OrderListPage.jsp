<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Connection.DatabaseConnection"%>
<%@page import="DAO.OrderDao"%>
<%
	OrderDao odao = new OrderDao(DatabaseConnection.getConnection());

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Orders</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp"/>
		
	</body>
</html>