<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/spring-securiy-ldap/resources/js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.pack.js"></script>
<!-- <script type="text/javascript">   -->

<%-- var modelAttributeValue = "Test" + "${testAttribute}"; --%>

<!-- $(document).ready(function() { -->
<!-- 	   $("#hmmm").click(function() { -->
<!-- 	     alert(modelAttributeValue); -->
<!-- 	   }); -->
<!-- 	 });                                       -->
<!--  </script>   -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Persons</h1>
<!-- <div id="hmmm">HMMMMMM</div> -->
<c:url var="addUrl" value="/danny/person/persons/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#FF0">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Money</th>
			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${persons}" var="person">
			<c:url var="editUrl" value="/danny/person/persons/edit?id=${person.id}" />
			<c:url var="deleteUrl" value="/danny/person/persons/delete?id=${person.id}" />
			<c:url var="viewUrl" value="/danny/person/persons/view?id=${person.id}" />
		<tr>
			<td><a href ="${viewUrl}"><c:out value="${person.firstName}" /></a></td>
			<td><c:out value="${person.lastName}" /></td>
			<td><c:out value="${person.money}" /></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
<%-- 			<td><a href="${addUrl}">Add</a></td> --%>
		</tr>
	</c:forEach>
	</tbody>
</table>
<c:if test="${!empty persons}">
	<a href="/spring-security-ldap/danny/person/persons">Back</a>
</c:if>
<p><c:out value="${testing}" /></p>
<c:if test="${empty persons}">
	There are currently no persons in the list. <a href="${addUrl}">Add</a> a person.
</c:if>

<%-- <c:url var="searchUrl" value="/danny/person/persons/search" /> --%>
<%-- <form:form  method="POST" action="/danny/person/persons/search"> --%>

<%-- 	<form:label path="firstName">Search for person (Enter persons first name):</form:label> --%>
<%-- 	<form:input path="firstName"/> --%>
	
<!-- 	<input type="submit" value="Search" /> -->
<%-- </form:form> --%>

<p><br />
<a href="/spring-security-ldap/danny/auth/logout">Logout</a>
</p>
</body>
</html>