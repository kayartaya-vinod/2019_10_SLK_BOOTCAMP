<%@ include file="./header.jsp" %>


<h2>Contact details</h2>
<hr />

<div class="row">
	<div class="col-md-5">
		<img src="${contact.picture}"
			style="height: 250px;"
			class="img img-thumbnail img-responsive" 
			alt="${contact.firstname} ${contact.lastname}">
	</div>
	<div class="col-md-7">
		<table class="table">
			<caption></caption>
			<tbody>
				<tr>
					<th id="">Name</th>
					<td>${contact.gender=="Male" ? "Mr." : "Ms."}
					${contact.firstname} ${contact.lastname}</td>
				</tr>
				<tr>
					<th id="">Email address</th>
					<td>${contact.email}</td>
				</tr>
				<tr>
					<th id="">Phone number</th>
					<td>${contact.phone}</td>
				</tr>
				<tr>
					<th id="">City</th>
					<td>${contact.city}</td>
				</tr>
				<tr>
					<th id="">State</th>
					<td>${contact.state}</td>
				</tr>
				<tr>
					<th id="">Country</th>
					<td>${contact.country}</td>
				</tr>
			</tbody>
		</table>
		<a href="./edit-contact?id=${contact.id}"
			class="btn btn-primary">Edit</a>
		<a href="./delete-contact?id=${contact.id}"
			onClick="fnConfirmDelete(event)"
			class="btn btn-danger">Delete</a>
		
	</div>
</div>
<script>
	function fnConfirmDelete(event) {
		if(!confirm('Are you sure you want to delete this contact?')) {
			event.preventDefault();
		}
	}
</script>
<%@ include file="./footer.jsp" %>