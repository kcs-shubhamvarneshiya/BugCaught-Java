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
<link rel="stylesheet" href="../tester/css/mainStyle.css" />

</head>
<!-- Navbar start -->
<%@ include file="../tester/navbar.jsp"%>
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
					<th colspan="2">Action</th>

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
						<input type="hidden" value="${teamData.tid}" name="tid">
						<c:forEach var="project" items="${projectList}">
							<tr>
								<td>${project.project_name}</td>
								<td>${project.technology}</td>

								<c:set var="status" value="${project.status}" />
								<c:choose>
									<c:when test="${(status=='developing')}">
										<td><small
											style="background-color: #2ECC71; color: #fff; padding: 10px;">${project.status}
												<i class="fa-solid fa-spinner fa-spin-pulse"></i>
										</small></td>
										<td><a
											href="${pageContext.request.contextPath}/raiseBug/${project.pid}"
											class=""><i class="fa-solid fa-bug fa-beat-fade"
												style="color: red;"></i></a></td>
									</c:when>
									<c:otherwise>
										<td><small
											style="background-color: #E74C3C; color: #fff; padding: 10px;">${project.status}</small></td>
											
									</c:otherwise>
								</c:choose>



								<c:choose>

									<c:when test="${BugStatus == null}">
										<td><a
											href="${pageContext.request.contextPath}/editProject/${project.pid}"
											class="btnsuccess"><i class="fa-solid fa-pen-to-square"></i></a></td>
									</c:when>

									<c:when test="${BugStatus != null}">
										<td><a
											href="${pageContext.request.contextPath}/raiseBug/${project.pid}"
											class=""><i class="fa-solid fa-bug fa-beat-fade"
												style="color: red;"></i></a></td>
									</c:when>


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