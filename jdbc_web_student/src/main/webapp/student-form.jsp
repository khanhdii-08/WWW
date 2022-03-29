<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<header class="bg-primary">
			<h1 class="text-white">FooBar University</h1>
		</header>

		<h4 class="mt-3">Add Student</h4>

		<c:if test="${student == null }">
			<form class="mt-3" action="insert" method="get">
		</c:if>

		<c:if test="${student != null }">
			<form class="mt-3" action="update" method="get">
			<input type="hidden" name="id" value=${student.id} />
		</c:if>

		<div class="row">
			<div class="col-6">
			
				<div class="row form-group ">
					<div class="col-4 text-right">
						<label for="">First Name: </label>
					</div>
					<div class="col-8">
						<input type="text" class="form-control" name="firstName" value="${student.firstName }">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-4 text-right">
						<label>Last Name: </label>
					</div>
					<div class="col-8">
						<input type="text" class="form-control" name="lastName" value="${student.lastName }">
					</div>
				</div>
				
				<div class="row">
					<div class="col-4 text-right">
						<label>Email: </label>
					</div>
					<div class="col-8">
						<input type="email" class="form-control" name="email" value="${student.email }">
					</div>
				</div>
				
				<div class="row">
					<div class="col-4"></div>
					<div class="col-8">
						<input type="submit" value="Save" class="btn btn-primary mt-3">
					</div>
				</div>
				
			</div>
		</div>
			

		</form>

	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>
</body>
</html>