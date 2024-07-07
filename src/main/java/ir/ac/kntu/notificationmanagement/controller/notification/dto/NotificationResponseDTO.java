package ir.ac.kntu.notificationmanagement.controller.notification.dto;

import ir.ac.kntu.notificationmanagement.model.NotificationStatus;
import ir.ac.kntu.notificationmanagement.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class NotificationResponseDTO {
    private Long id;

    private NotificationStatus status;

    private LocalDateTime sentAt;
}
