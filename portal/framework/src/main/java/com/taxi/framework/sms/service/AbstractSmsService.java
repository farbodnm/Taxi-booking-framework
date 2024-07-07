package com.taxi.framework.sms.service;

import com.taxi.framework.sms.dto.SmsRequestDto;

public abstract class AbstractSmsService {

    protected abstract void sendSms(SmsRequestDto smsRequestDto);

}

