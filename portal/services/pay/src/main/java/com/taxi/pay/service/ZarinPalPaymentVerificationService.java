package com.taxi.pay.service;

import com.taxi.framework.pay.service.AbstractPaymentVerificationService;
import com.taxi.framework.pay.dto.PaymentRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZarinPalPaymentVerificationService extends AbstractPaymentVerificationService<PaymentRequest, String> {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String ZARINPAL_VERIFY_URL = "https://sandbox.zarinpal.com/pg/v4/payment/verify.json";

    @Override
    protected String verifyPayment(PaymentRequest verificationRequest) {
        return restTemplate.postForObject(ZARINPAL_VERIFY_URL, verificationRequest, String.class);
    }
}
