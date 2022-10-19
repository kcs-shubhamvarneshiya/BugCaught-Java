<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- Navbar -->
<div class="mainNav">
	<nav class="navbar navbar-expand-lg">
		<div class="heading">
			<a class="navbar-brand" href="/qaDash"><i class="fa-solid fa-bug"></i>&nbsp;BugCaught</a>
		</div>


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="navMenu">

			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="/qaDash">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/bug">Bug</a></li>
					<li class="nav-item"><a class="nav-link" href="#">${TesterSess.ufname}</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout"><i class="fa-solid fa-right-from-bracket"></i></a></li>
				</ul>

			</div>
		</div>
	</nav>
</div>