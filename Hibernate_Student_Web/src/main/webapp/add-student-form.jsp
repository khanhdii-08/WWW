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
					<h4>Add Student</h4>
				</div>
				<form  class="mt-3" action="StudentControllerServlet" method="post" enctype="multipart/form-data">

					<div class="row form-group">
						<div class="col-6">	
							<div class="row">
								<div class="col-4 text-right"><label for="firstName">FirstName:</label></div>
								<div class="col-8">
									<input class="form-control" type="text" id="firstName" name="firstName">
								</div>
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-6">
							<div class="row">
								<div class="col-4 text-right"><label for="lastName">Last Name:</label></div>
								<div class="col-8">
									<input class="form-control" type="text" id="lastName" name="lastName">
								</div>
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-6">
							<div class="row">
								<div class="col-4 text-right"><label for="email">Email:</label></div>
								<div class="col-8">
									<input class="form-control" type="text" id="email" name="email">
								</div>
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-6">
							<div class="row">
								<div class="col-4 text-right"><label for="image">Image:</label></div>
								<div class="col-8">
									<input class="form-control" type="file" id="image" name="image">
								</div>
							</div>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-6">
							<div class="row">
								<div class="col-4"></div>
								<div class="col-8">
								<button formaction="insert" class="mt-3 pr-5 pl-5 btn btn-primary" type="submit">Save</button>

								</div>
							</div>
						</div>
					</div>
				</form>
				
				<a href="StudentControllerServlet">Back to List</a>
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