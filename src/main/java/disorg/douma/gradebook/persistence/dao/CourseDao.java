package disorg.douma.gradebook.persistence.dao;

import disorg.douma.gradebook.exception.ResourceNotFoundException;
import disorg.douma.gradebook.persistence.dto.CourseDto;
import disorg.douma.gradebook.persistence.entity.Course;
import disorg.douma.gradebook.persistence.repository.CourseRepository;
import disorg.douma.gradebook.persistence.util.CourseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseDao {
    private CourseRepository repository;

    public CourseDto createCourse(CourseDto courseDto) {
        Course course = CourseMapper.toCourse(courseDto);
        Course newCourse = repository.save(course);
        return CourseMapper.toCourseDto(newCourse);
    }

    public List<CourseDto> getAllCourses() {
        List<Course> courses = repository.findAll();
        List<CourseDto> dtos = courses.stream().map(course -> CourseMapper.toCourseDto(course)).toList();
        return dtos;
    }

    public CourseDto getCourseById(Long id) {
        Course course = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return CourseMapper.toCourseDto(course);
    }

    public CourseDto updateCourse(Long id, CourseDto updatedCourse) {
        Course course = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        course.setCourseId(id);
        course.setCourseName(updatedCourse.getCourseName());
        course.setCredits(updatedCourse.getCredits());
        Course newCourse = repository.save(course);

        return CourseMapper.toCourseDto(newCourse);
    }

    public void deleteCourse(Long id) {
        Course course = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        repository.deleteById(id);
    }
}
