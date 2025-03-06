package disorg.douma.gradebook.daos;

import disorg.douma.gradebook.dtos.StudentDto;
import disorg.douma.gradebook.entities.Student;
import disorg.douma.gradebook.mappers.StudentMapper;
import disorg.douma.gradebook.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentDaoImpl implements StudentDao {
    private StudentRepository repository;

    @Override
    public StudentDto createStudent(StudentDto dto) {
        Student student = StudentMapper.toStudent(dto);
        Student newStudent = repository.save(student);

        return StudentMapper.toStudentDto(newStudent);
    }
}
