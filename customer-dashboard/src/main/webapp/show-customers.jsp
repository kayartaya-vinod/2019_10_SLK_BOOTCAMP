<%@ include file="./header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>List of all customers</h2>

<table class="table table-bordered table-striped table-hover">
	<caption></caption>
	<thead>
		<tr>
			<th id="">Name</th>
			<th id="">Email address</th>
			<th id="">Phone number</th>
			<th id="">City</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${customers}" var="c1">
			<tr>
				<td>
				
				<a href="./view-customer-details?id=${c1.id}">
				${c1.gender=="Male"?"Mr.":"Ms."}
				${c1.name}
				</a>
				
				</td>
				<td>${c1.email}</td>
				<td>${c1.phone}</td>
				<td>${c1.city}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="./footer.jsp" %>