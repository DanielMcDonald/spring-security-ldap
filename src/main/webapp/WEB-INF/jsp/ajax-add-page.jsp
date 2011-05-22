<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.pack.js"></script>

<script type="text/javascript">
 
function add() {
  $.getJSON("/danny/main/add",
     {  inputNumber1:  $("#inputNumber1").val(),
        inputNumber2:  $("#inputNumber2").val() },
      function(data){
       // data contains the result
       // Assign result to the sum id
       $("#sum").replaceWith('<span id="sum">'+ data + '</span>');
     });
}

function showPersons() {
	$.getJSON("account/" + $("#assignedId").val(), function(account) {
		$("#confirmedName").val(account.name);
		$("#confirmedBalance").val(account.balance);
		$("#confirmedEquityAllocation").val(account.equityAllocation);
		$("#confirmedRenewalDate").val(account.renewalDate);
	});	
 
</script>

 <title>Spring MVC - jQuery Integration Tutorial</title>
 
</head>
<body>
 
<h3>Spring MVC - jQuery Integration Tutorial</h3>
<h4>AJAX version</h4>
 
Demo 1
<div style="border: 1px solid #ccc; width: 250px;">
 Add Two Numbers:
 
 <input id="inputNumber1" name="inputNumber1" type="text" size="5"> +
 <input id="inputNumber2" name="inputNumber2" type="text" size="5">
 <input type="submit" value="Add" onclick="add()" />
 
 Sum: <span id="sum">(Result will be shown here)</span>
</div>
 
 

</body>
</html>