package com.taxi.pay.controller;

import com.taxi.framework.payment.controller.AbstractPaymentController;
import com.taxi.framework.payment.dto.PaymentRequest;
import com.taxi.framework.payment.dto.PaymentResponse;
import com.taxi.pay.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController extends AbstractPaymentController<PaymentRequest, PaymentResponse> {

    public PaymentController(PaymentService paymentService) {
        super(paymentService);
    }

    // Implement other specific endpoints if needed
}

