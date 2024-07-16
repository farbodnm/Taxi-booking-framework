package com.taxi.framework.sms.controller;

import com.taxi.framework.sms.service.AbstractSmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Abstract base class for SMS controllers.
 *
 * This class provides a template for controllers that handle sending SMS messages. It uses generics to allow for different
 * types of SMS requests and responses. Subclasses must implement the {@link #sendSms(Object)} method to define the behavior
 * for sending SMS messages.
 *
 * @param <T> the type of the SMS request
 * @param <R> the type of the SMS response
 */
public abstract class AbstractSmsController<T, R> {

    /**
     * The SMS service used to send messages.
     */
    protected AbstractSmsService<T, R> smsService;

    /**
     * Constructs a new {@code AbstractSmsController} with the specified SMS service.
     *
     * @param smsService the SMS service to use for sending messages
     */
    public AbstractSmsController(AbstractSmsService<T, R> smsService) {
        this.smsService = smsService;
    }

    /**
     * Sends an SMS message.
     *
     * Subclasses must implement this method to define the specific behavior for sending SMS messages.
     *
     * @param smsRequest the SMS request containing the message details
     * @return a {@link ResponseEntity} containing the response
     */
    public abstract ResponseEntity<R> sendSms(@RequestBody T smsRequest);
}
