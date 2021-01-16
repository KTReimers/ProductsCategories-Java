<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Product</title>
	</head>
	<body>
		<form:form action="/products/create" method="post" modelAttribute="product" >
			<p>
				Name:
				<form:errors path="name"/>
				<form:input type="text" path="name"/>
			</p>
			<p>
				Description:
				<form:errors path="description"/>
				<form:input type="text" path="description"/>
			</p>
			<p>
				Price:
				<form:errors path="price"/>
				<form:input type="number" step="0.01" path="price"/>
			</p>
			<button type="submit">Submit new Product</button>
		</form:form>
		
	</body>
</html>