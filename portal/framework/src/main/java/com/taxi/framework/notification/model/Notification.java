package com.taxi.framework.notification.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notification")
@Inheritance(strategy = InheritanceType.JOINED)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private NotificationStatus status;

    private LocalDateTime sentAt;
}
