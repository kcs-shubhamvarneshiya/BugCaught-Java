<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project List | BugCaught</title>
<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheets -->
<link rel="stylesheet" href="../user/css/mainStyle.css" />

</head>
<!-- Navbar start -->
<%@ include file="../user/navbar.jsp"%>
<!-- Navbar End -->
<body>

	<!-- Main Container Start -->

	<!-- Display Project Container Start -->

	<div class="table-wrapper">

		<p>Project List</p>
		<table class="fl-table">
			<thead>
				<tr>
					<th>Project Name</th>
					<th>Technology</th>
					<th>Status</th>
					

				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${projectList==null}">

						<tr>
							<td colspan="3"><img src="../images/nodata.gif"><br />
								<h6>No Data Found !</h6></td>
						</tr>

					</c:when>
					<c:otherwise>
						<c:forEach var="project" items="${projectList}">
							<tr>
								<td>${project.project_name}</td>
								<td>${project.technology}</td>
								<c:set var="status" value="${project.status}" />
								<c:choose>
								<c:when test="${(status=='developing')}">
									<td><small style="background-color: #2ECC71;color:#fff;padding:10px;">${project.status}</small></td>
								</c:when>
								<c:otherwise>
									<td><small style="background-color: #E74C3C;color:#fff;padding:10px;">${project.status}</small></td>
								</c:otherwise>
								</c:choose>
							
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<tbody>
		
		</table>
	</div>

<!-- Display Project Container Start -->

				<!-- Main Container End -->


			</body>
</html>