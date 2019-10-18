<%@ include file="./header.jsp" %>

<h2>Customer details</h2>

<table class="table table-bordered">
	<caption></caption>
	<tbody>
		<tr>
			<th id="name">Name</th>
			<td>${customer.name}</td>
		</tr>
		<tr>
			<th id="email">Email address</th>
			<td>${customer.email}</td>
		</tr>
		<tr>
			<th id="phone">Phone number</th>
			<td>${customer.phone}</td>
		</tr>
		<tr>
			<th id="address">Address</th>
			<td>${customer.address}</td>
		</tr>
		<tr>
			<th id="city">City</th>
			<td>${customer.city}</td>
		</tr>
		<tr>
			<th id="state">State</th>
			<td>${customer.state}</td>
		</tr>
		<tr>
			<th id="country">Country</th>
			<td>${customer.country}</td>
		</tr>
	</tbody>

</table>

<%@ include file="./footer.jsp" %>