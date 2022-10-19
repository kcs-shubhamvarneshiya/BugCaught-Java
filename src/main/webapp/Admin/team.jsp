<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team | BugCaught</title>

<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheets -->
<link rel="stylesheet" href="../Admin/css/MainStyle.css" />
<link rel="stylesheet" href="../Admin/css/register.css" />

<!-- Jquery Validation -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="../Admin/jquery/validation.js"></script>


<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<!-- Navbar Start -->
	<%@ include file="../Admin/navbar.jsp" %>
<body>


	<!-- Main Container Start -->

	<!-- Add Team Form Start -->

	<div class="mainForm">
		<p>Register Team</p>
		<form action="addTeam" method="post">
			

			<div class="form-group">
				<label>Team Name</label> <input type="text" class="form-control"
					id="InputTeamName" name="tname" placeholder="(i.e., Java )"
					required="required"> <small id="teamNameValidation">${ErrMsg}</small>
			</div>
			
			<div class="form-group">
				<label>Team Role</label>
				<select class="form-select" name="trole">
					<option selected>Please Select Role</option>
					<option value="Developer">Developing</option>
					<option value="Tester">Testing</option>
				</select>		
			</div>

			<input type="submit" value="Submit" class="btn btn-primary"
				id="btnSub">

		</form>
	</div>

	<!-- Add Team From End -->

	<!-- Display team List Start -->

	<div class="table-wrapper">

		<p>Team List</p>
		<table class="fl-table">
			<thead>
				<tr>
					
					<th>Team Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${teamList==null}">

						<tr>
							<td colspan="2"><img src="../images/nodata.gif"><br />
								<h6>No Data Found !</h6></td>
						</tr>

					</c:when>
					<c:otherwise>
						<c:forEach var="team" items="${teamList}">
							<tr>
								<td>${team.tname}</td>
								<td><a
									href="${pageContext.request.contextPath}/teamShow/${team.tid}"
									class="btnprimary"><i
										class="fa-solid fa-arrows-down-to-people"></i></a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			<tbody>
		</table>
	</div>


	<!-- Display Team List End -->

	<!-- Main Container End -->
</body>
</html>