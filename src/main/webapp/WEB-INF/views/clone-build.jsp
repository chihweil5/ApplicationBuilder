<%@ include file="common/header.jspf"%>

<div class="container">

<h1>Result</h1>
	<br> <br>
	<div class="form-group">
		<label class="col-xs-2 control-label">Search by: </label>
		<div class="col-xs-2 selectContainer">
			<select class="selectpicker form-control" id="select1" name="select1"
				onChange="showOption()">
				<option value="">Please Select</option>
				<option value="Name">Repository Name</option>
				<option value="Status">Status</option>
			</select>
		</div>
		<div class="col-xs-2">
			<select class="form-control" id="select2" name="select2"
				onChange="search()">
			</select>
		</div>
		
		<div class="col-xs-1">
			<button class="btn btn-default" onclick="showAll()">Show All</button>
		</div>
	</div>
	<br> <br>
	<table id="myTable" class="table table-striped">
		<thead>
			<tr>
				<th>Github URL</th>
				<th>Status</th>
				<th>Progress</th>
				<th>Message</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" begin="1" end="5">
				<tr>
					<td>${i}</td>
					<td>Built</td>
					<td>
						<div class="progress">
							<div class="progress-bar progress-bar-striped active"
								role="progressbar" aria-valuenow="40" aria-valuemin="0"
								aria-valuemax="100" style="width: 40%">40%</div>
						</div>
					</td>
					<td><c:out value="${i}" />
						<p></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="btn btn-primary" href="/appbuilder">Back</a>
	</div>

</div>
<script>
$(document).ready(function() {
	console.log("selectpicker");
	$('.selectpicker').selectpicker({
    });
	$(".bootstrap-select").click(function () {
        $(this).addClass("open");
   });
	$('#selectpicker-container').on('hide.bs.dropdown', function () {
	    alert('hide.bs.dropdown');
	})
});
</script>
<script>

	function showOption() {
		console.log("changing the option");
		var table, tr, td, i;
		var githubName = [];
		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");
		var sel1 = document.getElementById('select1');
		var sel2 = document.getElementById('select2');

		if(sel1.value == "Name") {
			console.log("Repository Name");
			for (i = 0; i < tr.length; i++) {
			    td = tr[i].getElementsByTagName("td")[0];
			    
			    if (td) {
			    	console.log(i);
			    	sel2.options[i-1] = new Option(td.innerHTML, td.innerHTML);
			    } 
			 }
			sel2.length = tr.length-1;
			
		} else if(sel1.value == "Status") {
			sel2.options[0] = new Option("Built", "Built");
			sel2.options[1] = new Option("Failed", "Failed");
			sel2.length = 2;
		}
		else {
			sel2.options[i] = new Option();
			sel2.length = 0;
		}
	}
</script>

<script>
	function search() {
		// Declare variables 
		var input1, input2, table, tr, td, i;
		input1 = document.getElementById('select1');
		input2 = document.getElementById('select2');
		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");

		if (input1.value == "Name") {
			// Loop through all table rows, and hide those who don't match the search query
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[0];
				if (td) {
					if (td.innerHTML.indexOf(input2.value) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		} else if (input1.value == "Status") {
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[1];
				if (td) {
					if (td.innerHTML.indexOf(input2.value) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
		else {
			for (i = 0; i < tr.length; i++) {
				tr[i].style.display = "";
			}
		}
	}
</script>

<script>
	function showAll() {
		// Declare variables 
		var input1, input2, table, tr, td, i;
		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");
		for (i = 0; i < tr.length; i++) {
				tr[i].style.display = "";
		}
		
	}
</script>

<%@ include file="common/footer.jspf"%>