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
	<c:if test="${student == null }">
		<form action="insert" method="get">
	</c:if>
	<c:if test="${student != null }">
		<form action="update"  method="get">
			<input hidden="true" name="id" value="${student.id }">
	</c:if>
		First Name: <input type="text" name="firstName" value="${student.firstName }"> <br> <br>
		Last Name: <input type="text" name="lastName" value="${student.lastName }"> <br> <br>
		Gender: <input type="radio" name="gender" value="Nam" ${student.gender == "Nam" ? "checked" : "" }> Nam
				<input type="radio" name="gender" value="Nữ" ${student.gender == "Nữ" ? "checked" :"" }> Nữ <br> <br>
				
		Country: 
		<select name="country">
			<option value="Việt Nam" ${student.country == "Việt Nam" ? "selected" : ""}>Việt Nam</option>
			<option value="Lào" ${student.country == "Lào" ? "selected" : ""}>Lào</option>
			<option value="Campuchia" ${student.country == "Campuchia" ? "selected" : ""}>Campuchia</option>
		</select>		
		<br> <br>
		
		Language: <input type="checkbox" name="language" value="Java"> Java 
				  <input type="checkbox" name="language" value="Nodejs"> Nodejs
				  <input type="checkbox" name="language" value="JavaScript"> JavaScript <br> <br>
		
		<input type="submit" value="Save">
	</form>
</body>
</html>