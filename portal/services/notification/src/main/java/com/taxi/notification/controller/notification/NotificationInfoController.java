package com.taxi.notification.controller.notification;

import com.taxi.framework.notification.controller.INotificationInfoController;
import com.taxi.framework.notification.controller.dto.EmailNotificationResponseDTO;
import com.taxi.framework.notification.controller.dto.PushNotificationResponseDTO;
import com.taxi.framework.notification.controller.dto.SmsNotificationResponseDTO;
import com.taxi.framework.notification.model.EmailNotification;
import com.taxi.framework.notification.model.NotificationType;
import com.taxi.framework.notification.model.PushNotification;
import com.taxi.framework.notification.model.SmsNotification;
import com.taxi.framework.notification.service.NotificationService;
import com.taxi.notification.service.NotificationServiceManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("notification/info/user/{userId}")
public class NotificationInfoController implements INotificationInfoController {

    private final NotificationServiceManager notificationServiceManager;

    public NotificationInfoController(NotificationServiceManager notificationServiceManager) {
        this.notificationServiceManager = notificationServiceManager;
    }

    @GetMapping(path = "sms")
    @Override
    public List<SmsNotificationResponseDTO> getSmsNotifications(@PathVariable Long userId) {
        NotificationService service = notificationServiceManager.getNotificationServiceByType(NotificationType.SMS);
        List<SmsNotification> notificationListOfUser = (List<SmsNotification>) service.getNotificationListOfUser(userId);
        return notificationListOfUser.stream().map(this::convertSmsNotificationToDTO).collect(Collectors.toList());
    }

    @GetMapping(path = "email")
    @Override
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
