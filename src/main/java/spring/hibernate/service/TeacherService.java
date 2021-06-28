package spring.hibernate.service;

import spring.hibernate.dto.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    Teacher getTeacherById(Long id);
}
