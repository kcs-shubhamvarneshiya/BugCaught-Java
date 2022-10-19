<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ** -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"></meta>
<title>Pdf Report | BugCaught</title>

<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png"></link>

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheet -->
<link rel="stylesheet" href="../Admin/css/pdf.css"></link>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous"></link>

</head>
<body>

	<div class="mainForm">

		<div class="heading">
			<img alt="bugCaught" src="../images/bug.png"></img>
			<h3>BugCaught</h3>
			<p>Be Bug Free</p>
		</div>

		<div class="table-wrapper">

			<p>Project Report</p>
			<table class="fl-table">
				<thead>
					<tr>
						<th>Sr.No.</th>
						<th>Project Name</th>
						<th>Status</th>
						<th>Start Date</th>
						<th>End Date</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="report" items="">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				<tbody>
			</table>
		</div>
		
		<!--  -->
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
					
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bug" items="">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				<tbody>
			</table>
		</div>
		


	</div>

<div class="copy">
<p>BugCaught&copy;</p>
</div>
</body>
</html>