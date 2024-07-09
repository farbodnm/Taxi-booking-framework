package com.taxi.pay.controller;

import com.taxi.framework.pay.controller.AbstractPaymentController;
import com.taxi.framework.pay.dto.PaymentRequest;
import com.taxi.framework.pay.dto.PaymentResponse;
import com.taxi.pay.service.ZarinPalPaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/payment")
public class PaymentController extends AbstractPaymentController<PaymentRequest, PaymentResponse> {

    @Autowired
    public PaymentController(ZarinPalPaymentService paymentService) {
        super(paymentService);
    }

    @PostMapping("/initiate")
    @Override
    public ResponseEntity<PaymentResponse> initiatePayment(@RequestBody PaymentRequest request) {
        return super.initiatePayment(request);
    }

    // Implement other specific endpoints if needed
}

