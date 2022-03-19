<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="customer">
		<label>First Name: </label> <form:input path="firstName"/> <br> <br>
		<label>Last Name: </label> <form:input path="lastName"/> <br> <br>
		<label>Sex: </label> <form:radiobutton path="sex" value="Nam"/> <label>Nam</label> <form:radiobutton path="sex" value="Nu"/> <label>Nu</label> <br> <br>
		<label>Address: </label> <form:input path="address"/> <br> <br>
		<label>Email: </label> <form:input path="email"/>
		<input type="submit">
	</form:form>
</body>
</html>