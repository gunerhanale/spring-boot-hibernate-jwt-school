package spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.hibernate.dto.Student;
import spring.hibernate.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    void createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

}
