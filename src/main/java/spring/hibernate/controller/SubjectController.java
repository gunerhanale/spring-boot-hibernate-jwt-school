package spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.hibernate.dto.Student;
import spring.hibernate.dto.Subject;
import spring.hibernate.service.StudentService;
import spring.hibernate.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @GetMapping
    List<Subject> getSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    void createSubject(@RequestBody Subject subject){
        subjectService.saveSubject(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId){
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);
        subject.enrollStudent(student);
        return subjectService.saveSubject(subject);
    }

}
