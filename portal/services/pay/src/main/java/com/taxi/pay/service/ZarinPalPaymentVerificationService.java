package com.taxi.pay.service;

import com.taxi.framework.pay.service.AbstractPaymentVerificationService;
import com.taxi.framework.pay.dto.PaymentRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service class for verifying payments using ZarinPal payment gateway.
 * This class extends AbstractPaymentVerificationService to implement payment verification functionality.
 *
 * @see AbstractPaymentVerificationService
 */
@Service
public class ZarinPalPaymentVerificationService extends AbstractPaymentVerificationService<PaymentRequestDTO, String> {

    /**
     * The RestTemplate used for making HTTP requests to the ZarinPal API.
     */
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * The URL of the ZarinPal payment verification API endpoint.
     */
    private static final String ZARINPAL_VERIFY_URL = "https://sandbox.zarinpal.com/pg/v4/payment/verify.json";

    /**
     * Verifies a payment with ZarinPal by sending a verification request.
     *
     * @param verificationRequest the payment request DTO containing verification details
     * @return a JSON response string received from ZarinPal after verifying the payment
     */
    @Override
    protected String verifyPayment(PaymentRequestDTO verificationRequest) {
        return restTemplate.postForObject(ZARINPAL_VERIFY_URL, verificationRequest, String.class);
    }
}

