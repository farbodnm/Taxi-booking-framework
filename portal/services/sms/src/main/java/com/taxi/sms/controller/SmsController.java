package com.taxi.sms.controller;
import com.taxi.framework.sms.controller.AbstractSmsController;
import com.taxi.framework.sms.dto.SmsRequestDTO;
import com.taxi.framework.sms.service.AbstractSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/sms")
public class SmsController extends AbstractSmsController<SmsRequestDTO, String> {

    @Autowired
    public SmsController(AbstractSmsService<SmsRequestDTO, String> smsService) {
        super(smsService);
    }

    @Override
    @PostMapping("/send")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequestDTO smsRequest) {
        try {
            String response = smsService.sendSms(smsRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to send SMS: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
