<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="search">
			<input type="text" name="nameStudent"> <input type="submit" value="Search"> <br> <br>
	</form>
	
	<input type="button" value="Add Student"
	onclick="window.location.href='student-form.jsp'; return false;">

	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Country</th>
				<th>Language</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students }">
				<tr>
					<td>${student.firstName }</td>
					<td>${student.lastName }</td>
					<td>${student.gender }</td>
					<td>${student.country }</td>
					<td>${student.language }</td>
					<td>
						<a href="delete?id=${student.id}">Delete</a>|
						<a href="load?id=${student.id}">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>