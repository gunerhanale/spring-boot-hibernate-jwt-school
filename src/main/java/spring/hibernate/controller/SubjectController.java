package spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.hibernate.dto.Student;
import spring.hibernate.dto.Subject;
import spring.hibernate.dto.Teacher;
import spring.hibernate.service.StudentService;
import spring.hibernate.service.SubjectService;
import spring.hibernate.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

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

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId){
        Subject subject = subjectService.getSubjectById(subjectId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        subject.assignTeacher(teacher);
        return subjectService.saveSubject(subject);
    }

}
