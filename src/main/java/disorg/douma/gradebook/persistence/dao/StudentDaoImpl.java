package disorg.douma.gradebook.persistence.dao;

import disorg.douma.gradebook.exception.ResourceNotFoundException;
import disorg.douma.gradebook.persistence.dto.StudentDto;
import disorg.douma.gradebook.persistence.entity.Student;
import disorg.douma.gradebook.persistence.repository.StudentRepository;
import disorg.douma.gradebook.persistence.util.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public StudentDto getStudent(Long studentId) {
        Student student = repository.findById(studentId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("The student with id equal to " + studentId + " does not exist."));
        return StudentMapper.toStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = repository.findAll();
        List<StudentDto> retlist = students.stream().map((student) ->
            StudentMapper.toStudentDto(student)).collect(Collectors.toList());

        return retlist;
    }
}
