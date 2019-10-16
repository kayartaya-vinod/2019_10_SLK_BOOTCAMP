<%@ include file="./header.jsp"%>



<div class="row">
	<div class="col-md-3">
		
		<div class="list-group">
			<a class="list-group-item ${page=='inbox'?'active':''}"
				href="./inbox">Inbox</a>
			<a class="list-group-item ${page=='compose'?'active':''}"
				href="./compose">Compose</a>
			<a class="list-group-item ${page=='sent'?'active':''}"
				href="./sent">Sent messages</a>
		</div>
	</div>
	<div class="col-md-9">
		<jsp:include page="/WEB-INF/jsp/${page}.jsp" />
	</div>
</div>

<%@ include file="./footer.jsp"%>