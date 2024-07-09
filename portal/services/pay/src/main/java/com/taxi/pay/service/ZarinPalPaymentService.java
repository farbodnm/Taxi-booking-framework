package com.taxi.pay.service;

import com.taxi.framework.pay.dto.PaymentRequest;
import com.taxi.framework.pay.dto.PaymentResponse;
import com.taxi.framework.pay.service.AbstractPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZarinPalPaymentService extends AbstractPaymentService<PaymentRequest, PaymentResponse> {

    public ZarinPalPaymentService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected Class<PaymentResponse> getResponseType() {
        return PaymentResponse.class;
    }

    private static final String ZARINPAL_API_URL = "https://sandbox.zarinpal.com/pg/v4/payment/request.json";

    public String sendPaymentRequest(PaymentRequest paymentRequest) {
        String jsonResponse = restTemplate.postForObject(ZARINPAL_API_URL, paymentRequest, String.class);
        // Handle JSON response from ZarinPal
        return jsonResponse;
    }
}

