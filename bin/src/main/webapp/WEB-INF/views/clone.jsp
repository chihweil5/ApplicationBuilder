<%@ include file="common/header.jspf"%>

<div class="container">
	<h1>Github Clone</h1>
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
		<div>
			<button type="submit" class="btn btn-primary btn-md">Clone</button>
		</div>
		
	</form:form>
	<p style="color: red">${errorMsg }</p>
</div>
<%@ include file="common/footer.jspf"%>