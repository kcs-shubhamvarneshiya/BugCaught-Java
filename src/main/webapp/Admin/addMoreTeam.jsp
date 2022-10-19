<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Team | BugCaught</title>
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
	<div class="mainBox">
		<p>Add Teams</p>
		<form action="/addMoreTeams">
			<small></small>
			<div class="form-group">
				  
				<input type="hidden" name="pid" value="${projectData.pid}">
				
				<label> Project Name</label> 	
						<p>${projectData.project_name}</p>
				</div>

				<div class="form-group">
					<label>Select Team</label>
					<hr />
					<c:forEach var="teams" items="${teamsData}">

						<!-- Content Box -->
						<div class="boxContent">
							<div class="avtar">
								<i class="fa-solid fa-people-group"></i>
							</div>
							<h4>${teams.tname}</h4>
							<input class="form-check-input" type="checkbox"
								value="${teams.tid}" name="tid">
						</div>

					</c:forEach>

				</div>

				<input type="submit" value="Submit" class="btn btn-primary"
					id="btnSub">
		</form>
	</div>

	<!-- Main Container End -->


</body>
</html>