package disorg.douma.gradebook.mappers;

import disorg.douma.gradebook.dtos.StudentDto;
import disorg.douma.gradebook.entities.Student;

public class StudentMapper {
    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }

    public static Student toStudent(StudentDto dto) {
        return new Student(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }
}
