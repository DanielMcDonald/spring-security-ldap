<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Person Page</title>
</head>
<body>

<h1>Create New Person</h1>

<p>Now featuring validation. First and last names may not be blank.</p>

<c:url var="saveUrl" value="/danny/person/persons/add" />
<form:form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="firstName">First Name:</form:label></td>
			<form:errors path="firstName" />
			<td><form:input path="firstName"/></td>
		</tr>

		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<form:errors path="lastName" />
			<td><form:input path="lastName"/></td>
		</tr>
		
		<tr>
			<td><form:label path="money">Money</form:label></td>
			<td><form:input path="money"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>