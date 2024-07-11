package com.taxi.framework.notification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "email_notification")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmailNotification extends Notification {
    private String subject;

    private String message;
}
