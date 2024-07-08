package com.taxi.payment.service;


import com.taxi.framework.payment.dto.PaymentRequest;
import com.taxi.framework.payment.dto.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PaymentServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PaymentService paymentService;

    public PaymentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitiatePayment() {
        // Mock response
        PaymentResponse mockResponse = new PaymentResponse();
        mockResponse.setTransactionId("12345");
        mockResponse.setStatus("SUCCESS");

        when(restTemplate.postForEntity(any(String.class), any(), any(Class.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        // Create payment request
        PaymentRequest request = new PaymentRequest();
        request.setAmount("100");
        request.setCurrency("USD");
        request.setPaymentMethod("CreditCard");

        // Call the method under test
        PaymentResponse response = paymentService.initiatePayment(request);

        // Assert the response
        assertEquals("12345", response.getTransactionId());
        assertEquals("SUCCESS", response.getStatus());
    }
}

