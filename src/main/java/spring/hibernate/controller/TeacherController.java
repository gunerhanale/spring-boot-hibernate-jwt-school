package spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.hibernate.dto.Teacher;
import spring.hibernate.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    List<Teacher> getTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping
    void createTeacher(@RequestBody Teacher teacher){
        teacherService.saveTeacher(teacher);
    }
}
