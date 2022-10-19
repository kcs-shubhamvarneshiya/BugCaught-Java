<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bug List | BugCaught</title>
<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheets -->
<link rel="stylesheet" href="../Admin/css/MainStyle.css" />

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<!-- navbar start -->
<%@ include file="../Admin/navbar.jsp"%>
<!-- Navbar End -->
<body>
	<!-- Main Container Start -->

	<div class="table-wrapper">

		<p>Bug List</p>
		<table class="fl-table">
			<thead>
				<tr>
				
					<th>Description</th>
					<th>Status</th>
					<th>Project Name</th>
					<th>Assign To</th>
					<th>Assign By</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bug" items="${bugData}">
					<tr>
					
						<td>${bug.bdes}</td>
						<td>${bug.bstatus}</td>
						<td>${bug.pid.project_name}</td>
						<td>${bug.did.ufname} ${bug.did.ulname}</td>
						<td>${bug.tid.ufname} ${bug.tid.ulname}</td>
						
						
						
					</tr>
				</c:forEach>
			<tbody>
		</table>
	</div>

	<!-- Main Container End -->
	
	</body>
</html>