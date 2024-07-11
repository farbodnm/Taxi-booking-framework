package com.taxi.framework.notification.service;

import com.taxi.framework.notification.model.Notification;

import java.util.List;

public interface NotificationService {

    void sendBookingConfirmation(Long userId);

    void sendDriverAssignment(Long userId);

    void sendEstimatedArrivalTime(Long userId, String eta);

    void sendRideCompletion(Long userId);

    void sendPaymentConfirmationToDriver(Long userId);

    List<? extends Notification> getNotificationListOfUser(Long userId);
}
