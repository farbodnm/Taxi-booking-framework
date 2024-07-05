package ir.ac.kntu.notificationmanagement.strategy;

import ir.ac.kntu.notificationmanagement.model.EmailNotification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotificationStrategy implements NotificationStrategy<EmailNotification> {
    @Override
    public void send(EmailNotification notification) {
        log.info("""
                Sending Email:
                User Id: %d
                To: %s
                Subject: %s
                Body: %s
                """
                .formatted(
                        notification.getUser().getId(),
                        notification.getUser().getEmail(),
                        notification.getSubject(),
                        notification.getMessage()));
    }
}
