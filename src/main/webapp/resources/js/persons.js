//Get all persons via ajax
function showPersons() {
	$.getJSON("/spring-security-ldap/danny/person/personsajax", 
		function(persons) {
		//Build table and append to page, show number of persons found
		if(persons.length != 0)
    		 {
				personTable(persons);
				$("#results").html(persons.length + " persons found!");
    		 }
    	 else{
    		 $("#results").html("No results found!");
    	 }
	});
}
//Search for persons by first name via ajax
function searchPersons() {
	$.getJSON("/spring-security-ldap/danny/person/personsearchajax",
     {  personsID:  $("#searchBox").val()}, 
     function(persons) {
    	 //Build table and append to page, display search result
    	 if(persons.length != 0)
    	 {
			personTable(persons);
			$("#results").html(persons.length + " results found!");
		 }
    	 else
    	 {
    		 $("#results").html("No results found!");
    	 }
	});
}

function personTable(persons){
	//Begin table
	var tableString = "<table style='border: 1px solid; width: 500px; text-align:center'>"
		+"<thead style='background:#FF0'>"
		+"<tr>"
			+"<th>First Name</th>"
			+"<th>Last Name</th>"
			+"<th>Money</th>"
		+"</tr>"
	+"</thead>"
	+"<tbody>";
		
	//Table rows, by looping through JSON results
		$.each(persons, function(){
			tableString = tableString + "<tr>" 
					+ "<td>" + this.firstName + "</td>"
					+ "<td>" + this.lastName + "</td>"
					+ "<td>" + this.money + "</td>"
					+ "<tr>";
		});
	//End table
		tableString = tableString + "</tbody></table><br />";

		$("#persondata").append(tableString);
}