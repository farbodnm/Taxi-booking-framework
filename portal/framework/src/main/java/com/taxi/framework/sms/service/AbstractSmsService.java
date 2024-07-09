package com.taxi.framework.sms.service;

import com.taxi.framework.sms.dto.SmsRequestDTO;
import java.io.IOException;

public abstract class AbstractSmsService {
    public String sendSms(SmsRequestDTO smsRequestDTO) throws IOException {
        String jsonBody = convertToJson(smsRequestDTO);
        String response = sendHttpRequest(jsonBody);
        return processResponse(response);
    }

    protected abstract String convertToJson(SmsRequestDTO smsRequestDTO);

    protected abstract String sendHttpRequest(String jsonBody) throws IOException;

    protected abstract String processResponse(String response);
}
