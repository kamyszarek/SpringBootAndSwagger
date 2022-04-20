package pl.arkadiusz.mySpringProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.mySpringProject1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
