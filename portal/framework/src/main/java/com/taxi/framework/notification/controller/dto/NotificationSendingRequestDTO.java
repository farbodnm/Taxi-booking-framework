package com.taxi.framework.notification.controller.dto;

import com.taxi.framework.notification.model.NotificationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class NotificationSendingRequestDTO {
    @NotNull(message = "Notification type is required")
    @NotEmpty(message = "Notification must contain at least one type")
    private List<NotificationType> notificationTypes;

    @NotNull(message = "User ID is required")
    private Long userId;
}
