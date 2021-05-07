package spring.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hibernate.dto.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
