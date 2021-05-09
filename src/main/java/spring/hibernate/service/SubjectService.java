package spring.hibernate.service;

import spring.hibernate.dto.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject saveSubject(Subject subject);
    void deleteSubject(Subject subject);
    Subject getSubjectById(Long id);
}
