<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Project | BugCaught</title>

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


</head>
<!-- navbar Start -->
	<%@ include file="../Admin/navbar.jsp"%>
<!-- navbar End -->
<body>
	<!-- Main Container Start -->

	<div class="mainForm">
		<p>Edit Project</p>
		<form action="/EditProjectData" method="get">
			<small>${errorMsg}</small>
			<input type="hidden" name="pid" value="${projectList.pid}">
			<div class="form-group">
				<label>Project Name</label> <input type="text" class="form-control"
					id="InputProject" name="project_name"
					value="${projectList.project_name}" required="required"> <small
					id="projectNameValidation"></small>
			</div>

			<div class="form-group">
				<label>Project Technology</label> <input type="text"
					class="form-control" id="InputTechnology" name="technology"
					value="${projectList.technology}" required="required"> <small
					id="projectTechValidation"></small>
			</div>


			<div class="form-group">
				<label>Status</label> <select class="form-select"
					required="required" name="status" id="selectStatus">
					<option selected>${projectList.status}</option>
					<option value="developing">Under Development</option>
					<option value="cancel">Cancel</option>
					<option value="complete">Finish</option>
				</select> <small id="statusValidation"></small>
			</div>

		

			<input type="submit" value="Submit" class="btn btn-primary"
				id="btnSub">

		</form>
	</div>


	<!-- Main Container End -->
</body>
</html>