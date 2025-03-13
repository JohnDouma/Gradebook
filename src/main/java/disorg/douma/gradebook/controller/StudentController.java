package disorg.douma.gradebook.controller;

import disorg.douma.gradebook.persistence.dao.StudentDao;
import disorg.douma.gradebook.persistence.dto.StudentDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        StudentDto newDto = studentService.getStudent(id);
        return ResponseEntity.ok(newDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto updatedStudent) {
        StudentDto newStudent = studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(newStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student with id " + id + " successfully deleted");
    }
}
