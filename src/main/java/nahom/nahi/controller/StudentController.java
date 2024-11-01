package nahom.nahi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nahom.nahi.Service.StudentService;
import nahom.nahi.dto.StudentDTO;
import nahom.nahi.entity.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Validated
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@Valid @RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id){
        return studentService.getStudent(id);
    }
}
