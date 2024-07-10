package com.taxi.notification.strategy;

import com.taxi.framework.notification.strategy.NotificationStrategy;
import lombok.extern.slf4j.Slf4j;
import com.taxi.framework.notification.model.*;

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
