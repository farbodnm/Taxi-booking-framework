package com.taxi.notification.service;

import com.taxi.framework.notification.model.EmailNotification;
import com.taxi.framework.notification.model.Notification;
import com.taxi.framework.notification.model.NotificationStatus;
import com.taxi.framework.notification.model.User;
import com.taxi.notification.repository.EmailNotificationRepository;
import com.taxi.framework.notification.service.NotificationService;
import com.taxi.framework.notification.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailNotificationService implements NotificationService {

    private final EmailNotificationRepository emailNotificationRepository;

    private final UserService userService;

    private final NotificationStrategy<EmailNotification> emailNotificationStrategy;

    public EmailNotificationService(EmailNotificationRepository emailNotificationRepository, UserService userService, NotificationStrategy<EmailNotification> emailNotificationStrategy) {
        this.emailNotificationRepository = emailNotificationRepository;
        this.userService = userService;
        this.emailNotificationStrategy = emailNotificationStrategy;
    }


    @Override
    public void sendBookingConfirmation(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Booking Confirmation", "Your booking has been confirmed.");
    }

    @Override
    public void sendDriverAssignment(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Driver Assignment", "A driver has been assigned to your ride.");
    }

    @Override
    public void sendEstimatedArrivalTime(Long userId, String eta) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Estimated Arrival Time", "Your driver will arrive in " + eta + ".");
    }

    @Override
    public void sendRideCompletion(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Ride Completed", "Your ride has been completed.");
    }

    @Override
    public void sendPaymentConfirmationToDriver(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Payment Confirmation", "Your payment has been processed.");
    }

    @Override
    public List<? extends Notification> getNotificationListOfUser(Long userId) {
        User user = userService.getUserById(userId);
        return emailNotificationRepository.findByUser(user);
    }

    private EmailNotification createEmailNotification(User user) {
        EmailNotification notification = new EmailNotification();
        notification.setUser(user);
        notification.setStatus(NotificationStatus.PENDING);
        notification.setSentAt(LocalDateTime.now());
        return notification;
    }

    private void sendNotification(User user, String subject, String message) {
        EmailNotification emailNotification = createEmailNotification(user);
        emailNotification.setSubject(subject);
        emailNotification.setMessage(message);
        emailNotificationRepository.save(emailNotification);
        emailNotificationStrategy.send(emailNotification);
        emailNotification.setStatus(NotificationStatus.SENT);
        emailNotificationRepository.save(emailNotification);
    }
}
