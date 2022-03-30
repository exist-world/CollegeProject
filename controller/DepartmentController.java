package College.SpringBootProject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import College.SpringBootProject.entities.Department;
import College.SpringBootProject.service.DepartmentService;


@RestController
//@RequestMapping("/department")
public class DepartmentController {
	
	 @Autowired
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) 
	{
		super();
		this.departmentService = departmentService;
	}
	
   //create department
	@PostMapping("/department")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department)
	{
		return new ResponseEntity<Department>(departmentService.
					saveDepartment(department), HttpStatus.CREATED);
	}
		
   //get department ById
	@GetMapping("/department/{departmentId}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id")long departmentId)
	{
		return new ResponseEntity<Department>(departmentService.
					getDepartmentById(departmentId), HttpStatus.OK);
			
	}
		

    //update department
	@PutMapping("/department")
	public ResponseEntity<Department> updateDepartment
		(@PathVariable("id") long id,@RequestBody Department department)
	{
			return new ResponseEntity<Department>(departmentService.
					updateDepartment(department, id), HttpStatus.OK);
			
	}
		
	// delete department
	@DeleteMapping("/department/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id)
	{
			//delete department from DB
		departmentService.deleteDepartment(id);
		return new ResponseEntity<String>("Department deleted successfully!", HttpStatus.OK);
			
	}
	
	
	
	
	
	
	
	
	
//	@Autowired
//   private DepartmentRepo departmentRepo;
//	
//	public DepartmentController() 
//	{
//	}
//	
//	//getAll
//	@GetMapping("/departments")
//	public List<Department> getAllDepartments()
//	{
//		return departmentRepo.findAll();
//	}
//	
//	//getById
//	@GetMapping("/departments/{departmentId}")
//	 public Department getDepartment(long departmentId)
//	{
//		 return  departmentRepo.getById(departmentId);
//	 
//	 }
//	
//	//add
//	@PostMapping("/department")
//	public Department addDepartment(Department department)
//	{
//		departmentRepo.save(department);
//		return department;
//	}
//	
//	//update
//	@PutMapping("/employees")
//	public Department updateDepartment(Department department) 
//	{
//		 departmentRepo.save(department);
//		 return department;
//	 }
//	
//	@DeleteMapping
//	public void deleteDepartment(long parseLong) {
//		Department entity=departmentRepo.getById(parseLong);
//		departmentRepo.delete(entity);
//	 }
	
}