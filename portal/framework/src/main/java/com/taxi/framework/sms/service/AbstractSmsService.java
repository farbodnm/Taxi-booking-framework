package com.taxi.framework.sms.service;

import com.taxi.framework.sms.dto.SmsRequestDTO;
import java.io.IOException;

public abstract class AbstractSmsService {
    protected String apiUrl;
    protected String apiKey;

    public AbstractSmsService(String apiUrl, String apiKey) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public abstract String sendSms(SmsRequestDTO smsRequest) throws IOException;
}
