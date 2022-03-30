package College.SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import College.SpringBootProject.Repository.DepartmentRepo;
import College.SpringBootProject.entities.Department;

@Controller
public class DepartmentController {
	
	@Autowired
   private DepartmentRepo departmentRepo;
	
	public DepartmentController() 
	{
	}
	
	//getAll
	@GetMapping("/departments")
	public List<Department> getAllDepartments()
	{
		return departmentRepo.findAll();
	}
	
	//getById
	@GetMapping("/departments/{departmentId}")
	 public Department getDepartment(long departmentId)
	{
		 return  departmentRepo.getById(departmentId);
	 
	 }
	
	//add
	@PostMapping("/department")
	public Department addDepartment(Department department)
	{
		departmentRepo.save(department);
		return department;
	}
	
	//update
	@PutMapping("/employees")
	public Department updateDepartment(Department department) 
	{
		 departmentRepo.save(department);
		 return department;
	 }
	
	public void deleteDepartment(long parseLong) {
		Department entity=departmentRepo.getById(parseLong);
		departmentRepo.delete(entity);
	 }
	
}