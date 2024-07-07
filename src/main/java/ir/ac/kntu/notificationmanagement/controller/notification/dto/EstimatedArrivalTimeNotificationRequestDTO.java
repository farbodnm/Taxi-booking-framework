package ir.ac.kntu.notificationmanagement.controller.notification.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EstimatedArrivalTimeNotificationRequestDTO extends NotificationSendingRequestDTO{
    @NotBlank(message = "Notification arrival time is required")
    private String eta;
}
