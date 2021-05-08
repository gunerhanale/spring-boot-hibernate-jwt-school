package spring.hibernate.service;

import spring.hibernate.dto.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    void deleteStudent(Student student);
    Student getStudentById(Long id);
}
