<%@ include file="./header.jsp"%>


<h2>${title==null ? "Contact details": title}</h2>
<hr />
<form method="POST">
<input type="hidden" class="form-control" id="id" name="id" value="${contact.id}">
	<div class="form-group row">
		<label for="firstname" class="col-sm-2 col-form-label">Firstname</label>
		<div class="col-sm-10">
			<input autofocus="autofocus" type="text" class="form-control" id="firstname" name="firstname" value="${contact.firstname}">
		</div>
	</div>

	<div class="form-group row">
		<label for="lastname" class="col-sm-2 col-form-label">Lastname</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="lastname" name="lastname" value="${contact.lastname}">
		</div>
	</div>

	<div class="form-group row">
		<label for="gender" class="col-sm-2 col-form-label">Gender</label>
		<div class="col-sm-10">
			<label><input type="radio" id="gender" name="gender" value="Male" ${contact.gender=="Male"?"checked":""}> Male</label>
			<label><input type="radio" id="gender" name="gender" value="Female" ${contact.gender=="Female"?"checked":""}> Female</label>
		</div>
	</div>

	<div class="form-group row">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="email" name="email" value="${contact.email}">
		</div>
	</div>

	<div class="form-group row">
		<label for="phone" class="col-sm-2 col-form-label">Phone</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="phone" name="phone" value="${contact.phone}">
		</div>
	</div>

	<div class="form-group row">
		<label for="city" class="col-sm-2 col-form-label">City</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="city" name="city" value="${contact.city}">
		</div>
	</div>

	<div class="form-group row">
		<label for="state" class="col-sm-2 col-form-label">State</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="state" name="state" value="${contact.state}">
		</div>
	</div>

	<div class="form-group row">
		<label for="country" class="col-sm-2 col-form-label">Country</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="country" name="country" value="${contact.country}">
		</div>
	</div>

	<div class="form-group row">
		<label for="picture" class="col-sm-2 col-form-label">Picture</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="picture" name="picture" value="${contact.picture}">
		</div>
	</div>
	<div class="form-group row">
		<label for="" class="col-sm-2 col-form-label"></label>
		<div class="col-sm-10">
			<button class="btn btn-primary">Save</button>
			<a href="./contact-details?id=${contact.id}" class="btn btn-link">Cancel</a>
		</div>
	</div>


</form>
<%@ include file="./footer.jsp"%>