<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
	<caption></caption>
	<thead>
		<tr>
			<th id="">To</th>
			<th id="">Subject</th>
			<th id="">Date</th>
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${messages}" var="m">
		<tr>
			<td>${m.to}</td>
			<td><a href="./view-message?m=${m.id}">${m.subject}</a></td>
			<td>${m.sentAt}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>