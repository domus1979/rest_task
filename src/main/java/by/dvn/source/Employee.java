package by.dvn.source;

import java.util.Date;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

//import javax.persistence.Table;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Entity
//@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue
//	@Column(name = "employee_id")
	private Integer id;
	
//	@Column(name = "first_name")
	private String firstName = "";
	
//	@Column(name = "last_name")
	private String lastName = "";
	
//	@Column(name = "department_id")
	private Integer departmentId;
	
//	@Column(name = "job_title")
	private String jobTitle = "";
	
//	@Column(name = "gender")
	private Sex gender;
	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	// Constructor`s
	
	Employee() {}

//	Employee(Integer id, String firstName, String lastName) {
//		
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.departmentId = 1;
//		this.jobTitle = "";
//		this.gender = Sex.MALE;
//		this.dateOfBirth = new Date(0);
//		
//	}
	
	public Employee(Integer id, String firstName, String lastName, Integer departmentId, String jobTitle, Sex gender, Date dateOfBirth) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.jobTitle = jobTitle;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		
	}
	
	// Geter`s
	
	public Integer getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public Sex getGender() {
		return this.gender;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	// Seter`s

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	void setGender(Sex gender) {
		this.gender = gender;
	}

	void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// Others
	
	@Override
	public String toString() {
		return String.format(
			"Employee[id=%d, firstName='%s', lastName='%s', gender=%s]",
			this.id, this.firstName, this.lastName, (this.gender == Sex.FEMALE ? "FEMALE" : "MALE"));
	}
}
