package com.taxi.framework.payment.service;

import com.taxi.framework.payment.dto.PaymentRequest;
import com.taxi.framework.payment.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractPaymentService<T extends PaymentRequest, R extends PaymentResponse> {

    @Value("${payment.gateway.url}")
    protected String paymentGatewayUrl;

    @Value("${payment.gateway.apiKey}")
    protected String apiKey;

    protected final RestTemplate restTemplate;

    protected AbstractPaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public R initiatePayment(T request) {
        HttpHeaders headers = createHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<T> entity = new HttpEntity<>(request, headers);

        ResponseEntity<R> response = restTemplate.postForEntity(paymentGatewayUrl, entity, getResponseType());
        return response.getBody();
    }

    protected abstract Class<R> getResponseType();

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        return headers;
    }

    // Other common methods for handling callbacks, status checks, etc.
}
