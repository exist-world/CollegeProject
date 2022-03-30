package College.SpringBootProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import College.SpringBootProject.entities.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long>{

}
