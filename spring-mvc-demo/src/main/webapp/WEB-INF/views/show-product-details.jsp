<%@ include file="./header.jsp"%>

<div class="row">

	<div class="col">
		<img src="${pr.picture}" class="img img-thumbnail" alt="${pr.name}">
	</div>

	<div class="col">
		<table class="table">
			<caption></caption>
			<tr>
				<th id="">Name</th>
				<td>${pr.name}</td>
			</tr>
			<tr>
				<th id="">Description</th>
				<td>${pr.description}</td>
			</tr>
			<tr>
				<th id="">Quantity per unit</th>
				<td>${pr.quantityPerUnit}</td>
			</tr>
			<tr>
				<th id="">Unit price</th>
				<td>${pr.unitPrice}</td>
			</tr>
			<tr>
				<th id="">Category</th>
				<td>${pr.category}</td>
			</tr>
			<tr>
				<th id="">Brand</th>
				<td>${pr.brand}</td>
			</tr>
			<tr>
				<th id="">Discount</th>
				<td>${pr.discount}%</td>
			</tr>
		</table>
		
		<a href="./edit-product?id=${pr.id}" class="btn btn-primary">Edit</a>
		<a href="./delete-product?id=${pr.id}" class="btn btn-danger">Delete</a>
	</div>
</div>





<%@ include file="./footer.jsp"%>