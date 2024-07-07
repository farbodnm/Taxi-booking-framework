package ir.ac.kntu.notificationmanagement.repository;

import ir.ac.kntu.notificationmanagement.model.EmailNotification;
import ir.ac.kntu.notificationmanagement.model.SmsNotification;
import ir.ac.kntu.notificationmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {
    List<EmailNotification> findByUser(User user);
}
