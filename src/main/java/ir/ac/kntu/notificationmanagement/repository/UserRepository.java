package ir.ac.kntu.notificationmanagement.repository;

import ir.ac.kntu.notificationmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
