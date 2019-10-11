<%@ include file="./header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>List of all contacts</h2>
<hr />

<ul class="list-group">
	<c:forEach items="${contacts}" var="c">
	<li class="list-group-item">
		<div class="row">
			<div class="col-md-4">
				<img src="${c.picture}" class="img img-thumbnail" alt="${c.firstname} ${c.lastname}">
			</div>
			<div class="col">
				<a class="lead" href="./contact-details?id=${c.id}">
					${c.gender=="Male" ? "Mr." : "Ms."}
					${c.firstname} ${c.lastname}</a>
				<p>${c.city}, ${c.state}</p>
				<p>${c.country}</p>
			</div>
		</div>
	</li>
	</c:forEach>
</ul>
<%@ include file="./footer.jsp"%>