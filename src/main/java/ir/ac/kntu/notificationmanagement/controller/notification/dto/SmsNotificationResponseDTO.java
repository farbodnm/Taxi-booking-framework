package ir.ac.kntu.notificationmanagement.controller.notification.dto;

import ir.ac.kntu.notificationmanagement.model.NotificationStatus;
import ir.ac.kntu.notificationmanagement.model.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class SmsNotificationResponseDTO extends NotificationResponseDTO{
    private String message;
}
