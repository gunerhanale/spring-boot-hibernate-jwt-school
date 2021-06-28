package spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Teacher> getTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping(value = "/{id}")
    public Teacher getTeacher(@PathVariable  Long id){
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher){
        try {
            teacherService.saveTeacher(teacher);
            return  ResponseEntity.status(201).body("Teacher is created successfully");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeTeacher(@PathVariable Long id){
        try{
            teacherService.deleteTeacher(id);
            return ResponseEntity.ok("Teacher is removed successfully");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher){
        try {
            teacherService.saveTeacher(teacher);
            return  ResponseEntity.ok("Teacher is updated successfully");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
