package disorg.douma.gradebook.controller;

import disorg.douma.gradebook.persistence.dto.StudentDto;
import disorg.douma.gradebook.persistence.dao.StudentDao;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentDao studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto dto) {
        StudentDto newDto = studentService.createStudent(dto);
        return new ResponseEntity<>(newDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        StudentDto newDto = studentService.getStudent(id);
        return ResponseEntity.ok(newDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
