<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!doctype html>
		<html lang="en">

		<head>
			<!-- Required meta tags -->
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

			<!-- Bootstrap CSS -->
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
				integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
				crossorigin="anonymous">

			<title>Student Tracker App</title>
		</head>

		<body>
			<main class="container">

				<header class="row bg-primary">
					<h1 class="text-white">FooBar University</h1>
				</header>
				<div class="row mt-3">
					<input style="border-radius: 7px;" type="button" value="Add Student" 
					onclick="window.location.href='add-student-form.jsp'; return false;"/>
					

				</div>

				<div class="row">
					<table class="col-12 table table-striped mt-3">
						<thead class="bg-primary">
							<tr class="text-white">
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Image</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tempStudent" items="${list_Student}">
								<tr>
									<td>${tempStudent.firstName}</td>
									<td>${tempStudent.lastName}</td>
									<td>${tempStudent.email}</td>
									<td><img style="height: 70px; width: 100px;"  src=images/${tempStudent.image} alt=""></td>	
									<td><a href="load?id=${tempStudent.id}"  >Update</a> | <a href="delete?id=${tempStudent.id}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				

			</main>

			<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
			<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
				integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
				crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
				crossorigin="anonymous"></script>

		</body>

		</html>