package com.taxi.sms.controller;

import com.taxi.framework.sms.controller.AbstractSmsController;
import com.taxi.framework.sms.dto.SmsRequestDTO;
import com.taxi.framework.sms.service.AbstractSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Controller for handling SMS-related operations.
 * This class extends AbstractSmsController to provide an endpoint for sending SMS messages.
 *
 * @see AbstractSmsController
 * @see AbstractSmsService
 */
@RestController
@RequestMapping("/api/sms")
public class SmsController extends AbstractSmsController {

    /**
     * Constructs a new SmsController with the specified SMS service.
     *
     * @param smsService the SMS service used for processing SMS requests
     */
    @Autowired
    public SmsController(AbstractSmsService smsService) {
        super(smsService);
    }

    /**
     * Endpoint for sending an SMS message.
     *
     * @param smsRequest the SMS request DTO containing the message details
     * @return a ResponseEntity containing the result of the SMS send operation
     */
    @Override
    @PostMapping("/send")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequestDTO smsRequest) {
        try {
            String response = smsService.sendSms(smsRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to send SMS: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
