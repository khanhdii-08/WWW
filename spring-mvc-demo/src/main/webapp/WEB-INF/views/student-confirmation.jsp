<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	The Frist Name: ${student.firstName }
	<br>
	<br> The Last Name: ${student.lastName }
	<br>
	<br> Country: ${student.country }
	<br>
	<br> Favorite Language: ${student.favoriteLanguage }
	<br>
	<br>

	<ul>
		<c:forEach var="temp" items="${student.operatingSystems }">
			<li>${temp }</li>
		</c:forEach>
	</ul>

</body>
</html>