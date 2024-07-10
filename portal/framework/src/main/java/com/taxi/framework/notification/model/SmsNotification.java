package com.taxi.framework.notification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "sms_notification")
@Data
@EqualsAndHashCode(callSuper = true)
public class SmsNotification extends Notification {
    private String message;
}
