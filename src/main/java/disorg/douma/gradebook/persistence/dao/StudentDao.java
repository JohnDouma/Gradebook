package disorg.douma.gradebook.persistence.dao;

import disorg.douma.gradebook.persistence.dto.StudentDto;

import java.util.List;

public interface StudentDao {
    StudentDto createStudent(StudentDto dto);
    StudentDto getStudent(Long studentId);
    List<StudentDto> getAllStudents();
}
