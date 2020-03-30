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
	
	// ------------------------------
	//           SERVICE
	// ------------------------------
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
		
	}
	
	public boolean isEmployee(Employee emp) {
		String sql = EmployeeMapper.BASE_SQL + " WHERE em.first_name = ? and em.last_name = ? and em.date_of_birth = ?";
		
		Object[] params = new Object[] {emp.getFirstName(), emp.getLastName(), emp.getDateOfBirth()};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			Employee empFind = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	// ------------------------------
	//           READ
	// ------------------------------
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
	
	public Employee getEmployee(Employee emp) {

		String sql = EmployeeMapper.BASE_SQL + " WHERE em.first_name = ? and em.last_name = ? and em.date_of_birth = ?";
		
		Object[] params = new Object[] {emp.getFirstName(), emp.getLastName(), emp.getDateOfBirth()};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			Employee empFinded = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return empFinded;
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
	
	// ------------------------------
	//           CREATE
	// ------------------------------
	@Transactional(propagation = Propagation.MANDATORY)
    public void createEmployee(Employee emp) throws EmployeeException {
    	
    	if (!this.isEmployee(emp)) {
	    	String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES (?,?,?,?,?,?)";
	    	this.getJdbcTemplate().update(sql, emp.getFirstName(), emp.getLastName(), emp.getDepartmentId(), emp.getJobTitle(), (emp.getGender() == Sex.MALE ? "MALE" : "FEMALE"), emp.getDateOfBirth());
    	}
    	else {
    		throw new EmployeeException("Employee: " + emp.toString() + ", are exist! You don`t create new employee!");
    	}
    }
	
	// ------------------------------
	//           UPDATE
	// ------------------------------
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
    public void updateEmployee(Employee empOld, Employee empNew) throws EmployeeException {
		
    	if (this.isEmployee(empOld)) {
    		
    		String sql = "UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = ?, date_of_birth = ? WHERE first_name = ? and last_name = ? and date_of_birth = ?";
    		Object[] params = new Object[] {empNew.getFirstName(), empNew.getLastName(), empNew.getDepartmentId(), empNew.getJobTitle(), (empNew.getGender() == Sex.MALE ? "MALE" : "FEMALE"), empNew.getDateOfBirth(), empOld.getFirstName(), empOld.getLastName(), empOld.getDateOfBirth()};
    		this.getJdbcTemplate().update(sql, params);
    		
    	}
    	else {
    		throw new EmployeeException("Employee: " + empOld.toString() + ", don`t exist!");
    	}
    }

	// ------------------------------
	//           DELETE
	// ------------------------------
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

	@Transactional(propagation = Propagation.MANDATORY)
    public void removeEmployee(Employee emp) throws EmployeeException {
    	
    	if (this.isEmployee(emp)) {
    		String sql = "DELETE FROM employee WHERE first_name = ? and last_name = ? and date_of_birth = ?";
    		Object[] params = new Object[] {emp.getFirstName(), emp.getLastName(), emp.getDateOfBirth()};
    		this.getJdbcTemplate().update(sql, params);
    	}
    	else {
    		throw new EmployeeException("Employee: " + emp.toString() + ", don`t exist!");
    	}
    }
	
}
