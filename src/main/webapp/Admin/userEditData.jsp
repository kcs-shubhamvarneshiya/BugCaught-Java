<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Data | BugCaught</title>
<!-- Favicon -->
<link rel="icon" type="image/png" href="../images/bug.png">

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ac6f505c1b.js"
	crossorigin="anonymous"></script>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- Style sheet -->
<link rel="stylesheet" href="../Admin/css/register.css">

<!-- Jquery Validation -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../Admin/jquery/validation.js"></script>

</head>
	<%@ include file="../Admin/navbar.jsp" %>
<body>

	<!-- Main Form Start -->
	<div class="mainForm">
		<p>Edit User Details</p>
	<form action="/EditUserData">
		<small></small>
			<input type="hidden" value="${UserData.uid}" name="uid">
		<div class="form-group">
			<label>First Name</label> 
				<input type="text" class="form-control" id="InputFirstName" name="ufname" placeholder="Enter First Name" value="${UserData.ufname}" required="required"> 
				<small id="firstNameValidation"></small>
		</div>
	
		<div class="form-group">
			<label>Last Name</label> 
				<input type="text" class="form-control" id="InputLastName" name="ulname" placeholder="Enter Last Name" value="${UserData.ulname}" required="required"> 
				<small id="lastNameValidation"></small>
		</div>
	
		<div class="form-group">
			<label>Email address</label> 
				<input type="email" class="form-control" id="InputEmail" name="uemail" placeholder="Enter email" value="${UserData.uemail}" required="required"> 
				<small id="emailValidation"></small>
		</div>
		
		
		<div class="form-group">
			<label>User Role</label>
				
				<select class="form-select" required="required" name="user_role_id">
				<option selected>${UserData.role.user_role}</option>
				
				<c:forEach var="role" items="${userRoleData}">
					<option value="${role.user_role_id}">${role.user_role}</option>
  				</c:forEach>
  				
				</select>
		</div>
		
		<input type="submit" value="Submit" class="btn btn-primary" id="btnSub">
		
	</form>
	</div>
	<!-- Main Form End -->

</body>
</html>