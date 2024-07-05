package ir.ac.kntu.notificationmanagement.strategy;

import ir.ac.kntu.notificationmanagement.model.Notification;

public interface NotificationStrategy<T extends Notification> {
    void send(T notification);
}
