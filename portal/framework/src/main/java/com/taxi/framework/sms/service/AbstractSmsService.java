package com.taxi.framework.sms.service;

import java.io.IOException;

public abstract class AbstractSmsService<T, R> {
    protected String apiUrl;
    protected String apiKey;

    public AbstractSmsService(String apiUrl, String apiKey) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public abstract R sendSms(T smsRequest) throws IOException;
}
