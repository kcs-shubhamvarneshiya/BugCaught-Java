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

		<p>Project List</p>
		<table class="fl-table">
			<thead>
				<tr>

					<th>Project Name</th>
					<th>Technology</th>
					<th>Status</th>
					<th colspan="4">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${projectList!=null}">

						<c:forEach var="project" items="${projectList}">
							<tr>
								<td>${project.project_name}</td>
								<td>${project.technology}</td>
								<c:set var="status" value="${project.status}" />
								<c:choose>
									<c:when test="${(status=='developing')}">
										<td><small
											style="background-color: #2ECC71; color: #fff; padding: 10px;">${project.status}
												<i class="fa-solid fa-spinner fa-spin-pulse fa-spin-reverse"></i>
										</small></td>
									</c:when>
									<c:otherwise>
										<td><small
											style="background-color: #E74C3C; color: #fff; padding: 10px;">${project.status}</small></td>
									</c:otherwise>
								</c:choose>
								<td><a
									href="${pageContext.request.contextPath}/DeleteTeamByProject/${project.pid}"
									class="btndanger" onclick="return confirm('Are You Sure ?')"><i
										class="fa-solid fa-trash-can"></i></a></td>
								<td><a
									href="${pageContext.request.contextPath}/editTeamByProject/${project.pid}"
									class="btnsuccess"><i class="fa-solid fa-pen-to-square"></i></a></td>
								<td><a
									href="${pageContext.request.contextPath}/showTeamByProject/${project.pid}"
									class="btnprimary"><i
										class="fa-solid fa-arrows-down-to-people"></i></a></td>

								<!-- ***************  -->

								<c:set var="status" value="${project.status}" />
								<c:choose>
									<c:when test="${(status=='developing')}">
										<td><a href="/projectList" class="btnprimary"
											onclick="return alert('You can not generate Report , due to project status')"><i
												class="fa-solid fa-file-arrow-down"></i></a></td>
									</c:when>
									<c:otherwise>
										<td><a
											href="${pageContext.request.contextPath}/projectReport/${project.pid}"
											class="btnprimary"><i class="fa-solid fa-file-arrow-down"></i></a>
										</td>
									</c:otherwise>
								</c:choose>

							</tr>
						</c:forEach>

					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8"><img src="../images/nodata.gif"></td>
						</tr>

					</c:otherwise>
				</c:choose>
			<tbody>
		</table>
	</div>

	<!-- Main Container End -->
</body>
</html>