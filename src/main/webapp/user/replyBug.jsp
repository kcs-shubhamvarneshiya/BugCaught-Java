<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fix | BugCaught</title>
<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheets -->
<link rel="stylesheet" href="../user/css/mainStyle.css" />

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<!-- Navbar start -->
<%@ include file="../user/navbar.jsp"%>
<!-- Navbar End  -->
<body>
	<!-- Main Container Start -->
	<div class="mainForm">
		<p>Reply Bug</p>
		<hr/>
		
		<form action="/editStatus" method="post">
			 <input type="hidden" name="did" value="${bugList.did.uid}"> 
			<input type="hidden" name="bid" value="${bugList.bid}">
			
			
			<div class="form-group">
				<div class="testerData">
					<label>Assign By</label>
					<h6>${bugList.tid.ufname} ${bugList.tid.ulname}</h6>
					<p>${bugList.tid.role.user_role}</p>
					<input type="hidden" name="tid" value="${bugList.tid.uid}">
				</div>
				
			</div>

			<div class="form-group">
				<label>Description</label>
				<textarea rows="2" cols="40" id="InputDescription"
					class="form-control" name="bdes"
					placeholder="Please Mention Bug Description">${bugList.bdes}</textarea>

				<small id="DescriptionValidation"></small>
			</div>

			<div class="form-group">
				<label>Project Name</label> <br /> <input type="hidden"
					class="form-control" value="${bugList.pid.pid}" name="pid">
				<h4 class="form-control">${bugList.pid.project_name}</h4>

			</div>


			<div class="form-group">
				<label>Status</label><br /> <select class="form-select"
					required="required" name="bstatus">
					<option selected value="${bugList.bstatus}">${bugList.bstatus}</option>
					<option value="Fixed">Fixed</option>

				</select>

			</div>


			<input type="submit" value="Submit" id="btnSub">

		</form>
	</div>
	<!-- Main Container End -->
</body>
</html>