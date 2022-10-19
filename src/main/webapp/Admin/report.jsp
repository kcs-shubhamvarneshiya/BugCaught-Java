<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Report | BugCaught</title>
<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheet -->
<link rel="stylesheet" href="../Admin/css/MainStyle.css" />
<link rel="stylesheet" href="../Admin/css/register.css" />

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!--  -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="Stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		$("#txtStart").datepicker({
			numberOfMonths : 2,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() + 1);
				$("#txtEnd").datepicker("option", "minDate", dt);
			}
		});
		$("#txtEnd").datepicker({
			numberOfMonths : 2,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() - 1);
				$("#txtStart").datepicker("option", "maxDate", dt);
			}
		});
	});
</script>
<!--  -->
</head>
<!-- navbar Start -->
<%@ include file="../Admin/navbar.jsp"%>
<!-- navbar End -->
<body>
	<!-- Main Container Start -->

	<div class="mainForm">
		<p>Generate Report</p>
		<small>${errMsg}</small>
		<form action="/generateReport" method="post">
			<!-- Hidden Fields -->
			<input type="hidden" name=pid value="${projectData.pid}">

			<!-- --- -->

			<div class="form-group">
				<label>Project Name</label> <input type="text" class="form-control"
					value="${projectData.project_name}" required="required">
			</div>


			<div class="form-group">
				<label>Status</label> <select class="form-select"
					required="required" name="status">
					<option value="${projectData.status}" selected>${projectData.status}</option>
				</select>
			</div>

			<div class="form-group">
				<label>Starting Date</label> 
				 <input type="text" id="txtStart" name="startdate" />
				<!-- <input type="date" name="startdate"> -->
			</div>

			<div class="form-group">
				<label>Ending Date</label> 
				 <input type="text" id="txtEnd" name="enddate" />
				<!-- <input type="date" name="enddate"> -->
			</div>


			<input type="submit" value="Submit" class="btn btn-primary"
				id="btnSub">

		</form>
	</div>


	<!-- Main Container End -->

</body>
</html>