package com.taxi.framework.pay.controller;

import com.taxi.framework.pay.dto.CallbackRequest;
import com.taxi.framework.pay.dto.PaymentRequest;
import com.taxi.framework.pay.dto.PaymentResponse;
import com.taxi.framework.pay.service.AbstractPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractPaymentController<T extends PaymentRequest, R extends PaymentResponse> {

    protected final AbstractPaymentService<T, R> paymentService;

    protected AbstractPaymentController(AbstractPaymentService<T, R> paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public ResponseEntity<R> initiatePayment(@RequestBody T request) {
        R response = paymentService.initiatePayment(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/callback")
    public ResponseEntity<String> handleCallback(@RequestBody CallbackRequest callbackRequest) {
        // Validate the callback
        // Update payment status in your system
        return ResponseEntity.ok("Callback received");
    }

    // Other common methods for handling payment-related operations
}
