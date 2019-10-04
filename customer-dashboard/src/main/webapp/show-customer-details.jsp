<%@ include file="./header.jsp" %>

<h2>Customer details</h2>

<table class="table table-bordered">

	<tbody>
		<tr>
			<th>Name</th>
			<td>${customer.name}</td>
		</tr>
		<tr>
			<th>Email address</th>
			<td>${customer.email}</td>
		</tr>
		<tr>
			<th>Phone number</th>
			<td>${customer.phone}</td>
		</tr>
		<tr>
			<th>Address</th>
			<td>${customer.address}</td>
		</tr>
		<tr>
			<th>City</th>
			<td>${customer.city}</td>
		</tr>
		<tr>
			<th>State</th>
			<td>${customer.state}</td>
		</tr>
		<tr>
			<th>Country</th>
			<td>${customer.country}</td>
		</tr>
	</tbody>

</table>

<%@ include file="./footer.jsp" %>