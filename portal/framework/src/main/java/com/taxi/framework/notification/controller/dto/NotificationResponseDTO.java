package com.taxi.framework.notification.controller.dto;

import com.taxi.framework.notification.model.NotificationStatus;
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
