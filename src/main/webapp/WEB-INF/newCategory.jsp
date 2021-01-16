<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Category</title>
	</head>
	<body>
		<form:form action="/categories/create" method="post" modelAttribute="category">
			<p>
				Name:
				<form:errors path="name"/>
				<form:input type="text" path="name"/>
			</p>
			<button type="submit">Submit new Category</button>
		</form:form>
	</body>
</html>