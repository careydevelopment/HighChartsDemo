function employeeSelect() {
	//display the spinner
	$('#ajaxLoader').show();
	
	//first, let's get rid of the default "SELECT" option if it exists
	var defaultOption = $("#employeeIdSelect option[value='default']");
	if (defaultOption) defaultOption.remove();
	
	//get the selected id
	var employeeId = $('#employeeIdSelect').val();
	
	//get the url for the ajax call
	var url = "./employee/" + employeeId;
	
	//do the ajax call
	$.get(url, populateEmployeeInfo);	
}

//This is the function we run when we get back a response
//from the ajax call
function populateEmployeeInfo(data) {
	var status = data.responseStatus;
	
	//check the response to make sure it's ok
	if (status == "Ok") {
		var response = data.response;
		
		//get the JSON data
		var department = response.department;
		var employeeId = response.employeeId;
		var firstName = response.firstName;
		var lastName = response.lastName;
		var hoursPerWeek = response.hoursPerWeek;
		var imageFile = './images/' + response.imageFile;
		
		//set the profile badge values
		$('#employeePic').attr("src", imageFile);
		$('#employeeName').html(firstName + ' ' + lastName);
		$('#employeeDepartment').html(department);
		
		//set the input field values
		$('#employeeFirstName').val(firstName);
		$('#employeeLastName').val(lastName);
		$('#employeeDept').val(department);
		$('#employeeId').val(employeeId);
		$('#employeeHours').val(hoursPerWeek);
		
		//show the hidden elements
		$('#profileRow').css('visibility','visible');
	}
	
	//hide the spinner again
	$('#ajaxLoader').hide();
}