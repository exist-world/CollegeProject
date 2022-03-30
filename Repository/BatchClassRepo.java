package College.SpringBootProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import College.SpringBootProject.entities.BatchClass;

@Repository
public interface BatchClassRepo extends JpaRepository<BatchClass,Long>{

	

}
