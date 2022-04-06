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
		<h1 id="head">Hello World</h1>
		<p class="subHead">Houston... we have problem.</p>
		<div id="regDiv">
			<a class="link" href="/">Go Back</a>
			<h2 class="subHead">Edit Expense</h2>
			<form:form action="/edit" method="put" modelAttribute="editExpense">
				<form:hidden value="${editExpense.id}" path="id"/>
				<form:errors class="validations" path="expenseName"/>
				<div class="formGroup">
					<form:label path="expenseName">Expense Name:</form:label>
					<form:input class="formInput" path="expenseName"/>
				</div>
				<form:errors class="validations" path="vendor"/>
				<div class="formGroup">
					<form:label path="vendor">Vendor:</form:label>
					<form:input class="formInput" path="vendor"/>
				</div>
				<form:errors class="validations" path="cost"/>
				<div class="formGroup">
					<form:label path="cost">Cost:</form:label>
					<form:input class="formInput" type="number" path="cost"/>
				</div>
				<form:errors class="validations" path="description"/>
				<div class="formGroup">
					<form:label path="description">Description:</form:label>
					<form:input class="formInput" path="description"/>
				</div>
				<input class="button" type="submit" value="Update">
			</form:form>
		</div>
	</div>
</body>
</html>