package disorg.douma.gradebook.persistence.repository;

import disorg.douma.gradebook.persistence.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
