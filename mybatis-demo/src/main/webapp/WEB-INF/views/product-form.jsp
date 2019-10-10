<%@ include file="./header.jsp"%>

<h3>Add a new product details</h3>
<hr />


<form method="POST">
	<div class="form-group row">
		<label for="name" class="col-sm-2 col-form-label">Name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name" name="name">
		</div>
	</div>
	<div class="form-group row">
		<label for="description" class="col-sm-2 col-form-label">Description</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="description" name="description">
		</div>
	</div>
	<div class="form-group row">
		<label for="category" class="col-sm-2 col-form-label">Category</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="category" name="category">
		</div>
	</div>
	<div class="form-group row">
		<label for="brand" class="col-sm-2 col-form-label">Brand</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="brand" name="brand">
		</div>
	</div>
	<div class="form-group row">
		<label for="unit_price" class="col-sm-2 col-form-label">Unit price</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="unit_price" name="unit_price">
		</div>
	</div>
	<div class="form-group row">
		<label for="quantity_per_unit" class="col-sm-2 col-form-label">Quantity per unit</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="quantity_per_unit" name="quantity_per_unit">
		</div>
	</div>
	<div class="form-group row">
		<label for="picture" class="col-sm-2 col-form-label">Picture</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="picture" name="picture">
		</div>
	</div>
	<div class="form-group row">
		<label for="discount" class="col-sm-2 col-form-label">Discount</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="discount" name="discount">
		</div>
	</div>
	<button class="btn btn-primary">Save</button>
</form>

<%@ include file="./footer.jsp"%>