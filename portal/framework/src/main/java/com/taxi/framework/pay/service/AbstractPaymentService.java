package com.taxi.framework.pay.service;

import com.taxi.framework.pay.dto.PaymentRequestDTO;
import com.taxi.framework.pay.dto.PaymentResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * Abstract base service for handling payment-related operations.
 * This service defines common methods for initiating payments through a payment gateway.
 *
 * @param <T> the type of the payment request
 * @param <R> the type of the payment response
 */
public abstract class AbstractPaymentService<T extends PaymentRequestDTO, R extends PaymentResponseDTO> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractPaymentService.class);

    /**
     * The URL of the payment gateway.
     */
    @Value("${payment.gateway.url}")
    protected String paymentGatewayUrl;

    /**
     * The merchant ID for the payment gateway.
     */
    @Value("${payment.gateway.merchantId}")
    protected String merchantId;

    /**
     * The API key for the payment gateway.
     */
    @Value("${payment.gateway.apiKey}")
    protected String apiKey;

    /**
     * The callback URL for the payment gateway.
     */
    @Value("${payment.gateway.callbackUrl}")
    protected String callbackUrl;

    /**
     * The RestTemplate for making HTTP requests.
     */
    protected final RestTemplate restTemplate;

    /**
     * Constructs a new AbstractPaymentService with the specified RestTemplate.
     *
     * @param restTemplate the RestTemplate to use for making HTTP requests
     */
    protected AbstractPaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Initiates a payment by sending a request to the payment gateway.
     *
     * @param request the payment request
     * @return the payment response
     */
    public R initiatePayment(T request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = paymentGatewayUrl;
        String jsonPayload = String.format(
                "{\"MerchantID\":\"%s\",\"Amount\":\"%s\",\"Description\":\"Product Sale\",\"Email\":\"%s\",\"Mobile\":\"%s\",\"CallbackURL\":\"%s\"}",
                merchantId, request.getAmount(), request.getEmail(), request.getMobile(), callbackUrl
        );

        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

        try {
            logger.info("Calling payment gateway URL: {}", url);
            logger.info("Payload: {}", jsonPayload);
            return restTemplate.postForObject(url, entity, getResponseType());
        } catch (Exception e) {
            logger.error("Error during payment initiation", e);
            throw new RuntimeException("Payment initiation failed", e);
        }
    }

    /**
     * Gets the response type for the payment response.
     *
     * @return the class of the payment response
     */
    protected abstract Class<R> getResponseType();
}
