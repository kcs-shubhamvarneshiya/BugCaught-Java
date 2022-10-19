<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ** -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report List | BugCaught</title>
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
	<div class="table-wrapper">

		<p>Report List</p>
		<table class="fl-table">
			<thead>
				<tr>
					<th>Sr.No.</th>
					<th>Project Name</th>
					<th>Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Download</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="report" items="${reportData}">
					<tr>
						<td>${report.rid}</td>
						<td>${report.pid.project_name}</td>
						<td>${report.status}</td>
						<td>${report.startdate}</td>
						<td>${report.enddate}</td>
						<td><a
							href="${pageContext.request.contextPath }/exportPdf/${report.rid}"
							class="btnprimary"><i class="fa-solid fa-download fa-bounce"></i></a></td>
					</tr>
				</c:forEach>
			<tbody>
		</table>
	</div>
	<!-- Main Container End -->
</body>
</html>