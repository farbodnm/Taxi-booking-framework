package ir.ac.kntu.notificationmanagement.configuration;

import ir.ac.kntu.notificationmanagement.model.EmailNotification;
import ir.ac.kntu.notificationmanagement.model.NotificationType;
import ir.ac.kntu.notificationmanagement.model.PushNotification;
import ir.ac.kntu.notificationmanagement.model.SmsNotification;
import ir.ac.kntu.notificationmanagement.strategy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationStrategyConfiguration {

    @Bean
    public NotificationStrategy<SmsNotification> smsNotificationStrategy() {
        return NotificationFactory.createNotificationStrategy(NotificationType.SMS);
    }

    @Bean
    public NotificationStrategy<EmailNotification> emailNotificationStrategy() {
        return NotificationFactory.createNotificationStrategy(NotificationType.EMAIL);
    }

    @Bean
    public NotificationStrategy<PushNotification> pushNotificationStrategy() {
        return NotificationFactory.createNotificationStrategy(NotificationType.PUSH);
    }
}
