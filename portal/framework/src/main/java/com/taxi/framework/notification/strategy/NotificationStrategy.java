package com.taxi.framework.notification.strategy;

import com.taxi.framework.notification.model.Notification;

public interface NotificationStrategy<T extends Notification> {
    void send(T notification);
}
