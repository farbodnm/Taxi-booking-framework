package com.taxi.notification.strategy;

import com.taxi.framework.notification.strategy.NotificationStrategy;
import com.taxi.framework.notification.model.*;

public class NotificationFactory {

    public static <T extends Notification> NotificationStrategy<T> createNotificationStrategy(NotificationType type) {
        return switch (type) {
            case SMS -> (NotificationStrategy<T>) new SmsNotificationStrategy();
            case EMAIL -> (NotificationStrategy<T>) new EmailNotificationStrategy();
            case PUSH -> (NotificationStrategy<T>) new PushNotificationStrategy();
        };
    }
}
