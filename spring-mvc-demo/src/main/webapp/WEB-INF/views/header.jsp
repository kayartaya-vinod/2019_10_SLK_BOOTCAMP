<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Product Management System</title>
	


<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script>	

<script>

	// $(function(){   });

	$(function(){
		// do stuff after DOM is ready
		// find all "a" tags where href contains "delete"
		$("a[href*=delete]").on("click", function(evt){
			if(confirm('Hey, are you sure to delete?')===false){
				evt.preventDefault();
			}
		});
	});
</script>

</head>
<body>
	<div class="alert alert-info">
		<h1 class="container">Product Management System</h1>
	</div>
	
	<div class="container">
		<div class="row" style="min-height: 400px;">
			<div class="col-md-3">
				<!-- sidebar -->
				<a class="btn btn-block btn-primary" href="./">Home</a>
				<a class="btn btn-block btn-primary" href="./view-products">View products</a>
				<a class="btn btn-block btn-primary" href="./add-new-product">Add new product</a>
				<a class="btn btn-block btn-primary" href="./advanced-search">Advanced search</a>
			</div>
			<div class="col-md-9">