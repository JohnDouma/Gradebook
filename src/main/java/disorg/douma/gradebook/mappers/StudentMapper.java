package disorg.douma.gradebook.mappers;

import disorg.douma.gradebook.dtos.StudentDto;
import disorg.douma.gradebook.entities.Student;

/**
 * Contains static methods to convert student entity object to and from student dtos.
 */
public class StudentMapper {
    /**
     * Converts a <code>Student</code> into a <code>StudentDto</code>
     * @param student Entity representing a student
     * @return student data transfer object
     */
    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }

    /**
     * Converts a <code>StudentDto</code> into a <code>Student</code>
     * @param dto data transfer object for a student
     * @return student entity
     */
    public static Student toStudent(StudentDto dto) {
        return new Student(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }
}
