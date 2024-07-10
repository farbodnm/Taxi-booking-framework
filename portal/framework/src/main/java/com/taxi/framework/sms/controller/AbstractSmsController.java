package com.taxi.framework.sms.controller;


import com.taxi.framework.sms.dto.SmsRequestDTO;
import com.taxi.framework.sms.service.AbstractSmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
public abstract class AbstractSmsController {

    protected AbstractSmsService smsService;

    public AbstractSmsController(AbstractSmsService smsService) {
        this.smsService = smsService;
    }

    public abstract ResponseEntity<String> sendSms(@RequestBody SmsRequestDTO smsRequest);
}
