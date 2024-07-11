package com.taxi.framework.notification.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EstimatedArrivalTimeNotificationRequestDTO extends NotificationSendingRequestDTO {
    @NotBlank(message = "Notification arrival time is required")
    private String eta;
}
