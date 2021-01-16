<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Category info</title>
	</head>
	<body>
		<h1><c:out value="${category.name}"/></h1>
		<c:forEach items="${category.products}" var="product">
			<ul>
				<li><c:out value="${product.name}"></c:out></li>
			</ul>
		</c:forEach>
		<p>
			Add Product:
			<form:form action = "/add/product" method="post" modelAttribute = "categoryProduct">
				<form:input type= "hidden" path = "category" value="${category.id}"/>
				<form:select path="product">
					<c:forEach items = "${product}" var= "product">
						<form:option value="${product.id}">
							<c:out value="${product.name}"/>
						</form:option>				
					</c:forEach>
				</form:select>
				<button type="submit">Add</button>
			</form:form>
		</p>
	</body>
</html>