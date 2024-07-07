package ir.ac.kntu.notificationmanagement.controller.notification.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class EmailNotificationResponseDTO extends NotificationResponseDTO {
    private String subject;

    private String message;
}
