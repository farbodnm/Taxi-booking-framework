package ir.ac.kntu.notificationmanagement.strategy;

import ir.ac.kntu.notificationmanagement.model.Notification;
import ir.ac.kntu.notificationmanagement.model.NotificationType;

public class NotificationFactory {

    public static <T extends Notification> NotificationStrategy<T> createNotificationStrategy(NotificationType type) {
        return switch (type) {
            case SMS -> (NotificationStrategy<T>) new SmsNotificationStrategy();
            case EMAIL -> (NotificationStrategy<T>) new EmailNotificationStrategy();
            case PUSH -> (NotificationStrategy<T>) new PushNotificationStrategy();
        };
    }
}
