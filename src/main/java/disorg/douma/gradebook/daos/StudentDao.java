package disorg.douma.gradebook.daos;

import disorg.douma.gradebook.dtos.StudentDto;

public interface StudentDao {
    StudentDto createStudent(StudentDto dto);
}
