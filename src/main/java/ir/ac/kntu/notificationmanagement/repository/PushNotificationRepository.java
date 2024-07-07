package ir.ac.kntu.notificationmanagement.repository;

import ir.ac.kntu.notificationmanagement.model.PushNotification;
import ir.ac.kntu.notificationmanagement.model.SmsNotification;
import ir.ac.kntu.notificationmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PushNotificationRepository extends JpaRepository<PushNotification, Long> {
    List<PushNotification> findByUser(User user);
}
