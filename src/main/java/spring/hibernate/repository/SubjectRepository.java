package spring.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hibernate.dto.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
