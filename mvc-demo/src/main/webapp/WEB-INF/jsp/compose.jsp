<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="POST">
	<div class="form-group row">
		<label for="to" class="col-sm-2 col-form-label">To</label>
		<div class="col-sm-10">
			<input autofocus="autofocus" type="text" class="form-control"
				id="to" name="to">
		</div>
	</div>
	<div class="form-group row">
		<label for="cc" class="col-sm-2 col-form-label">CC</label>
		<div class="col-sm-10">
			<input autofocus="autofocus" type="text" class="form-control"
				id="cc" name="cc">
		</div>
	</div>
	<div class="form-group row">
		<label for="subject" class="col-sm-2 col-form-label">Subject</label>
		<div class="col-sm-10">
			<input autofocus="autofocus" type="text" class="form-control"
				id="subject" name="subject">
		</div>
	</div>
	<div class="form-group row">
		<label for="body" class="col-sm-2 col-form-label">Message</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="5"
				id="body" name="body"></textarea>
		</div>
	</div>
	

	<div class="form-group row">
		<label class="col-sm-2 col-form-label"></label>
		<div class="col-sm-10">
			<button class="btn btn-primary">Send</button>
			<a href="./" class="btn btn-link">Cancel</a>
		</div>
	</div>

</form>
<c:choose>
	<c:when test="${param.sent==1}">
		<p class="lead text-success">Message sent</p>
	</c:when>
	<c:when test="${param.sent==0}">
		<p class="lead text-danger">Message could not be sent</p>
	</c:when>
</c:choose>