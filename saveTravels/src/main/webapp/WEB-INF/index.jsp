<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INDEX</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1 id="head">SAVE TRAVELS</h1>
		<p class="subHead">S-A-V-E... not safe.</p>
		<div id="ExpenseDiv">
			<h2 class="subHead">Expenses</h2>
			<table>
				<thead>
					<tr>
						<th class="tHead"></th>
						<th class="tHead">Vendor</th>
						<th class="tHead">Cost</th>
						<th class="tHead">Description</th>
						<th class="tHead"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${expenses}" var="expense">
						<tr>
							<td class="tData"><h3>
									<a class="link" href="/expenses/show/${expense.id}">${expense.expenseName}</a>
								</h3></td>
							<td class="tData">${expense.vendor}</td>
							<td class="tData">$${expense.cost}</td>
							<td class="tData">${expense.description}</td>
							<td class="tData"><a class="link"
								href="/expenses/edit/${expense.id}">EDIT</a>
								<form action="/expenses/delete/${expense.id}" method="post">
									<input type="hidden" name="_method" value="delete"/>
										<input class="button" type="submit" value="DELETE"/>
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="regDiv">
			<h2 class="subHead">Add Expense</h2>
			<form:form action="/expenses" method="post"
				modelAttribute="newExpense">
				<form:errors class="validations" path="expenseName" />
				<div class="formGroup">
					<form:label path="expenseName">Expense Name:</form:label>
					<form:input class="formInput" path="expenseName" />
				</div>
				<form:errors class="validations" path="vendor" />
				<div class="formGroup">
					<form:label path="vendor">Vendor:</form:label>
					<form:input class="formInput" path="vendor" />
				</div>
				<form:errors class="validations" path="cost" />
				<div class="formGroup">
					<form:label path="cost">Cost:</form:label>
					<form:input class="formInput" type="number" path="cost" />
				</div>
				<form:errors class="validations" path="description" />
				<div class="formGroup">
					<form:label path="description">Description:</form:label>
					<form:input class="formInput" path="description" />
				</div>
				<input class="button" type="submit" value="Create">
			</form:form>
		</div>
	</div>
</body>
</html>