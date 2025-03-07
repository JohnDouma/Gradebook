package disorg.douma.gradebook.persistence.repository;

import disorg.douma.gradebook.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
