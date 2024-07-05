package ir.ac.kntu.notificationmanagement.repository;

import ir.ac.kntu.notificationmanagement.model.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepositoryRepository extends JpaRepository<EmailNotification, Long> {
}
