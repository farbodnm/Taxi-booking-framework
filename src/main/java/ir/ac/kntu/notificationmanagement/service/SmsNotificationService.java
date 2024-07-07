package ir.ac.kntu.notificationmanagement.service;

import ir.ac.kntu.notificationmanagement.model.Notification;
import ir.ac.kntu.notificationmanagement.model.NotificationStatus;
import ir.ac.kntu.notificationmanagement.model.SmsNotification;
import ir.ac.kntu.notificationmanagement.model.User;
import ir.ac.kntu.notificationmanagement.repository.SmsNotificationRepository;
import ir.ac.kntu.notificationmanagement.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SmsNotificationService implements NotificationService {

    private final SmsNotificationRepository smsNotificationRepository;

    private final UserService userService;

    private final NotificationStrategy<SmsNotification> smsNotificationStrategy;

    public SmsNotificationService(SmsNotificationRepository smsNotificationRepository, UserService userService, NotificationStrategy<SmsNotification> smsNotificationStrategy) {
        this.smsNotificationRepository = smsNotificationRepository;
        this.userService = userService;
        this.smsNotificationStrategy = smsNotificationStrategy;
    }

    @Override
    public void sendBookingConfirmation(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Your booking has been confirmed.");
    }

    @Override
    public void sendDriverAssignment(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "A driver has been assigned to your ride.");
    }

    @Override
    public void sendEstimatedArrivalTime(Long userId, String eta) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Your driver will arrive in " + eta + ".");
    }

    @Override
    public void sendRideCompletion(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Your ride has been completed.");
    }

    @Override
    public void sendPaymentConfirmationToDriver(Long userId) {
        User user = userService.getUserById(userId);
        sendNotification(user, "Your payment has been processed.");
    }

    @Override
    public List<SmsNotification> getNotificationListOfUser(Long userId) {
        User user = userService.getUserById(userId);
        return smsNotificationRepository.findByUser(user);
    }

    private SmsNotification createSmsNotification(User user) {
        SmsNotification notification = new SmsNotification();
        notification.setUser(user);
        notification.setStatus(NotificationStatus.PENDING);
        notification.setSentAt(LocalDateTime.now());
        return notification;
    }

    private void sendNotification(User user, String message) {
        SmsNotification smsNotification = createSmsNotification(user);
        smsNotification.setMessage(message);
        smsNotificationRepository.save(smsNotification);
        smsNotificationStrategy.send(smsNotification);
        smsNotification.setStatus(NotificationStatus.SENT);
        smsNotificationRepository.save(smsNotification);
    }
}
