package disorg.douma.gradebook.persistence.util;

import disorg.douma.gradebook.persistence.dto.CourseDto;
import disorg.douma.gradebook.persistence.entity.Course;

public class CourseMapper {
    public static CourseDto toCourseDto(Course course) {
        return new CourseDto(course.getCourseId(), course.getCourseName(), course.getCredits());
    }

    public static Course toCourse(CourseDto dto) {
        return new Course(dto.getCourseId(), dto.getCourseName(), dto.getCredits());
    }
}
