<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Home | BugCaught</title>
<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheets -->
<link rel="stylesheet" href="../tester/css/mainStyle.css" />


</head>
<!-- Navbar start -->
<%@ include file="../tester/navbar.jsp"%>
<!-- Navbar End -->
<body>
	<!-- Main Container Start -->


	<!-- Team Details Start -->

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
									href="${pageContext.request.contextPath}/searchProject2/${team.tid}"
									class="btnprimary"><i
										class="fa-solid fa-magnifying-glass fa-bounce"></i></a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			<tbody>
		</table>
	</div>

	<!-- Team Details End -->

	<!-- Bugs -->

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
					<th>Reply</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${BugData==null}">

						<tr>
							<td colspan="6"><img src="../images/nodata.gif"><br />
								<h6>No Data Found !</h6></td>
						</tr>

					</c:when>
					<c:otherwise>
						<c:forEach var="bug" items="${BugData}">
							<tr>

								<td>${bug.bdes}</td>
								<td>${bug.bstatus}</td>
								<td>${bug.pid.project_name}</td>
								<td>${bug.did.ufname}${bug.did.ulname}</td>
								<td>${bug.tid.ufname}${bug.tid.ulname}</td>

								<c:set var="status" value="${bug.bstatus}" />
								<c:choose>
									<c:when test="${(status=='Close')}">
										<td><i class="fa-solid fa-minus"></i></td>
									</c:when>
									<c:otherwise>
										<td><a
											href="${pageContext.request.contextPath}/replyBug/${bug.bid}"
											class="btnprimary"><i class="fa-solid fa-reply"></i></a></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			<tbody>
		</table>
	</div>

	<!-- Main Container End -->
	</body>
</html>