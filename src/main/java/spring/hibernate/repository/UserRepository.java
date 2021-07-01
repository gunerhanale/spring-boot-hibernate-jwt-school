package spring.hibernate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.hibernate.dto.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);
}
