package com.taxi.pay.service;

import com.taxi.framework.pay.dto.PaymentRequest;
import com.taxi.framework.pay.dto.PaymentResponse;
import com.taxi.framework.pay.service.AbstractPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService extends AbstractPaymentService<PaymentRequest, PaymentResponse> {

    public PaymentService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected Class<PaymentResponse> getResponseType() {
        return PaymentResponse.class;
    }

    // Implement other specific methods if needed
}

