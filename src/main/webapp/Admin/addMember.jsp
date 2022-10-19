<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Member | BugCaught</title>

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
<!-- navbar -->
<%@ include file="../Admin/navbar.jsp"%>
<body>
	
	<!-- Main Container start -->

	<div class="mainBox">
		<p>Add Member</p>
		<!-- 
		<div class="form-group">
			<form action="search">
				<label>Search By </label> <select class="form-select"
					required="required" name="rid">

					<option selected>${role}</option>

					<c:forEach var="role" items="${roleList}">

						<option value="${role.user_role_id}">${role.user_role}</option>

					</c:forEach>

				</select> <input type="submit" value="Search" class="btn btn-primary"
					id="btnSub">
			</form>
		</div>
		 -->
		<hr />
		<form action="addDev" method="post">
			<small></small>
			<div class="form-group">

				<label>Select Team Name</label> <select class="form-select"
					required="required" name="tid">

					<option selected>Select Team</option>

					<c:forEach var="team" items="${teamList}">

						<option value="${team.tid}">${team.tname}</option>

					</c:forEach>

				</select>
			</div>


			<div class="form-group">
				<label>Select Candidate</label>
				<hr />
				<!-- --------- -->
				<c:forEach var="user" items="${userData}">

					<!-- Content Box -->
					<div class="boxContent">
						<div class="avtar">
							<i class="fa-solid fa-user-ninja"></i>
						</div>
						<h4>${user.ufname}</h4>
						<hr />
						<h6>${user.role.user_role}</h6>
						<input class="form-check-input" type="checkbox"
							value="${user.uid}" name="uid">
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