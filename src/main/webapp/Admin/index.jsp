<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard | BugCaught</title>

<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Style sheets -->
<link rel="stylesheet" href="../Admin/css/MainStyle.css" />

<!-- Boot Strap  -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- java script -->
<script type="text/javascript" src="../Admin/javascripts/animation.js"></script>

</head>
<body>

	<div class="wrapper">
		<div class="sidebar">
			<h2>
				<i class="fa-solid fa-bug"></i>&nbsp; Bug<span>Caught</span>
			</h2>
			<ul>
				<li><a href="/admdash"><i class="fas fa-home"></i>Home</a></li>

				<li><a href="#"><i class="fas fa-user"></i>User <i
						class="fa-solid fa-square-caret-down"></i></a></li>

				<li class="sub"><a href="/register"><i
						class="fa-solid fa-user-plus"></i>Add User</a></li>


				<li><a href="/team"><i class="fa-solid fa-people-group"></i>
						Team </a></li>
				<!-- <li class="sub"><a href="/addMember"><i
						class="fa-solid fa-people-line"></i> Add Member </a></li>
 				-->
				<li><a href="/project"><i class="fas fa-project-diagram"></i>Project <i class="fa-solid fa-square-caret-down"></i></a></li>
				<li class="sub"><a href="/projectList"><i class="fa-solid fa-clipboard-list"></i> Project List</a></li>
				<!-- <li class="sub"><a href="/projectAssign"><i class="fa-solid fa-hands-holding-child"></i> Assign To Teams</a></li>
				 -->
				<li><a href="/bugList"><i class="fa-solid fa-spider"></i> Bug <i class="fa-solid fa-square-caret-down"></i></a></li>
				<li class="sub"><a href="/displayReport"><i class="fa-solid fa-file-circle-plus"></i> Report List</a></li>
			</ul>
			<div class="social_media">
				<a href="/logout"><i class="fa-solid fa-right-from-bracket"></i></a>
			</div>
		</div>
		<div class="main_content">

			<div class="header">
				<p>Hello , ${AdminSess}</p>

				<div class="notification" id="bell">
					<a href=""><i class="fa-solid fa-bell fa-shake"></i></a>
				</div>
				
			</div>


			<div class="info">


				<div>
					<!-- Developer List -->
					<div class="table-wrapper">

						<p>Developer List</p>
						<table class="fl-table">
							<thead>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Email</th>
									<th>Role</th>
									<th colspan="2">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${userList}">
									<tr>
										<td>${user.ufname}</td>
										<td>${user.ulname}</td>
										<td>${user.uemail}</td>
										<td>${user.role.user_role}</td>
										<td><a
											href="${pageContext.request.contextPath }/userEdit/${user.uid}"
											class="btnsuccess"><i class="fa-solid fa-user-pen"></i></a></td>
										<td><a
											href="${pageContext.request.contextPath}/userDelete/${user.uid}"
											class="btndanger"
											onclick="return confirm('Are You Sure want to delete ?')"><i
												class="fa-solid fa-trash-can"></i></a></td>
									</tr>
								</c:forEach>
							<tbody>
						</table>
					</div>

				</div>

				<!-- User role list -->
				<div>
					<div class="role-wrapper">
						<p>User Role List</p>
						<table class="rl-table">
							<thead>
								<tr>
									<th>Sr.No</th>
									<th>Role</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="role" items="${roleList}">
									<tr>
										<td>${role.user_role_id}</td>
										<td>${role.user_role}</td>
									</tr>
								</c:forEach>
							<tbody>
						</table>
					</div>

				</div>


			</div>
		</div>
	</div>

</body>
</html>