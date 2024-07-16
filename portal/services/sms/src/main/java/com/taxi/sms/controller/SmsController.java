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
 * SmsController handles HTTP requests for sending SMS messages.
 * It extends the AbstractSmsController and uses an AbstractSmsService to send SMS messages.
 */
@RestController
@RequestMapping("/api/sms")
public class SmsController extends AbstractSmsController<SmsRequestDTO, String> {

    /**
     * The SMS service used to send SMS messages.
     */
    private final AbstractSmsService<SmsRequestDTO, String> smsService;

    /**
     * Constructor for SmsController.
     *
     * @param smsService The service used to send SMS messages.
     */
    @Autowired
    public SmsController(AbstractSmsService<SmsRequestDTO, String> smsService) {
        super(smsService);
        this.smsService = smsService;
    }

    /**
     * Endpoint to send an SMS message.
     *
     * @param smsRequest The SMS request containing the message details.
     * @return A ResponseEntity containing the response from the SMS service and an HTTP status code.
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
