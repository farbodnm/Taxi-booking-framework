package ir.ac.kntu.notificationmanagement.repository;

import ir.ac.kntu.notificationmanagement.model.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {
}
