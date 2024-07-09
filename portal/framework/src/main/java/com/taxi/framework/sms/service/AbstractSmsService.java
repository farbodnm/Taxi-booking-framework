package com.taxi.framework.sms.service;

import com.taxi.framework.sms.dto.SmsRequestDTO;
import java.io.IOException;

/**
 * Abstract service for handling SMS-related operations.
 * This class defines the common structure and behavior for sending SMS messages using various SMS gateways.
 */
public abstract class AbstractSmsService {

    /**
     * The URL of the SMS API endpoint.
     */
    protected String apiUrl;

    /**
     * The API key used for authentication with the SMS API.
     */
    protected String apiKey;

    /**
     * Constructs a new AbstractSmsService with the specified API URL and API key.
     *
     * @param apiUrl the URL of the SMS API endpoint
     * @param apiKey the API key used for authentication with the SMS API
     */
    public AbstractSmsService(String apiUrl, String apiKey) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    /**
     * Sends an SMS message based on the provided SMS request DTO.
     * This method must be implemented by subclasses to define the specific behavior for sending SMS messages.
     *
     * @param smsRequest the SMS request DTO containing the message details
     * @return a string containing the result of the SMS send operation
     * @throws IOException if an I/O error occurs during the SMS send operation
     */
    public abstract String sendSms(SmsRequestDTO smsRequest) throws IOException;
}
