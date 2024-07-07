package ir.ac.kntu.notificationmanagement.service;

import ir.ac.kntu.notificationmanagement.model.NotificationStatus;
import ir.ac.kntu.notificationmanagement.model.PushNotification;
import ir.ac.kntu.notificationmanagement.model.User;
import ir.ac.kntu.notificationmanagement.repository.PushNotificationRepository;
import ir.ac.kntu.notificationmanagement.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PushNotificationService implements NotificationService {

    private final PushNotificationRepository pushNotificationRepository;

    private final UserService userService;

    private final NotificationStrategy<PushNotification> pushNotificationStrategy;

    public PushNotificationService(PushNotificationRepository pushNotificationRepository, UserService userService, NotificationStrategy<PushNotification> pushNotificationStrategy) {
        this.pushNotificationRepository = pushNotificationRepository;
        this.userService = userService;
        this.pushNotificationStrategy = pushNotificationStrategy;
    }


    @Override
    public void sendBookingConfirmation(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Booking Confirmed!", "Your Ride is Scheduled",
                "Hi %s, your ride has been confirmed. We look forward to serving you!".formatted(user.getName()));
    }

    @Override
    public void sendDriverAssignment(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Driver Assigned!", "Meet Your Driver",
                "Great news, %s! Driver has been assigned to your ride. They will be arriving shortly.".formatted(user.getName()));
    }

    @Override
    public void sendEstimatedArrivalTime(Long userId, String eta) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Estimated Arrival Time", "Your Driver is on the Way",
                "Hi %s, your driver is expected to arrive by %s. Please be ready to meet them.".formatted(user.getName(), eta));
    }

    @Override
    public void sendRideCompletion(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Ride Completed!", "Thank You for Riding with Us",
                "Hi %s, your ride has been successfully completed. We hope you had a pleasant journey!".formatted(user.getName()));
    }

    @Override
    public void sendPaymentConfirmationToDriver(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Payment Confirmed", "You've Been Paid",
                "Hi %s, payment for the ride has been successfully processed. Thank you for driving with us!".formatted(user.getName()));
    }

    private PushNotification createPushNotification(User user) {
        PushNotification notification = new PushNotification();
        notification.setUser(user);
        notification.setStatus(NotificationStatus.PENDING);
        notification.setSentAt(LocalDateTime.now());
        return notification;
    }

    private void sendNotification(User user, String title, String subtitle, String message) {
        PushNotification pushNotification = createPushNotification(user);
        pushNotification.setTitle(title);
        pushNotification.setSubtitle(subtitle);
        pushNotification.setMessage(message);
        pushNotificationRepository.save(pushNotification);
        pushNotificationStrategy.send(pushNotification);
        pushNotification.setStatus(NotificationStatus.SENT);
        pushNotificationRepository.save(pushNotification);
    }
}
