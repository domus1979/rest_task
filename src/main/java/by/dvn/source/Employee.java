package by.dvn.source;

import java.util.Date;

import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

//import javax.persistence.Table;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Entity
public class Employee {

	@Id
	@GeneratedValue
	@Column(value = "id")
	private Integer id;
	@Column(value = "firstName")
	private String firstName = "";
	@Column(value = "lastName")
	private String lastName = "";
	@Column(value = "departmentId")
	private Integer departmentId;
	@Column(value = "jobTitle")
	private String jobTitle = "";
	@Column(value = "gender")
	private Sex gender;
	@Column(value = "dateOfBirth")
	private Date dateOfBirth;
	
	// Constructor`s
	
	Employee() {}

	public Employee(Integer id, String firstName, String lastName, Integer departmentId, String jobTitle, Sex gender, Date dateOfBirth) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.jobTitle = jobTitle;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		
	}
	
	public Employee(Integer id, String firstName, String lastName, Integer departmentId, String jobTitle, String gender, Date dateOfBirth) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.jobTitle = jobTitle;
		this.gender = (gender.equals("FEMALE") == true) ? Sex.FEMALE : Sex.MALE;
		this.dateOfBirth = dateOfBirth;
		
	}

	public Employee(String firstName, String lastName, Integer departmentId, String jobTitle, Sex gender, Date dateOfBirth) {
		
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.jobTitle = jobTitle;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		
	}

	public Employee(String firstName, String lastName, Integer departmentId, String jobTitle, String gender, Date dateOfBirth) {
		
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.jobTitle = jobTitle;
		this.gender = (gender.equals("FEMALE") == true) ? Sex.FEMALE : Sex.MALE;
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

	// Redefine
	
	@Override
	public String toString() {
		return String.format(
			"Employee[id=%d, firstName='%s', lastName='%s', date_of_birth=%s]",
			this.id, this.firstName, this.lastName, this.dateOfBirth);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
