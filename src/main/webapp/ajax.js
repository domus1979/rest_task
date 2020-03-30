// Processing request web
$( document ).ready(function() {
    $("#readNote").click(
		function(){
			readNote('result_form', 'ajax_form', 'http://localhost:8080/employee');
			return false; 
		}
	);
    $("#readAllNotes").click(
   		function(){
   			readAllNotes('result_form', 'ajax_form', 'http://localhost:8080/employee');
   			return false; 
   		}
	);
    $("#addNote").click(
       		function(){
       			addNote('result_form', 'ajax_form', 'http://localhost:8080/employee');
       			return false; 
       		}
    	);
    $("#editNote").click(
       		function(){
       			editNote('result_form', 'ajax_form', 'http://localhost:8080/employee');
       			return false; 
       		}
    	);
    $("#deleteNote").click(
       		function(){
       			deleteNote('result_form', 'ajax_form', 'http://localhost:8080/employee');
       			return false; 
       		}
    	);
});
 
function readNote(result_form, ajax_form, url) {
	$.ajax({
		url:			url, //url страницы с API
		type:			"GET", //метод отправки
		crossDomain:		true,
		dataType:		"json", //формат данных
		data:			$("#"+ajax_form).serialize(),  // Сеарилизуем объект
		
		success: function(response) { //Данные отправлены успешно
			var text = '<table align = "center" id = "employee_tab"><tr><td> Номер </td><td> Фамилия </td><td> Имя </td><td> Номер отдела </td><td> Должность </td><td> Пол </td><td> Дата рождения </td></tr>';
			text = text + '<tr><td>' + response.id +'</td><td>' + response.lastName + '</td><td>' + response.firstName + '</td><td>' + response.departmentId + '</td><td>' + response.jobTitle + '</td><td>' + response.gender + '</td><td>' + response.dateOfBirth  + '</td></tr>';
			text = text + '</table>';
			$('#result_form').html(text);
		},
		error: function(response) { // Данные не отправлены
			$('#result_form').html('Ошибка. Данные не прочитаны.');
		}
	});
}
function readAllNotes(result_form, ajax_form, url) {
	$.ajax({
		url:			url, //url страницы с API
		type:			"GET", //метод отправки
		crossDomain:		true,
		dataType:		"json", //формат данных
		
		success: function(response) { //Данные отправлены успешно
			var text = '<table align = "center" id = "employee_tab"><tr><td> Номер </td><td> Фамилия </td><td> Имя </td><td> Номер отдела </td><td> Должность </td><td> Пол </td><td> Дата рождения </td></tr>';
			for (i = 0; i < response.length; i++) {
				text = text + '<tr><td>' + response[i].id +'</td><td>' + response[i].lastName + '</td><td>' + response[i].firstName + '</td><td>' + response[i].departmentId + '</td><td>' + response[i].jobTitle + '</td><td>' + response[i].gender + '</td><td>' + response[i].dateOfBirth  + '</td></tr>';
			};
			text = text + '</table>';
			$('#result_form').html(text);
		},
		error: function(response) { // Данные не отправлены
			$('#result_form').html('Ошибка. Данные не прочитаны.');
		}
	});
	
}
function addNote(result_form, ajax_form, url) {
//	$.ajaxSetup({
//		beforeSend: function(jqXHR, settings) {
//			console.log(settings.data);
//		}
//	});
	$.ajax({
		url:			url, //url страницы с API
		type:			"POST", //метод отправки
		contentType:		"application/json",
		crossDomain:		true,
		traditional:		true,
		dataType:		"json", //формат данных
		data:			JSON.stringify($("#"+ajax_form).serializeJSON()),  // Сеарилизуем объект
		processData:		false,

		success: function(response) { //Данные отправлены успешно
			$('#result_form').html('Запись успешно добавлена.');
		},
		error: function(response) { // Данные не отправлены
			$('#result_form').html('Ошибка. Данные не добавлены.');
		}
	});
}
function editNote(result_form, ajax_form, url) {
	$.ajax({
		url:			url, //url страницы с API
		type:			"PUT", //метод отправки
		contentType:		"application/json",
		crossDomain:		true,
		traditional:		true,
		dataType:		"json", //формат данных
		data:			JSON.stringify($("#"+ajax_form).serializeJSON()),  // Сеарилизуем объект
		processData:		false,
		
		success: function(response) { //Данные отправлены успешно
			$('#result_form').html('Запись изменена.');
		},
		error: function(response) { // Данные не отправлены
			$('#result_form').html('Ошибка. Данные не изменены.');
		}
	});
}
function deleteNote(result_form, ajax_form, url) {
//	$.ajaxSetup({
//		beforeSend: function(jqXHR, settings) {
//			console.log(settings.data);
//		}
//	});
	$.ajax({
		url:			url, //url страницы с API
		type:			"DELETE", //метод отправки
		crossDomain:		true,
		dataType:		"json", //формат данных
		data:			$("#"+ajax_form).serialize(),  // Сеарилизуем объект
		
		success: function(response) { //Данные отправлены успешно
			$('#result_form').html('Запись удалена.');
		},
		error: function(response) { // Данные не отправлены
			$('#result_form').html('Ошибка. Запись не удалена.');
		}
	});
}
