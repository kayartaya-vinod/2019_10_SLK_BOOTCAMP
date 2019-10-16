<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
	<thead>
		<tr>
			<th>From</th>
			<th>Subject</th>
			<th>Date</th>
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${messages}" var="m">
		<tr>
			<td>${m.from}</td>
			<td><a href="./view-message?m=${m.id}">${m.subject}</a></td>
			<td>${m.sentAt}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>