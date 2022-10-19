<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show Team | BugCaught</title>

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

<!-- Navbar -->
	<%@ include file="../Admin/navbar.jsp" %>

<body>

	<!-- Main Container Start -->

	<div class="mainBox">
		<p>Show Team</p>
		<form action="" method="post">
			<small></small>
			<div class="form-group">
				<h3>${projectList.project_name}</h3>
			</div>

			<div class="form-group">
				<label>Selected Teams</label>
				<hr />

				<c:forEach var="team" items="${teamList}">

					<!-- Content Box -->

					<div class="boxContent">
						<a
							href="${pageContext.request.contextPath }/removeTeam/${team.tid}/${projectList.pid}"
							onclick="return alert('Are You Sure, want to Delete ?')"><i
							class="fa-solid fa-xmark"></i></a>
						<div class="avtar">
							<i class="fa-solid fa-people-group"></i>
						</div>
						<h4>${team.tname}</h4>
					</div>

					<!-- *********** -->
				</c:forEach>

				<div class="addMore">
					<a
						href="${pageContext.request.contextPath}/addMoreTeam/${projectList.pid}">Add
						More ?</a>
				</div>
			</div>

		</form>
	</div>



	<!-- Main Container End -->

</body>
</html>