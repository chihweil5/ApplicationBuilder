<%@ include file="common/header.jspf"%>


<div class="container">
	<h1>Android Application Builder</h1>
	<br>
	<form:form id="githubForm" method="post" class="form-horizontal" commandName="githubInfoWrapper">
		<c:forEach items="${githubInfoWrapper.githubInfoList}"
			var="githubInfoList" varStatus="i">

			<div class="form-group">
				<label class="col-xs-1 control-label">Project</label>
				<div class="col-xs-2">
					<form:input path="githubInfoList[${i.index}].userName" type="text"
						class="form-control" id="github[0].username"
						name="github[0].username" placeholder="GitHub User Name" />
				</div>
				<div class="col-xs-2">
					<form:input path="githubInfoList[${i.index}].repoName" type="text"
						class="form-control" id="github[0].reponame"
						name="github[0].reponame" placeholder="Repository Name" />
				</div>
				<div class="col-xs-3">
					<form:input path="githubInfoList[${i.index}].tags" type="text"
						class="form-control" id="github[0].tags" name="github[0].tags"
						placeholder="SHA Tag" />
				</div>
				<div class="col-xs-3">
					<form:input path="githubInfoList[${i.index}].localpath" type="text"
						class="form-control" id="github[0].path" name="github[0].path"
						placeholder="Local Path" />
				</div>
			</div>
		</c:forEach>

		<div class="col-xs-2">
			<button id="CloneBtn" type="submit" class="btn btn-success btn-md">Clone and Build</button>
		</div>
		<div class="col-xs-1">
			<a class="btn btn-primary" href="/appbuilder">Back</a>
		</div>
	</form:form>

	

</div>
<%@ include file="common/footer.jspf"%>



