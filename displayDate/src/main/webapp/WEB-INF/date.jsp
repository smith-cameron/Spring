<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DATE</title>
<link rel="stylesheet" href="/css/style.css">
<script type="text/javascript" src="js/date.js"></script>
</head>
<body>
	<div id=wrapper>
		<div id=display>
			<a href="/" id=head><c:out value="${todaysDate}"></c:out></a>
		</div>
	</div>
</body>
</html>