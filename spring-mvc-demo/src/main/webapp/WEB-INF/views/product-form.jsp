<%@ include file="./header.jsp"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<h2>${title==null? "Product details": title}</h2>

<hr />

<sf:form modelAttribute="pr" cssClass="form" action="./save-product">
	<sf:hidden path="id"/>

	<div class="form-group row">
		<label class="col-md-3">Name</label>
		<div class="col-md-6">
			<sf:input path="name" cssClass="form-control" />
			<sf:errors path="name" cssClass="text-danger"/>
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Description</label>
		<div class="col-md-9">
			<sf:input path="description" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Category</label>
		<div class="col-md-6">
			<sf:input path="category" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Brand</label>
		<div class="col-md-6">
			<sf:input path="brand" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Unit price</label>
		<div class="col-md-9">
			<sf:input path="unitPrice" cssClass="form-control" cssStyle="width: 100px;" />
			<sf:errors path="unitPrice" cssClass="text-danger" cssStyle="font-size: .8em"/>	
		</div>
		
	</div>

	<div class="form-group row">
		<label class="col-md-3">Quantity per unit</label>
		<div class="col-md-6">
			<sf:input path="quantityPerUnit" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Picture (URL)</label>
		<div class="col-md-9">
			<sf:input path="picture" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Discount percent</label>
		<div class="col-md-9">
			<sf:input path="discount" cssClass="form-control" cssStyle="width: 100px;" />
			<sf:errors path="discount" cssClass="text-danger" cssStyle="font-size: .8em"/>
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3"></label>
		<div class="col-md-8">
			<button class="btn btn-primary">Save changes</button>
		</div>
	</div>
</sf:form>


<%@ include file="./footer.jsp"%>