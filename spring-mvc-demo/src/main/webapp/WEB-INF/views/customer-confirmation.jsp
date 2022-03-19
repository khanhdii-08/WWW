<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="temp" items="${customers }">
		<ul>
			<li>First Name: ${temp.firstName }</li>
			<li>Last Name: ${temp.lastName }</li>
			<li>Sex: ${temp.sex }</li>
			<li>Address: ${temp.address }</li>
			<li>Email: ${temp.email }</li>
		</ul>
			<hr> <br>
	</c:forEach>
	
	<a href="showForm">Trở lại trang đăng ký</a>
</body>
</html>