package com.taxi.notification.strategy;

import com.taxi.framework.notification.model.*;
import com.taxi.framework.notification.strategy.NotificationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsNotificationStrategy implements NotificationStrategy<SmsNotification> {
    @Override
    public void send(SmsNotification notification) {
        log.info("""
                Sending SMS:
                User Id: %d
                Recipient: %s
                Message: %s
                """
                .formatted(
                        notification.getUser().getId(),
                        notification.getUser().getPhoneNumber(),
                        notification.getMessage()));
    }
}
