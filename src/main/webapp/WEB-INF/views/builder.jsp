<%@ include file="common/header.jspf"%>


<div class="container">
	<h1>Android Application Builder</h1>
<br>
	<form:form id="githubForm" method="post" class="form-horizontal" commandName="githubInfo">
		<div class="form-group">
			<label class="col-xs-1 control-label">Project</label>
			<div class="col-xs-2">
				<form:input path="userName" type="text" class="form-control" id="github[0].username" name="github[0].username"
					placeholder="GitHub User Name" />
			</div>
			<div class="col-xs-2">
				<form:input path="repoName" type="text" class="form-control" id="github[0].reponame" name="github[0].reponame"
					placeholder="Repository Name" />
			</div>
			<div class="col-xs-3">
				<form:input path="tags" type="text" class="form-control" id="github[0].tags" name="github[0].tags"
					placeholder="SHA Tag" />
			</div>
			<div class="col-xs-3">
				<form:input path="localpath" type="text" class="form-control" id="github[0].path" name="github[0].path"
					placeholder="Local Path" />
			</div>
			
			<div class="col-xs-1">
				<button type="button" class="btn btn-default addButton"><i class="fa fa-plus" aria-hidden="true"></i></button>
			</div>
		</div>

		<!-- The template for adding new field -->
		<div class="form-group hide" id="githubTemplate">
			<div class="col-xs-2 col-xs-offset-1">
				<input type="text" class="form-control" name="username"
					placeholder="GitHub User Name" />
			</div>
			<div class="col-xs-2">
				<input type="text" class="form-control" name="reponame"
					placeholder="Repository Name" />
			</div>
			<div class="col-xs-3">
				<input type="text" class="form-control" name="tags"
					placeholder="SHA Tag" />
			</div>
			<div class="col-xs-3">
				<input type="text" class="form-control" name=path
					placeholder="Local Path" />
			</div>
			<div class="col-xs-1">
				<button type="button" class="btn btn-default removeButton">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>

		<div class="form-group">
			<div class="col-xs-5 col-xs-offset-1">
				<button id="CloneBtn" type="submit" class="btn btn-primary btn-md">Clone and Build</button>
			</div>
		</div>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>


<script>
$(document).ready(function() {
	console.log( "ready!" );
    var usernameValidators = {
            row: '.col-xs-2',   // The title is placed inside a <div class="col-xs-4"> element
            validators: {
                notEmpty: {
                    message: 'The user name is required'
                }
            }
        },
        reponameValidators = {
            row: '.col-xs-2',
            validators: {
                notEmpty: {
                    message: 'The repository name is required'
                }
            }
        },
        pathValidators = {
            row: '.col-xs-3',
            validators: {
                notEmpty: {
                    message: 'The local path is required'
                }
            }
        },
        githubIndex = 0;

    $('#githubForm')
        .formValidation({
            framework: 'bootstrap',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                'github[0].username': usernameValidators,
                'github[0].reponame': reponameValidators,
                'github[0].path': pathValidators
            }
        })

        // Add button click handler
        .on('click', '.addButton', function() {
        	githubIndex++;
            var $template = $('#githubTemplate'),
                $clone    = $template
                                .clone()
                                .removeClass('hide')
                                .removeAttr('id')
                                .attr('data-github-index', githubIndex)
                                .insertBefore($template);

            // Update the name attributes
            $clone
                .find('[name="username"]').attr('name', 'github[' + githubIndex + '].username').end()
                .find('[name="reponame"]').attr('name', 'github[' + githubIndex + '].reponame').end()
                .find('[name="tags"]').attr('name', 'github[' + githubIndex + '].tags').end()
                .find('[name="path"]').attr('name', 'github[' + githubIndex + '].path').end();

            // Add new fields
            // Note that we also pass the validator rules for new field as the third parameter
            $('#githubForm')
                .formValidation('addField', 'github[' + githubIndex + '].username', usernameValidators)
                .formValidation('addField', 'github[' + githubIndex + '].reponame', reponameValidators)
                .formValidation('addField', 'github[' + githubIndex + '].path', pathValidators);
        })

        // Remove button click handler
        .on('click', '.removeButton', function() {
            var $row  = $(this).parents('.form-group'),
                index = $row.attr('data-github-index');

            // Remove fields
            $('#githubForm')
                .formValidation('removeField', $row.find('[name="github[' + index + '].username"]'))
                .formValidation('removeField', $row.find('[name="github[' + index + '].reponame"]'))
                .formValidation('removeField', $row.find('[name="github[' + index + '].path"]'));

            // Remove element containing the fields
            $row.remove();
        });

    $("#CloneBtn").click(function () {
	    for (var i=0; i<=1; i++) {
	        var test = $("input[name='github[" + i + "'].username").val();
	        console.log(test);
	    }
    });

    var data = new Array();
    $("#githubForm").each(function() {
        data.push({id: $(this).attr("id"), value: $(this).attr("value")});
    });
    
});
</script>

