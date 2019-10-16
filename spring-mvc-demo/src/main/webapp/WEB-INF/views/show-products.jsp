<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of products</title>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
	<div class="alert alert-primary">
		<h1 class="container">List of products</h1>
	</div>
	<div class="container">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Quantity per unit</th>
					<th>Unit price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="p">
				<tr>
					<td>
						<img src="${p.picture}" style="height: 50px;" alt="${p.name}">
					</td>
					<td>${p.description}</td>
					<td>${p.quantityPerUnit}</td>
					<td>${p.unitPrice}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>


