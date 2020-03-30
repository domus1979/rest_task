package by.dvn.rest_task;

//import java.util.GregorianCalendar;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.annotation.AnnotaionConfigApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import by.dvn.DAO.EmployeeException;
//import by.dvn.service.ServiceProject;

@SpringBootApplication
public class RestTaskApplication {

	public static void main(String[] args) throws EmployeeException {
		SpringApplication.run(RestTaskApplication.class, args);
//		ApplicationContext context = SpringApplication.run(RestTaskApplication.class, args);
//
//		DataSource dS = (DataSource) context.getBean("dataSource");

		
//		EmployeeDAO empDao = new EmployeeDAO(dS);
		
//		ServiceProject.createNoteInBD(empDao, new Employee(1, "Ivan", "Ivanov", 1, "Boss", Sex.MALE, new GregorianCalendar(1980, 2 , 25).getTime()));
//		ServiceProject.createNoteInBD(dS, new Employee(1, "Ivan", "Ivanov", 1, "Boss", Sex.MALE, new GregorianCalendar(1980, 2 , 25).getTime()));
//		ServiceProject.createNoteInBD(dS, new Employee(2, "Igor", "Stepanov", 1, "Ingeneer", Sex.MALE, new GregorianCalendar(1982, 9 , 10).getTime()));
		
		
		
//		List<Employee> listEmp = ServiceProject.readAllNoteinBD(dS);
//		
//		System.out.println("This is list of notes from employee table:");
//		for(Employee employee : listEmp) {
//			System.out.println(employee.toString());
//		}

		
		
//		Employee emp = ServiceProject.readNoteInBD(dS, 5);
//		emp.setLastName("Ivanova");
//		emp.setFirstName("Irina");
//		emp.setGender(Sex.FEMALE);
//		ServiceProject.updateNoteInBD(dS, 5, emp);
	}

}
