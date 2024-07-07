package com.example.smssender.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/sms")
public abstract class AbstractSmsController {
    // Abstract methods to be implemented by subclasses
    public abstract void sendSms();
}
