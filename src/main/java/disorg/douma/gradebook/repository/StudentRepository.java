package disorg.douma.gradebook.repository;

import disorg.douma.gradebook.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Long> {

}
