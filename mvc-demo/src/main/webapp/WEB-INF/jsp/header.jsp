<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC - Demo</title>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
	<div class="alert alert-warning">
		<div class="container">
			<h1>MVC - Demo</h1>
			<p class="lead">Developed by Vinod</p>
		</div>
	</div>
	<div class="container">
		<p>
			<a href="./">Home</a> |
			<c:if test="${user==null}">
				<a href="./login">Login</a> |
				<a href="./register">Register</a>
			</c:if>
			<c:if test="${user!=null}">
				<a href="./logout">Logout</a>
			</c:if>
		</p>
		<div style="min-height: 400px;">