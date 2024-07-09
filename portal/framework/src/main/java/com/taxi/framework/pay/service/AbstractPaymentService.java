package com.taxi.framework.pay.service;

import com.taxi.framework.pay.dto.PaymentRequest;
import com.taxi.framework.pay.dto.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractPaymentService<T extends PaymentRequest, R extends PaymentResponse> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractPaymentService.class);

    @Value("${payment.gateway.url}")
    protected String paymentGatewayUrl;

    @Value("${payment.gateway.merchantId}")
    protected String merchantId;

    @Value("${payment.gateway.apiKey}")
    protected String apiKey;

    @Value("${payment.gateway.callbackUrl}")
    protected String callbackUrl;

    protected final RestTemplate restTemplate;

    protected AbstractPaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

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

    protected abstract Class<R> getResponseType();
}
