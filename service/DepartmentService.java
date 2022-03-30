package College.SpringBootProject.service;

import java.util.List;

import College.SpringBootProject.entities.Department;


public interface DepartmentService {
	
	Department saveDepartment(Department department);
	List<Department> getAllDepartments();
	Department getDepartmentById(long id);
	Department updateDepartment(Department department,long id);
	void deleteDepartment(long id);

}
