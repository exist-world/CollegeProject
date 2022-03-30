package College.SpringBootProject.entities;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="CLASS")
public class BatchClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cl_id;
	private String cl_name;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date cl_date;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,targetEntity=BatchClass.class,mappedBy="STUDENT")
	private List<BatchClass> classes= new ArrayList<>();
	
	public BatchClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BatchClass(long cl_id, String cl_name, Date cl_date) {
		super();
		this.cl_id = cl_id;
		this.cl_name = cl_name;
		this.cl_date = cl_date;
	}
	public long getCl_id() {
		return cl_id;
	}
	public void setCl_id(long cl_id) {
		this.cl_id = cl_id;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	public Date getCl_date() {
		return cl_date;
	}
	public void setCl_date(Date cl_date) {
		this.cl_date = cl_date;
	}
	
	
	public List<BatchClass> getClasses() {
		return classes;
	}
	public void setClasses(List<BatchClass> classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "Class [cl_id=" + cl_id + ", cl_name=" + cl_name + ", cl_date=" + cl_date + "]";
	}
	
	
}
