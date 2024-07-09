package com.taxi.framework.sms.service;

import com.taxi.framework.sms.dto.SmsRequestDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.io.IOException;

public abstract class AbstractSmsService {
    // Template Method Pattern: Defines the skeleton of the SMS sending algorithm
    public String sendSms(SmsRequestDTO smsRequestDTO) throws IOException {
        OkHttpClient client = createHttpClient();  // Factory Method for creating OkHttpClient
        Request request = createRequest(smsRequestDTO);  // Factory Method for creating Request
        return executeRequest(client, request);  // Concrete implementation of request execution
    }

    // Abstract methods to be implemented by subclasses
    protected abstract OkHttpClient createHttpClient();
    protected abstract Request createRequest(SmsRequestDTO smsRequestDTO) throws IOException;
    protected abstract String executeRequest(OkHttpClient client, Request request) throws IOException;
}
