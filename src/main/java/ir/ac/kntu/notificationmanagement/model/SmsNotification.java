package ir.ac.kntu.notificationmanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "sms_notification")
@Data
@EqualsAndHashCode(callSuper = true)
public class SmsNotification extends Notification{
    private String message;
}
