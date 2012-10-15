<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- <link rel="stylesheet" href="bootstrap/css/bootstrap.css"> -->
<link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css">
<link rel="stylesheet" href="http://datatables.github.com/Plugins/integration/bootstrap/dataTables.bootstrap.css">
<!-- <script src="http://code.angularjs.org/1.0.2/angular.min.js"></script> -->
<!-- <script src="http://documentcloud.github.com/underscore/underscore-min.js"></script> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/paging.js"></script>
<script src="datatables/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8" src="http://datatables.github.com/Plugins/integration/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#employeeTable').dataTable({
		"sDom": "<'row-fluid'<'span6'T><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
		"oTableTools": {
			"aButtons": [
				"copy",
				"print",
				{
					"sExtends":    "collection",
					"sButtonText": 'Save <span class="caret" />',
					"aButtons":    [ "csv", "xls", "pdf" ]
				}
			]
		}
	} );
} );
</script>
<title>IP Manager - List</title>
</head>
<body>

	<div class="container">

		<div class="hero-unit">
			<h1>IP Listing</h1>
		</div>
		
		<c:if test="${not empty errorMessage}">
			<div style="color:red">${errorMessage}</div> 			
		</c:if>
		
		<div class="bs-docs-example">
			<c:if test="${not empty ipList}">

				<table id="employeeTable" class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>Id</th>
							<th>IP</th>
							<th>IP Admin</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="o" items="${ipList}">
							<tr>
								<td>${o.id}</td>
								<td>${o.ipaddress}</td>
								<td><a href="https://${o.ipaddress}:7777" target="_blank">${o.ipaddress}</a></td>
								<td>${o.date_rec} PST</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		
		<div>
		<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
		</div>
	</div>

</html>
