<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INDEX</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1 id="head">Customer Name: <c:out value="${customer}"></c:out></h1>
		<p class="subHead">Item: <c:out value="${item}"/></p>
		<p class="subHead">Price: $<c:out value="${cost}"/></p>
		<p class="subHead">Item Description: <c:out value="${desc}"/></p>
		<p class="subHead">From: <c:out value="${seller}"/></p>
	</div>
</body>
</html>