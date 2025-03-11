package disorg.douma.gradebook.persistence.dao;

import disorg.douma.gradebook.persistence.dto.StudentDto;

import java.util.List;

public interface StudentDao {
    StudentDto createStudent(StudentDto dto);
    StudentDto getStudent(Long studentId);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long id, StudentDto student);
    void deleteStudent(Long id);
}
