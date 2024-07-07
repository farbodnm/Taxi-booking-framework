package ir.ac.kntu.notificationmanagement.service;

import ir.ac.kntu.notificationmanagement.model.EmailNotification;
import ir.ac.kntu.notificationmanagement.model.NotificationStatus;
import ir.ac.kntu.notificationmanagement.model.User;
import ir.ac.kntu.notificationmanagement.repository.EmailNotificationRepository;
import ir.ac.kntu.notificationmanagement.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailNotificationService implements NotificationService{

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
