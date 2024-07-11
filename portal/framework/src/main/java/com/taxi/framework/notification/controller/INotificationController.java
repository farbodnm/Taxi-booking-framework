package com.taxi.framework.notification.controller;

import com.taxi.framework.notification.controller.dto.EstimatedArrivalTimeNotificationRequestDTO;
import com.taxi.framework.notification.controller.dto.MessageResponseDTO;
import com.taxi.framework.notification.controller.dto.NotificationSendingRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface INotificationController {

    ResponseEntity<MessageResponseDTO> sendBookingConfirmation(@RequestBody @Valid NotificationSendingRequestDTO dto);

    ResponseEntity<MessageResponseDTO> sendDriverAssignment(@RequestBody @Valid NotificationSendingRequestDTO dto);

    ResponseEntity<MessageResponseDTO> sendEstimatedArrivalTime(@RequestBody @Valid EstimatedArrivalTimeNotificationRequestDTO dto);

    ResponseEntity<MessageResponseDTO> sendRideCompletion(@RequestBody @Valid NotificationSendingRequestDTO dto);

    ResponseEntity<MessageResponseDTO> sendPaymentConfirmation(@RequestBody @Valid NotificationSendingRequestDTO dto);

}
