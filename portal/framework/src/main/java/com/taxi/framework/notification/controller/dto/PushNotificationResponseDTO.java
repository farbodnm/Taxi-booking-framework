package com.taxi.framework.notification.controller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class PushNotificationResponseDTO extends NotificationResponseDTO{
    private String title;

    private String subtitle;

    private String message;
}
