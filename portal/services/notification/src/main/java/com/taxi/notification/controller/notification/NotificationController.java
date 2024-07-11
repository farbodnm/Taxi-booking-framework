package com.taxi.notification.controller.notification;

import com.taxi.framework.notification.controller.INotificationController;
import com.taxi.framework.notification.controller.dto.EstimatedArrivalTimeNotificationRequestDTO;
import com.taxi.framework.notification.controller.dto.MessageResponseDTO;
import com.taxi.framework.notification.controller.dto.NotificationSendingRequestDTO;
import com.taxi.framework.notification.model.NotificationType;
import com.taxi.framework.notification.service.NotificationService;
import com.taxi.notification.service.NotificationServiceManager;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("notification")
public class NotificationController implements INotificationController {

    private final NotificationServiceManager notificationServiceManager;

    public NotificationController(NotificationServiceManager notificationServiceManager) {
        this.notificationServiceManager = notificationServiceManager;
    }

    @PostMapping("/booking-confirmation")
    @Override
    public ResponseEntity<MessageResponseDTO> sendBookingConfirmation(@RequestBody @Valid NotificationSendingRequestDTO dto) {
        mapNotificationTypesToServices(dto.getNotificationTypes())
                .forEach(notificationService -> notificationService.sendBookingConfirmation(dto.getUserId()));
        return new ResponseEntity<>(new MessageResponseDTO("Booking confirmation notification sent successfully"), HttpStatus.OK);
    }

    @PostMapping("/driver-assignment")
    @Override
    public ResponseEntity<MessageResponseDTO> sendDriverAssignment(@RequestBody @Valid NotificationSendingRequestDTO dto) {
        mapNotificationTypesToServices(dto.getNotificationTypes())
                .forEach(notificationService -> notificationService.sendDriverAssignment(dto.getUserId()));
        return new ResponseEntity<>(new MessageResponseDTO("Driver assignment notification sent successfully"), HttpStatus.OK);
    }

    @PostMapping("/estimated-arrival-time")
    @Override
    public ResponseEntity<MessageResponseDTO> sendEstimatedArrivalTime(@RequestBody @Valid EstimatedArrivalTimeNotificationRequestDTO dto) {
        mapNotificationTypesToServices(dto.getNotificationTypes())
                .forEach(notificationService -> notificationService.sendEstimatedArrivalTime(dto.getUserId(), dto.getEta()));
        return new ResponseEntity<>(new MessageResponseDTO("Estimated arrival time notification sent successfully"), HttpStatus.OK);
    }

    @PostMapping("/ride-completion")
    @Override
    public ResponseEntity<MessageResponseDTO> sendRideCompletion(@RequestBody @Valid NotificationSendingRequestDTO dto) {
        mapNotificationTypesToServices(dto.getNotificationTypes())
                .forEach(notificationService -> notificationService.sendRideCompletion(dto.getUserId()));
        return new ResponseEntity<>(new MessageResponseDTO("Ride completion notification sent successfully"), HttpStatus.OK);
    }

    @PostMapping("/payment-confirmation")
    @Override
    public ResponseEntity<MessageResponseDTO> sendPaymentConfirmation(@RequestBody @Valid NotificationSendingRequestDTO dto) {
        mapNotificationTypesToServices(dto.getNotificationTypes())
                .forEach(notificationService -> notificationService.sendPaymentConfirmationToDriver(dto.getUserId()));
        return new ResponseEntity<>(new MessageResponseDTO("Payment confirmation notification sent successfully"), HttpStatus.OK);
    }

    private List<NotificationService> mapNotificationTypesToServices(List<NotificationType> types) {
        return types.stream().map(notificationServiceManager::getNotificationServiceByType).collect(Collectors.toList());
    }
}
