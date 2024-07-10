package com.taxi.pay.service;

import com.taxi.framework.pay.service.AbstractPaymentVerificationService;
import com.taxi.framework.pay.dto.PaymentRequestDTO;
import org.springframework.beans.factory.annotation.Value;
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

    private final RestTemplate restTemplate;

    private final String zarinpalVerifyUrl;

    /**
     * Constructs a new ZarinPalPaymentVerificationService with the specified RestTemplate and API URL.
     *
     * @param restTemplate the RestTemplate used for making HTTP requests
     * @param zarinpalVerifyUrl the URL of the ZarinPal payment verification API endpoint
     */
    public ZarinPalPaymentVerificationService(RestTemplate restTemplate,
                                              @Value("${zarinpal.verify.url}") String zarinpalVerifyUrl) {
        this.restTemplate = restTemplate;
        this.zarinpalVerifyUrl = zarinpalVerifyUrl;
    }

    /**
     * Verifies a payment with ZarinPal by sending a verification request.
     *
     * @param verificationRequest the payment request DTO containing verification details
     * @return a JSON response string received from ZarinPal after verifying the payment
     */
    @Override
    protected String verifyPayment(PaymentRequestDTO verificationRequest) {
        return restTemplate.postForObject(zarinpalVerifyUrl, verificationRequest, String.class);
    }
}

