package by.dvn.rest_task;

import java.util.GregorianCalendar;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	
	private Employee emp;
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init_Employee() {
		emp = new Employee(1, "SOfija", "Koval", 3, "buhgalter", Sex.FEMALE, new GregorianCalendar(1990,0,7).getTime());
	}
	
	@After
	public void kills_Employee() {
		emp = null;
	}
	@Test
	public void readNoteInBD_Test() throws EmployeeException{
		//TestCase.assertNull(ServiceProject.readNoteInBD(dataSource, 15));
		TestCase.assertNull("Ошибка в сравнении на пустое ", ServiceProject.readNoteInBD(dataSource, 1));
	}
}
