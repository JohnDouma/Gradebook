package disorg.douma.gradebook.controllers;

import disorg.douma.gradebook.dtos.StudentDto;
import disorg.douma.gradebook.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto dto) {
        StudentDto newDto = studentService.createStudent(dto);
        return new ResponseEntity<>(newDto, HttpStatus.CREATED);
    }
}
