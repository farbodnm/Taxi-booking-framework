package com.taxi.notification.strategy;

import com.taxi.framework.notification.model.*;
import com.taxi.framework.notification.strategy.NotificationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PushNotificationStrategy implements NotificationStrategy<PushNotification> {
    @Override
    public void send(PushNotification notification) {
        log.info("""
                Sending Push Notification:
                User Id: %d
                Push Token: %s
                Title: %s,
                Subtitle: %s,
                Message: %s
                """.formatted(
                notification.getUser().getId(),
                notification.getUser().getPushToken(),
                notification.getTitle(),
                notification.getSubtitle(),
                notification.getMessage()
        ));
    }
}
