package by.dvn.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import by.dvn.DAO.EmployeeDAO;
import by.dvn.DAO.EmployeeException;
import by.dvn.source.Employee;

@Service
public class ServiceProject {

	// --------------------------
	//			CREATE
	// --------------------------
	public static Employee createNoteInBD(DataSource dataSource, Employee emp) throws EmployeeException {
		new EmployeeDAO(dataSource).createEmployee(emp);
		return new EmployeeDAO(dataSource).getLastEmployee();
	}

	// --------------------------
	//			READ
	// --------------------------
	public static Employee readNoteInBD(DataSource dataSource, Integer id) throws EmployeeException {
		return new EmployeeDAO(dataSource).getEmployee(id);
	}

	public static Employee readNoteInBD(DataSource dataSource, Employee emp) throws EmployeeException {
		return new EmployeeDAO(dataSource).getEmployee(emp);
	}
	
	public static List<Employee> readAllNoteinBD(DataSource dataSource) {
		return new EmployeeDAO(dataSource).getEmployeeList();
	}

	// --------------------------
	//			UPDATE
	// --------------------------
	public static Employee updateNoteInBD(DataSource dataSource, Integer id, Employee emp) throws EmployeeException {
		new EmployeeDAO(dataSource).updateEmployee(id, emp);
		return new EmployeeDAO(dataSource).getEmployee(id);
	}

	public static Employee updateNoteInBD(DataSource dataSource, Employee empOld, Employee empNew) throws EmployeeException {
		new EmployeeDAO(dataSource).updateEmployee(empOld, empNew);
		return new EmployeeDAO(dataSource).getEmployee(empNew);
	}

	// --------------------------
	//			DELETE
	// --------------------------
	public static void deleteNoteInBD(DataSource dataSource, Integer id) throws EmployeeException {
		new EmployeeDAO(dataSource).removeEmployee(id);
	}

	public static void deleteNoteInBD(DataSource dataSource, Employee emp) throws EmployeeException {
		new EmployeeDAO(dataSource).removeEmployee(emp);
	}
	
}
