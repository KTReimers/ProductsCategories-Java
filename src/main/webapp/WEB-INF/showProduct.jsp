<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product info</title>
	</head>
	<body>
		<h1><c:out value="${product.name}"/></h1>
		<c:forEach items="${product.categories}" var="category">
			<ul>
				<li><c:out value="${category.name}"></c:out></li>
			</ul>
		</c:forEach>
		<p>
			Add Category:
			<form:form action = "/add/category" method="post" modelAttribute = "categoryProduct">
				<form:input type= "hidden" path = "product" value="${product.id}"/>
				<form:select path="category">
					<c:forEach items = "${category}" var= "category">
						<form:option value="${category.id}">
							<c:out value="${category.name}"/>
						</form:option>				
					</c:forEach>
				</form:select>
				<button type="submit">Add</button>
			</form:form>
		</p>
	</body>
</html>