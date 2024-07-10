package com.taxi.framework.notification.controller.dto;

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
