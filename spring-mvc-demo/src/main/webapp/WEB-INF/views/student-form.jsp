<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	<label>First Name: </label> <form:input path="firstName" /> 
 	<label>Last Name: </label> <form:input path="lastName" />
 	<br>
 	<br>

		<form:select path="country">
			<form:option value="Brazil">Brazil</form:option>
			<form:option value="France">France</form:option>
			<form:option value="Germany">Germany</form:option>
			<form:option value="India">India</form:option>
		</form:select>
		<br>
		<br>
		<label>Favorite Language: </label>
		<form:radiobutton path="favoriteLanguage" value="Java" />
		<label>Java</label>
		<form:radiobutton path="favoriteLanguage" value="C#" />
		<label>C#</label>
		<form:radiobutton path="favoriteLanguage" value="PHP" />
		<label>PHP</label>
		<form:radiobutton path="favoriteLanguage" value="Ruby" />
		<label>Ruby</label>
		<br>
		<br>
		<label>Operating Systems: </label>
		<form:checkbox path="operatingSystems" value="Linux" />
		<label>Linux</label>
		<form:checkbox path="operatingSystems" value="Mac" />
		<label>Mac</label>
		<form:checkbox path="operatingSystems" value="MS Windows" />
		<label>MS Windows</label>
		<form:checkbox path="operatingSystems" value="Or" />
		<label>Or</label>
		
		<br> <br>
		
		<input type="submit">
	</form:form>
</body>
</html>