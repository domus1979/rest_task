package by.dvn.rest_task;

import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import by.dvn.DAO.EmployeeException;
import by.dvn.service.ServiceProject;
import by.dvn.source.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private DataSource dataSource;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> readAllEmployee() {
		return ServiceProject.readAllNoteinBD(dataSource);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee readEmployee(@PathVariable Integer id) throws EmployeeException {
		return ServiceProject.readNoteInBD(dataSource, id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) throws EmployeeException {
		
		Employee createdEmployee = ServiceProject.createNoteInBD(dataSource, emp);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdEmployee.getId()).toUri());
		
		return new ResponseEntity<>(createdEmployee, httpHeaders, HttpStatus.CREATED); 
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody Employee emp) throws EmployeeException {
		
		Employee updatingEmployee = ServiceProject.updateNoteInBD(dataSource, id, emp);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri());
		
		return new ResponseEntity<>(updatingEmployee, httpHeaders, HttpStatus.OK); 
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) throws EmployeeException {
		
		ServiceProject.deleteNoteInBD(dataSource, id);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri());
		
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK); 
	}
}
