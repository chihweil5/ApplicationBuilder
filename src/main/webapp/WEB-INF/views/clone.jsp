<%@ include file="common/header.jspf"%>

<div class="container">
	<h1>Android Application Builder</h1>
	<form:form action="/clone" method="post" class="form-horizontal">
		<fieldset class="form-group">
			<div class="col-xs-3">
				<label>User Name:</label> 
				<input class="form-control" type="text" name="username" placeholder="Enter the GitHub User Name" required="required">
			</div>
		</fieldset>
		<fieldset class="form-group">
			<div class="col-xs-3">
				<label>Repository Name:</label> 
				<input class="form-control" type="text" name="reponame" placeholder="Enter the Repository Name" required="required">
			</div>
		</fieldset>
		<fieldset class="form-group">
			<div class="col-xs-3">
				<label>commit hash:</label> 
				<input class="form-control" type="text" name="tags" placeholder="Enter the SHA hash" required="required">
			</div>
		</fieldset>
		<fieldset class="form-group">
			<div class="col-xs-3">
				<label>Save to:</label> 
				<input class="form-control" type="text" name="path" placeholder="Enter the local path" required="required">
			</div>
		</fieldset>
		
		<div>
			<button type="button" class="btn btn-primary btn-md">New Project</button>
		</div>
		
		<div>
			<button type="submit" class="btn btn-primary btn-md">Clone and Build</button>
		</div>
		
	</form:form>
	<p style="color: red">${errorMsg }</p>
</div>
<%@ include file="common/footer.jspf"%>