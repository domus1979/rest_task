package by.dvn.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.dvn.source.Employee;
import by.dvn.source.Sex;

@Repository
@Transactional
public class EmployeeDAO extends JdbcDaoSupport {
	
	@Autowired
	public EmployeeDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public boolean isEmployee(Integer id) {

		String sql = EmployeeMapper.BASE_SQL + " WHERE em.employee_id = ?";
		
		Object[] params = new Object[] {id};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			Employee emp = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return true;
		} catch (Exception e) {
			return false;
		}
//		if (emp == null) return false;
//		else return true;
		
	}

	public List<Employee> getEmployeeList() {
		String sql = EmployeeMapper.BASE_SQL;
		
		Object[] params = new Object[] {};
		EmployeeMapper mapper = new EmployeeMapper();
		List<Employee> list = this.getJdbcTemplate().query(sql, params, mapper);
 
		return list;
	}
	
	public Employee getEmployee(Integer id) {

		String sql = EmployeeMapper.BASE_SQL + " WHERE em.employee_id = ?";
		
		Object[] params = new Object[] {id};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			Employee emp = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return emp;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public Employee getLastEmployee() {

		String sql = EmployeeMapper.BASE_SQL + " ORDER BY em.employee_id DESK";
		
		Object[] params = new Object[] {};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			Employee emp = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return emp;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
    public void createEmployee(Employee emp) throws EmployeeException {
    	
//    	if (!this.isEmployee(emp.getId())) {
    		String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES (?,?,?,?,?,?)";
    		this.getJdbcTemplate().update(sql, emp.getFirstName(), emp.getLastName(), emp.getDepartmentId(), emp.getJobTitle(), (emp.getGender() == Sex.MALE ? "MALE" : "FEMALE"), emp.getDateOfBirth());

//    		String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender) VALUES (?,?,?,?,?)";
//    		this.getJdbcTemplate().update(sql, emp.getFirstName(), emp.getLastName(), emp.getDepartmentId(), emp.getJobTitle(), (emp.getGender() == Sex.MALE ? "MALE" : "FEMALE"));
//    	}
//    	else {
//    		throw new EmployeeException("Employee with id: " + emp.getId() + ", are exist! You don`t create new employee!");
//    	}
    }
	
	@Transactional(propagation = Propagation.MANDATORY)
    public void updateEmployee(Integer id, Employee emp) throws EmployeeException {
		
    	if (this.isEmployee(id)) {
    		
    		String sql = "UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = ?, date_of_birth = ? WHERE employee_id = ?";
    		Object[] params = new Object[] {emp.getFirstName(), emp.getLastName(), emp.getDepartmentId(), emp.getJobTitle(), (emp.getGender() == Sex.MALE ? "MALE" : "FEMALE"), emp.getDateOfBirth(), id};
    		this.getJdbcTemplate().update(sql, params);
    		
    	}
    	else {
    		throw new EmployeeException("Employee with id: " + emp.getId() + ", don`t exist!");
    	}
    }
	
	@Transactional(propagation = Propagation.MANDATORY)
    public void removeEmployee(Integer id) throws EmployeeException {
    	
    	if (this.isEmployee(id)) {
    		String sql = "DELETE FROM employee WHERE employee_id = ?";
    		this.getJdbcTemplate().update(sql, id);
    	}
    	else {
    		throw new EmployeeException("Employee with id: " + id + ", don`t exist!");
    	}
    }
	
}
