package com.taxi.framework.notification.controller;

import com.taxi.framework.notification.controller.dto.EmailNotificationResponseDTO;
import com.taxi.framework.notification.controller.dto.PushNotificationResponseDTO;
import com.taxi.framework.notification.controller.dto.SmsNotificationResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface INotificationInfoController {

    List<SmsNotificationResponseDTO> getSmsNotifications(@PathVariable Long userId);

    List<EmailNotificationResponseDTO> getEmailNotifications(@PathVariable Long userId);

    List<PushNotificationResponseDTO> getPushNotifications(@PathVariable Long userId);
}
