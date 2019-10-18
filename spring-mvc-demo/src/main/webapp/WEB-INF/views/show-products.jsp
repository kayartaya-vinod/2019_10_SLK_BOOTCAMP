<%@ include file="./header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>${title}</h2>

<table class="table table-bordered table-hover">
	<caption></caption>
	<thead>
		<tr>
			<th id=""></th>
			<th id="">Name</th>
			<th id="">Quantity per unit</th>
			<th id="">Unit price</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${products}" var="p">
			<tr>
				<td><img src="${p.picture}" style="height: 50px;"
					alt="${p.name}"></td>
				<td>
					<a href="./edit-product?id=${p.id}">
						<em class="fa fa-pencil"></em>
					</a>
				
					<span style="width: 20px; display: inline-block"></span>
				
					<a href="./delete-product?id=${p.id}">
						<em class="fa fa-trash-o"></em>
					</a>
				
					<span style="width: 20px; display: inline-block"></span>
				
					<a href="./view-product-details?id=${p.id}">
					${p.description}
					</a>
					
					
				</td>
				<td>${p.quantityPerUnit}</td>
				<td>${p.unitPrice}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="./footer.jsp"%>