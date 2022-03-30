package College.SpringBootProject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import College.SpringBootProject.Repository.DepartmentRepo;
import College.SpringBootProject.entities.Department;

import College.SpringBootProject.exception.ResourceNotFoundException;
import College.SpringBootProject.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepo departmentRepo;
	

	public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
		super();
		this.departmentRepo = departmentRepo;
	}

	
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
	
		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartmentById(long id) {

		Optional<Department>department=departmentRepo.findById(id);
		if(department.isPresent())
		{
			return department.get();
		}
		else
		{
			throw new ResourceNotFoundException("Student","id","id");
		}
	}

	@Override
	public Department updateDepartment(Department department, long id) {
		//check whether department with given Id is exist or Not
		
		Department existingDepartment=departmentRepo.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Department","id","id"));
				
				existingDepartment.setDept_name(department.getDept_name());
				existingDepartment.setDept_email(department.getDept_email());
				existingDepartment.setDept_position(department.getDept_position());
				
				//save existing department to DB
				departmentRepo.save(existingDepartment);
				return existingDepartment;
	}

	@Override
	public void deleteDepartment(long id) {
	////check whether department with given Id is exist or Not
		departmentRepo.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Department","id","id"));
		departmentRepo.deleteById(id);
		
	}

}
