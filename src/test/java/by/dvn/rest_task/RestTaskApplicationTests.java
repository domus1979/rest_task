package by.dvn.rest_task;

import java.util.GregorianCalendar;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import by.dvn.DAO.EmployeeException;
import by.dvn.service.ServiceProject;
import by.dvn.source.Employee;
import by.dvn.source.Sex;
import junit.framework.TestCase;


@SpringBootTest
class RestTaskApplicationTests extends TestCase{

	@Test
	void contextLoads() {
	}
	
	private Employee emp, empOld, empNew;
	@Autowired
	private DataSource dataSource;
	
//	@Before
//	public void init_Employee() {
//		emp = new Employee(1, "Ivanov", "Ivan", 1, "Boss", Sex.MALE, new GregorianCalendar(1980,3,25).getTime());
//		empOld = new Employee(3, "Pavel", "Petrov", 3, "Major Ingeneer", Sex.MALE, new GregorianCalendar(1985,5,20).getTime());
//		empNew = new Employee(1, "Petr", "Petrov", 1, "Major Ingeneer", Sex.MALE, new GregorianCalendar(1985,5,20).getTime());
//	}
	
//	@Test
//	public void readNoteInBD_Test() throws EmployeeException{
////		TestCase.assertNull(ServiceProject.readNoteInBD(dataSource, 15));
////		TestCase.assertNull("Ошибка в сравнении на пустое ", ServiceProject.readNoteInBD(dataSource, 2));
////		TestCase.assertNull("Ошибка в сравнении на пустое ", ServiceProject.readNoteInBD(dataSource, 1));
//		TestCase.assertEquals(ServiceProject.readNoteInBD(dataSource, 1), ServiceProject.readNoteInBD(dataSource, ServiceProject.readNoteInBD(dataSource, 1).getId()));
//		emp = new Employee(1, "Ivan", "Ivanov", 1, "Boss", Sex.MALE, new GregorianCalendar(1980,2,25).getTime());
//		TestCase.assertEquals(emp, ServiceProject.readNoteInBD(dataSource, emp));
//	}
//
//	@Test
//	public void readAllNoteInBD_Test() throws EmployeeException{
//		TestCase.assertNotNull(ServiceProject.readAllNoteinBD(dataSource));
//	}

//	@Test
//	public void createNoteInBD_Test() throws EmployeeException{
//		emp = new Employee(1, "Anna", "Kurnikova", 1, "Boss secretary", Sex.FEMALE, new GregorianCalendar(1999,4,9).getTime());
//		TestCase.assertNotNull("Ошибка в сравнении на пустое ", ServiceProject.createNoteInBD(dataSource, emp));
//	}
	
	@Test
	public void updateNoteInBD_Test() throws EmployeeException{
		empOld = new Employee(1, "Anna", "Kurnikova", 1, "Boss secretary", Sex.FEMALE, new GregorianCalendar(1999,4,10).getTime());
		empNew = new Employee(1, "Anna", "Kurnikova", 1, "Boss secretary", Sex.FEMALE, new GregorianCalendar(1999,4,22).getTime());
		TestCase.assertEquals(ServiceProject.updateNoteInBD(dataSource, empOld, empNew), empNew);
	}
	
//	@Test
//	public void deleteNoteInBD_Test() throws EmployeeException{
//		emp = new Employee(1, "Anna", "Kurnikova", 1, "Boss secretary", Sex.FEMALE, new GregorianCalendar(1999,4,10).getTime());
//		ServiceProject.deleteNoteInBD(dataSource, emp);
//		TestCase.assertNull(ServiceProject.readNoteInBD(dataSource, emp));
//	}
	

	@After
	public void kills_Employee() {
		emp = null;
	}
}
