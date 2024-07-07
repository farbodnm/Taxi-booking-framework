package ir.ac.kntu.notificationmanagement.configuration;

import ir.ac.kntu.notificationmanagement.model.EmailNotification;
import ir.ac.kntu.notificationmanagement.model.PushNotification;
import ir.ac.kntu.notificationmanagement.model.SmsNotification;
import ir.ac.kntu.notificationmanagement.strategy.EmailNotificationStrategy;
import ir.ac.kntu.notificationmanagement.strategy.NotificationStrategy;
import ir.ac.kntu.notificationmanagement.strategy.PushNotificationStrategy;
import ir.ac.kntu.notificationmanagement.strategy.SmsNotificationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationStrategyConfiguration {

    @Bean
    public NotificationStrategy<SmsNotification> smsNotificationStrategy() {
        return new SmsNotificationStrategy();
    }

    @Bean
    public NotificationStrategy<EmailNotification> emailNotificationStrategy() {
        return new EmailNotificationStrategy();
    }

    @Bean
    public NotificationStrategy<PushNotification> pushNotificationStrategy() {
        return new PushNotificationStrategy();
    }
}
