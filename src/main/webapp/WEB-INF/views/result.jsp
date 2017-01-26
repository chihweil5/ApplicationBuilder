<%@ include file="common/header.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Your Android Project...</caption>
		<thead>
			<tr>
				<th>Github URL</th>
				<th>Status</th>
				<th>Message</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${githubInfoList}" var="githubInfo" varStatus="i">
				<tr>
					<td>https://github.com/${githubInfo.userName}/${githubInfo.repoName}</td>
					<td>${Status[i.index]}</td>
					<td>${Msg[i.index]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<div>
			<a class="btn btn-primary" href="/appbuilder">Back</a>
		</div>
		
</div>
<%@ include file="common/footer.jspf"%>