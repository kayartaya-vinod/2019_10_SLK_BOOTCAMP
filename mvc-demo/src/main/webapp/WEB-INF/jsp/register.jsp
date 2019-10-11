<%@ include file="./header.jsp"%>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8 col-sm-12">

		<h3>New users register here</h3>
		<hr />

		<form method="POST">

			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label">Name</label>
				<div class="col-sm-10">
					<input autofocus="autofocus" type="text" class="form-control"
						id="name" name="name">
				</div>
			</div>

			<div class="form-group row">
				<label for="gender" class="col-sm-2 col-form-label"></label>
				<div class="col-sm-10">
					<label><input type="radio"
						name="gender" value="Male"> Male</label> 
						<label><input
						type="radio" name="gender" value="Female">
						Female</label>
				</div>
			</div>

			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input autofocus="autofocus" type="text" class="form-control"
						id="email" name="email">
				</div>
			</div>


			<div class="form-group row">
				<label for="phone" class="col-sm-2 col-form-label">Phone</label>
				<div class="col-sm-10">
					<input autofocus="autofocus" type="text" class="form-control"
						id="phone" name="phone">
				</div>
			</div>

			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input autofocus="autofocus" type="text" class="form-control"
						id="password" name="password">
				</div>
			</div>

			<div class="form-group row">
				<label for="c_password" class="col-sm-2 col-form-label">Confirm
					password</label>
				<div class="col-sm-10">
					<input autofocus="autofocus" type="text" class="form-control"
						id="c_password">
				</div>
			</div>



			<div class="form-group row">
				<label class="col-sm-2 col-form-label"></label>
				<div class="col-sm-10">
					<button class="btn btn-primary">Register</button>
					<a href="./" class="btn btn-link">Cancel</a>
				</div>
			</div>


		</form>

	</div>
	<div class="col-md-2"></div>
</div>

<%@ include file="./footer.jsp"%>