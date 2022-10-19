<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bug Reply | BugCaught</title>
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
		<p>Reply Bug</p>
		<hr/>
		
		<form action="/ansReply" method="post">
			 <input type="hidden" name="did" value="${BugData.did.uid}"> 
			<input type="hidden" name="bid" value="${BugData.bid}">
			
			
			<div class="form-group">
				<div class="testerData">
					<label>Assign By</label>
					<h6>${BugData.tid.ufname} ${bugList.tid.ulname}</h6>
					<p>${BugData.tid.role.user_role}</p>
					<input type="hidden" name="tid" value="${BugData.tid.uid}">
				</div>
				
			</div>

			<div class="form-group">
				<label>Description</label>
				<textarea rows="2" cols="40" id="InputDescription"
					class="form-control" name="bdes"
					placeholder="Please Mention Bug Description">${BugData.bdes}</textarea>

				<small id="DescriptionValidation"></small>
			</div>

			<div class="form-group">
				<label>Project Name</label> <br /> <input type="hidden"
					class="form-control" value="${BugData.pid.pid}" name="pid">
				<h4 class="form-control">${BugData.pid.project_name}</h4>

			</div>


			<div class="form-group">
				<label>Status</label><br /> <select class="form-select"
					required="required" name="bstatus">
					<option selected value="${BugData.bstatus}">${BugData.bstatus}</option>
					<option value="Close">Close</option>
					<option value="ReOpen">Re Open</option>

				</select>

			</div>


			<input type="submit" value="Submit" id="btnSub">

		</form>
	</div>
	<!-- Main Container End -->


</body>
</html>