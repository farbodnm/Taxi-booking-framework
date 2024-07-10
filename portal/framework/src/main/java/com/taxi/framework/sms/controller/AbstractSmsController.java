package com.taxi.framework.sms.controller;

import com.taxi.framework.sms.service.AbstractSmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractSmsController<T, R> {

    protected AbstractSmsService<T, R> smsService;

    public AbstractSmsController(AbstractSmsService<T, R> smsService) {
        this.smsService = smsService;
    }

    public abstract ResponseEntity<R> sendSms(@RequestBody T smsRequest);
}
