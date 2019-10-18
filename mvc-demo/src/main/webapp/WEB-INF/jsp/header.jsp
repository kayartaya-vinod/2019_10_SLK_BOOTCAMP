<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>MVC - Demo</title>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<div class="alert alert-warning">
		<div class="container">
			<h1><em>e</em>Mailer</h1>
			<div class="row lead">
				<div class="col">Internal Email System</div>
				<div class="col text-right">
					<c:if test="${user!=null}">
					Hello ${user.name}, welcome!
					</c:if>
				</div>
			</div>
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