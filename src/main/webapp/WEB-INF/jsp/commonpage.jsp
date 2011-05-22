<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.pack.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	add();
});

function add() {
	  $.post("/spring-security-ldap/danny/main/common",
	     {  inputNumber1:  $("#inputNumber1").val(),
	        inputNumber2:  $("#inputNumber2").val() },
	      function(data){
	       // data contains the result
	       // Assign result to the sum id
	       $("#sum").replaceWith('<span id="sum">'+ data + '</span>');
	     });
	}
 
</script>

</head>
<body>
<h1>Common Page</h1>
<p>Everyone has access to this page.</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ac velit et ante 
laoreet eleifend. Donec vitae augue nec sem condimentum varius.</p>
<p><a href="/spring-security-ldap/danny/person/persons">Persons</a></p>
<p><a href="/spring-security-ldap/danny/main/admin">Admin</a></p>
<p><a href="/spring-security-ldap/danny/auth/logout">Logout</a></p>

<p>
<input id="inputNumber1" name="inputNumber1" type="text" size="5"> +
 <input id="inputNumber2" name="inputNumber2" type="text" size="5">
 <input type="submit" value="Add" onclick="add()" /> 
</p>
<div id="sum">
<p>Answer</p>
</div>
</body>
</html>