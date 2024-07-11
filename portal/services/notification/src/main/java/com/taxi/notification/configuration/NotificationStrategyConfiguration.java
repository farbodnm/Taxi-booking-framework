package com.taxi.notification.configuration;

import com.taxi.framework.notification.configuration.INotificationStrategyConfiguration;
import com.taxi.framework.notification.model.*;
import com.taxi.framework.notification.strategy.NotificationStrategy;
import com.taxi.notification.strategy.NotificationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationStrategyConfiguration implements INotificationStrategyConfiguration {

    @Bean
    @Override
    public NotificationStrategy<SmsNotification> smsNotificationStrategy() {
        return NotificationFactory.createNotificationStrategy(NotificationType.SMS);
    }

    @Bean
    @Override
    public NotificationStrategy<EmailNotification> emailNotificationStrategy() {
        return NotificationFactory.createNotificationStrategy(NotificationType.EMAIL);
    }

    @Bean
    @Override
    public NotificationStrategy<PushNotification> pushNotificationStrategy() {
        return NotificationFactory.createNotificationStrategy(NotificationType.PUSH);
    }
}
