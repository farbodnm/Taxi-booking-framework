package com.taxi.framework.notification.configuration;

import com.taxi.framework.notification.model.EmailNotification;
import com.taxi.framework.notification.model.PushNotification;
import com.taxi.framework.notification.model.SmsNotification;
import com.taxi.framework.notification.strategy.NotificationStrategy;

public interface INotificationStrategyConfiguration {

    NotificationStrategy<SmsNotification> smsNotificationStrategy();

    NotificationStrategy<EmailNotification> emailNotificationStrategy();

    NotificationStrategy<PushNotification> pushNotificationStrategy();
}
