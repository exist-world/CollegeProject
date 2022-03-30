package College.SpringBootProject.entities;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stu_id;
	private String stu_name;
	@Column(unique=true)
	private String stu_email;
	private String stu_phone;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		private Student student;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(long stu_id, String stu_name, String stu_email, String stu_phone) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_email = stu_email;
		this.stu_phone = stu_phone;
	}
	
	public long getStu_id() {
		return stu_id;
	}
	public void setStu_id(long stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}
	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_email=" + stu_email + ", stu_phone="
				+ stu_phone + "]";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	

}
