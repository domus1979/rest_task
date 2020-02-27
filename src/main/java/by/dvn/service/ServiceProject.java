package by.dvn.service;

//import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.dvn.DAO.EmployeeDAO;
import by.dvn.DAO.EmployeeException;
import by.dvn.source.Employee;

@Service
public class ServiceProject {

//	@Autowired
//	private EmployeeDAO empDao;

//	@Autowired
	public static Employee createNoteInBD(DataSource dataSource, Employee emp) throws EmployeeException {
//	public static void createNoteInBD(EmployeeDAO empDao, Employee emp) throws EmployeeException {
		System.out.println("Create note for employee: " + emp.toString());
//		empDao.createEmployee(emp);
		new EmployeeDAO(dataSource).createEmployee(emp);
		
		return new EmployeeDAO(dataSource).getLastEmployee();
	}

//	public Employee readNoteInBD(EmployeeDAO empDao, Integer id) throws EmployeeException {
	public static Employee readNoteInBD(DataSource dataSource, Integer id) throws EmployeeException {
//		return empDao.getEmployee(id);
		return new EmployeeDAO(dataSource).getEmployee(id);
	}
	
//	public static List<Employee> readAllNoteinBD(EmployeeDAO empDao) {
	public static List<Employee> readAllNoteinBD(DataSource dataSource) {
//		return empDao.getEmployeeList();
		return new EmployeeDAO(dataSource).getEmployeeList();
	}

//	public static void updateNoteInBD(EmployeeDAO empDao, Integer id, Employee emp) throws EmployeeException {
	public static Employee updateNoteInBD(DataSource dataSource, Integer id, Employee emp) throws EmployeeException {
		System.out.println("Update note for employee: " + emp.toString());
//		empDao.updateEmployee(id, emp);
		new EmployeeDAO(dataSource).updateEmployee(id, emp);
		return new EmployeeDAO(dataSource).getEmployee(id);
	}

//	public static void deleteNoteInBD(EmployeeDAO empDao, Integer id) throws EmployeeException {
	public static void deleteNoteInBD(DataSource dataSource, Integer id) throws EmployeeException {
		Employee emp = new EmployeeDAO(dataSource).getEmployee(id);
		System.out.println("Delete note for employee: " + emp.toString());
		
		new EmployeeDAO(dataSource).removeEmployee(id);
	}
	
	
}
