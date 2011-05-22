<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<script type="text/javascript" src="/../../spring-security-ldap/resources/js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="/../../spring-security-ldap/resources/js/persons.js"></script>

<title>Spring MVC Project - jQuery Integration</title>
 
</head>
<body>
 
<h3>Spring MVC Project - jQuery Integration</h3>
<h4>AJAX version</h4>
 <a href="/spring-security-ldap/danny/person/persons">Back</a>

<p>
Demo 1 - Get all persons via jquery AJAX<br />
<input type="submit" value="Get Persons" onclick="showPersons()" /> 
</p>

<p>
Demo2 - Search for persons by first name via ajax (Requires admin access)<br />
<input id="searchBox" type="text" size="15">
<input type="submit" value="Search" onclick="searchPersons()" /> 
</p>

<div id='results'></div><br />
<div id='persondata'></div>

</body>
</html>