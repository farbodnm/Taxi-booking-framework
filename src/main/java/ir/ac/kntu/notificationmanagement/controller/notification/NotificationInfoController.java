package ir.ac.kntu.notificationmanagement.controller.notification;

import ir.ac.kntu.notificationmanagement.controller.notification.dto.EmailNotificationResponseDTO;
import ir.ac.kntu.notificationmanagement.controller.notification.dto.PushNotificationResponseDTO;
import ir.ac.kntu.notificationmanagement.controller.notification.dto.SmsNotificationResponseDTO;
import ir.ac.kntu.notificationmanagement.model.*;
import ir.ac.kntu.notificationmanagement.service.NotificationService;
import ir.ac.kntu.notificationmanagement.service.NotificationServiceManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("notification/info/user/{userId}")
public class NotificationInfoController {

    private final NotificationServiceManager notificationServiceManager;

    public NotificationInfoController(NotificationServiceManager notificationServiceManager) {
        this.notificationServiceManager = notificationServiceManager;
    }

    @GetMapping(path = "sms")
    public List<SmsNotificationResponseDTO> getSmsNotifications(@PathVariable Long userId) {
        NotificationService service = notificationServiceManager.getNotificationServiceByType(NotificationType.SMS);
        List<SmsNotification> notificationListOfUser = (List<SmsNotification>) service.getNotificationListOfUser(userId);
        return notificationListOfUser.stream().map(this::convertSmsNotificationToDTO).collect(Collectors.toList());
    }

    @GetMapping(path = "email")
    public List<EmailNotificationResponseDTO> getEmailNotifications(@PathVariable Long userId) {
        NotificationService service = notificationServiceManager.getNotificationServiceByType(NotificationType.EMAIL);
        List<EmailNotification> notificationListOfUser = (List<EmailNotification>) service.getNotificationListOfUser(userId);
        return notificationListOfUser.stream().map(this::convertEmailNotificationToDTO).collect(Collectors.toList());
    }

    @GetMapping(path = "push")
    public List<PushNotificationResponseDTO> getPushNotifications(@PathVariable Long userId) {
        NotificationService service = notificationServiceManager.getNotificationServiceByType(NotificationType.PUSH);
        List<PushNotification> notificationListOfUser = (List<PushNotification>) service.getNotificationListOfUser(userId);
        return notificationListOfUser.stream().map(this::convertPushNotificationToDTO).collect(Collectors.toList());
    }

    private SmsNotificationResponseDTO convertSmsNotificationToDTO(SmsNotification smsNotification) {
        return SmsNotificationResponseDTO.builder()
                .id(smsNotification.getId())
                .status(smsNotification.getStatus())
                .sentAt(smsNotification.getSentAt())
                .message(smsNotification.getMessage())
                .build();
    }

    private EmailNotificationResponseDTO convertEmailNotificationToDTO(EmailNotification emailNotification) {
        return EmailNotificationResponseDTO.builder()
                .id(emailNotification.getId())
                .status(emailNotification.getStatus())
                .sentAt(emailNotification.getSentAt())
                .subject(emailNotification.getSubject())
                .message(emailNotification.getMessage())
                .build();
    }

    private PushNotificationResponseDTO convertPushNotificationToDTO(PushNotification pushNotification) {
        return PushNotificationResponseDTO.builder()
                .id(pushNotification.getId())
                .status(pushNotification.getStatus())
                .sentAt(pushNotification.getSentAt())
                .title(pushNotification.getTitle())
                .subtitle(pushNotification.getSubtitle())
                .message(pushNotification.getMessage())
                .build();
    }
}
