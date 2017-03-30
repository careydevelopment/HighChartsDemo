function employeeSelect() {
	//get the selected id
	var employeeId = $('#employeeIdSelect').val();
	
	//get the url for the ajax call
	var url = "./employee/" + employeeId;
	
	//do the ajax call
	$.get(url, populateEmployeeInfo);
	
	$('#profileRow').show();
}

//This is the function we run when we get back a response
//from the ajax call
function populateEmployeeInfo(data) {
	alert("here");
	
	var status = data.responseStatus;
	
	//check the response to make sure it's ok;
	if (status == "Ok") {
		var response = data.response;
		
		var department = response.department;
		var employeeId = response.employeeId;
		var firstName = response.firstName;
		var lastName = response.lastName;
		var hoursPerWeek = response.hoursPerWeek;
		var imageFile = response.imageFile;
		
		alert(department);
	}
}