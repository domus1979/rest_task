package by.dvn.rest_task;

//import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import by.dvn.DAO.EmployeeException;
import by.dvn.service.ServiceProject;
import by.dvn.source.Employee;

@RestController
@ControllerAdvice
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	@Autowired
	private DataSource dataSource;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> readAllEmployee(@RequestParam(value = "employee_id", defaultValue = "0") String employee_id) throws EmployeeException {
		Integer id = Integer.valueOf(employee_id);
		if (id == 0) {
			List<Employee> empList = ServiceProject.readAllNoteinBD(dataSource);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccessControlAllowOrigin("*");
			return new ResponseEntity<>(empList, httpHeaders, HttpStatus.OK);
		}
		else {
			Employee emp = ServiceProject.readNoteInBD(dataSource, id);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccessControlAllowOrigin("*");
			return new ResponseEntity<>(emp, httpHeaders, HttpStatus.OK); 
		}
	}

//	@RequestMapping(value = "/employee_id", method = RequestMethod.GET)
//	public ResponseEntity<?> readEmployee(@RequestParam(value = "employee_id", defaultValue = "0") String employee_id) throws EmployeeException {
//		Integer id = Integer.valueOf(employee_id);
//		Employee emp = ServiceProject.readNoteInBD(dataSource, id);
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setAccessControlAllowOrigin("*");
//		return new ResponseEntity<>(emp, httpHeaders, HttpStatus.OK); 
//	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) throws EmployeeException { //@ModelAttribute("ajax_form") 
		Employee createdEmployee = ServiceProject.createNoteInBD(dataSource, emp);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccessControlAllowOrigin("*");
		return new ResponseEntity<Employee>(createdEmployee, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) throws EmployeeException {
		
		Employee updatingEmployee = ServiceProject.updateNoteInBD(dataSource, emp.getId(), emp);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccessControlAllowOrigin("*");
		
		return new ResponseEntity<>(updatingEmployee, httpHeaders, HttpStatus.OK); 
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@RequestParam(value = "id", defaultValue = "0") String employee_id) throws EmployeeException {
		Integer id = Integer.valueOf(employee_id);
		ServiceProject.deleteNoteInBD(dataSource, id);
		
		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri());
		httpHeaders.setAccessControlAllowOrigin("*");
		
		return new ResponseEntity<String>("Note`s deleted.", httpHeaders, HttpStatus.GONE); 
	}
}
