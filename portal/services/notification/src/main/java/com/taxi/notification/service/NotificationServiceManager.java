package com.taxi.notification.service;

import com.taxi.framework.notification.model.NotificationType;
import com.taxi.framework.notification.service.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceManager {

    private final SmsNotificationService smsNotificationService;

    private final EmailNotificationService emailNotificationService;

    private final PushNotificationService pushNotificationService;

    public NotificationServiceManager(SmsNotificationService smsNotificationService, EmailNotificationService emailNotificationService, PushNotificationService pushNotificationService) {
        this.smsNotificationService = smsNotificationService;
        this.emailNotificationService = emailNotificationService;
        this.pushNotificationService = pushNotificationService;
    }

    public NotificationService getNotificationServiceByType(NotificationType type) {
        return switch (type) {
            case SMS -> smsNotificationService;
            case EMAIL -> emailNotificationService;
            case PUSH -> pushNotificationService;
        };
    }
}
