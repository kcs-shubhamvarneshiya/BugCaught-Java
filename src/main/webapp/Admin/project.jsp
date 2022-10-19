<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project | BugCaught</title>

<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- Style sheet -->
<link rel="stylesheet" href="../Admin/css/register.css">

<!-- Jquery Validation -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="../Admin/jquery/validation.js"></script>


</head>

	<%@ include file="../Admin/navbar.jsp" %>
<body>

<!-- Main Container Start -->

<div class="mainForm">
	<p>Project</p>
	<form action="addProject" method="post">
		<small>${errorMsg}</small>

		<div class="form-group">
			<label>Project Name</label> <input type="text" class="form-control"
				id="InputProject" name="project_name" placeholder="Enter Project Name"
				required="required"> <small id="projectNameValidation"></small>
		</div>

		<div class="form-group">
			<label>Project Technology</label> <input type="text"
				class="form-control" id="InputTechnology" name="technology"
				placeholder="Enter Project Technology" required="required">
			<small id="projectTechValidation"></small>
		</div>


		<div class="form-group">
			<label>Status</label> <select class="form-select" required="required"
				name="status" id="selectStatus">
				<option selected>Select Project Status</option>
				<option value="developing">Under Development</option>
				<option value="cancel">Cancel</option>
				<option value="complete">Finish</option>
			</select>
			<small id="statusValidation"></small>
		</div>

		<div class="form-group">
			<label>Delete</label> <select class="form-select" required="required"
				name="isdelete" id="selectDelete">
				<option selected>Select Option</option>
				<option value="0">No</option>
				<option value="1">Yes</option>
			</select>
			<small id="deleteValidation"></small>
		</div>


		<input type="submit" value="Submit" class="btn btn-primary"
			id="btnSub">

	</form>
</div>

<!-- Main COntainer End  -->

</body>
</html>