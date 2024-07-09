package com.taxi.framework.sms.controller;

import com.taxi.framework.sms.dto.SmsRequestDTO;
import com.taxi.framework.sms.service.AbstractSmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Abstract controller for handling SMS-related operations.
 * This class defines a common structure for sending SMS messages.
 *
 * @see AbstractSmsService
 */
public abstract class AbstractSmsController {

    /**
     * The SMS service used for processing SMS requests.
     */
    protected AbstractSmsService smsService;

    /**
     * Constructs a new AbstractSmsController with the specified SMS service.
     *
     * @param smsService the SMS service used for processing SMS requests
     */
    public AbstractSmsController(AbstractSmsService smsService) {
        this.smsService = smsService;
    }

    /**
     * Sends an SMS message based on the provided SMS request DTO.
     * This method must be implemented by subclasses to define the specific behavior for sending SMS messages.
     *
     * @param smsRequest the SMS request DTO containing the message details
     * @return a ResponseEntity containing the result of the SMS send operation
     */
    public abstract ResponseEntity<String> sendSms(@RequestBody SmsRequestDTO smsRequest);
}
