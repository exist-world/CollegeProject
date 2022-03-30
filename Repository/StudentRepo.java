package College.SpringBootProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import College.SpringBootProject.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

}
