package by.dvn.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import by.dvn.source.Employee;
import by.dvn.source.Sex;

public class EmployeeMapper implements RowMapper<Employee> {
	public static final String BASE_SQL //
		= "SELECT * FROM employee em";

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer id = rs.getInt("employee_id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		Integer departmentId = rs.getInt("department_id");
		String jobTitle = rs.getString("job_title");
		Sex gender = sexFromString(rs.getString("gender"));
		Date dayOfBirth = rs.getDate("date_of_birth");
		
		return new Employee(id, firstName, lastName, departmentId, jobTitle, gender, dayOfBirth);
	}
	
	private Sex sexFromString(String str) {
		return str.toUpperCase().equals("MALE") ? Sex.MALE : Sex.FEMALE;
	}
}
