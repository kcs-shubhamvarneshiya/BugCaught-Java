<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bug | BugCaught</title>
<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheets -->
<link rel="stylesheet" href=".././tester/css/mainStyle.css" />

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<!-- Navbar start -->
<%@ include file="../tester/navbar.jsp"%>
<!-- Navbar End  -->
<body>

	<!-- Main Container Start -->

	<div class="mainForm">
		<p>Raise Bug</p>
		<hr />
		<form action="/addBug" method="post">
			<small></small>
			<div class="form-group">
				<label>Project Name</label> <br /> <input type="hidden"
					class="form-control" value="${projectData.pid}" name="pid">
				<h4 class="form-control">${projectData.project_name}</h4>

			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea rows="2" cols="40" id="InputDescription"
					class="form-control" name="bdes"
					placeholder="Please Mention Bug Description"></textarea>
				<!-- <input type="" class="form-control" id="InputFirstName" name="ufname" placeholder="Enter First Name" required="required"> -->
				<small id="DescriptionValidation"></small>
			</div>


			<div class="form-group">
				<label>Status</label><br /> <select class="form-select"
					required="required" name="bstatus">
					<option selected>Select Status</option>
					<option value="NewAssign">New Assign</option>
				</select>

			</div>

			<div class="form-group">
				<label>Assign To</label> <br /> <select class="form-select"
					required="required" name="did">
					<option selected>Select Developer</option>

					<c:forEach var="developer" items="${userList}">
						<option value="${developer.uid}">
							<div class="selectDev">
								<p>${developer.ufname} ${developer.ulname}</p>
								<div>
									<h6>${developer.role.user_role}</h6>
								</div>

							</div>
							
						</option>
					</c:forEach>

				</select>

			</div>

			<div class="form-group">
				<div class="testerData">
					<label>Assign By</label>
					<h6>${tester.ufname}${tester.ulname}</h6>
					<p>${tester.role.user_role}</p>
				</div>
				<input type="hidden" class="form-control" name="tid"
					value="${tester.uid}">
			</div>


			<input type="submit" value="Submit" id="btnSub">

		</form>
	</div>


	<!-- Main Container End -->

	<div></div>




	<!-- Main Container End -->

</body>
</html>