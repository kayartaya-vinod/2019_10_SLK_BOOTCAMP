<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
	<thead>
		<tr>
			<th>From</th>
			<th>Subject</th>
			<th>Date</th>
			<th></th>
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${messages}" var="m">
		<tr>
			<td>${m.from}</td>
			<td><a href="./view-message?m=${m.id}">${m.subject}</a></td>
			<td>${m.sentAt}</td>
			<th>
				<a href="./delete?m=${m.id}">
					<i class="fa fa-trash-o"></i>
				</a>
			</th>
		</tr>
		</c:forEach>
	</tbody>
</table>