package spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.hibernate.dto.Subject;
import spring.hibernate.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    List<Subject> getSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    void createSubject(@RequestBody Subject subject){
        subjectService.saveSubject(subject);
    }

}
