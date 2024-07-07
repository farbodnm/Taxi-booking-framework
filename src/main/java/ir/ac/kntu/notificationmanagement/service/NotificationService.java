package ir.ac.kntu.notificationmanagement.service;

import ir.ac.kntu.notificationmanagement.model.Notification;
import ir.ac.kntu.notificationmanagement.model.NotificationType;

public interface NotificationService {

    void sendBookingConfirmation(Long userId);

    void sendDriverAssignment(Long userId);

    void sendEstimatedArrivalTime(Long userId, String eta);

    void sendRideCompletion(Long userId);

    void sendPaymentConfirmationToDriver(Long userId);

}
