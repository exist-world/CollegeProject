package College.SpringBootProject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dept_id;
	private String dept_name;
	private String dept_email;
	private String dept_position;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,targetEntity=Department.class,mappedBy="STUDENT")
	private List<Department> departments= new ArrayList<>();
	
	
	public Department() {
		super();
		
	}
	public Department(long dept_id, String dept_name, String dept_email, String dept_position) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_email = dept_email;
		this.dept_position=dept_position;
	}
	public long getDept_id() {
		return dept_id;
	}
	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_email() {
		return dept_email;
	}
	public void setDept_email(String dept_email) {
		this.dept_email = dept_email;
	}
	public String getDept_position() {
		return dept_position;
	}
	public void setDept_position(String dept_position) {
		this.dept_position = dept_position;
	}
	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", dept_email=" + dept_email
				+ ", dept_position=" + dept_position + "]";
	}
	
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	
	
	

}
