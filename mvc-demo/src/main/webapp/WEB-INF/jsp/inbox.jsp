<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
	<caption></caption>
	<thead>
		<tr>
			<th id="">From</th>
			<th id="">Subject</th>
			<th id="">Date</th>
			<th id=""></th>
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${messages}" var="m">
		<tr>
			<td>${m.from}</td>
			<td><a href="./view-message?m=${m.id}">${m.subject}</a></td>
			<td>${m.sentAt}</td>
			<th id="">
				<a href="./delete?m=${m.id}">
					<em class="fa fa-trash-o"></em>
				</a>
			</th>
		</tr>
		</c:forEach>
	</tbody>
</table>