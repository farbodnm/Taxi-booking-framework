package ir.ac.kntu.notificationmanagement.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "push_notification")
@Data
@EqualsAndHashCode(callSuper = true)
public class PushNotification extends Notification {
    private String title;

    @Nullable
    private String subtitle;

    private String message;
}
