package com.taxi.framework.sms.service;

import java.io.IOException;

/**
 * AbstractSmsService is an abstract class that provides the basic structure for SMS services.
 * Subclasses should implement the sendSms method to send SMS messages using specific APIs.
 *
 * @param <T> The type of the SMS request data transfer object (DTO).
 * @param <R> The type of the response from the SMS service.
 */
public abstract class AbstractSmsService<T, R> {
    /**
     * The URL of the SMS service API.
     */
    protected String apiUrl;

    /**
     * The API key used for authenticating with the SMS service.
     */
    protected String apiKey;

    /**
     * Constructor for AbstractSmsService.
     *
     * @param apiUrl The URL of the SMS service API.
     * @param apiKey The API key used for authenticating with the SMS service.
     */
    public AbstractSmsService(String apiUrl, String apiKey) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    /**
     * Sends an SMS message using the provided SMS request.
     *
     * @param smsRequest The SMS request containing the message details.
     * @return The response from the SMS service.
     * @throws IOException If an input or output exception occurred.
     */
    public abstract R sendSms(T smsRequest) throws IOException;
}
