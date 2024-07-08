package com.taxi.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxi.framework.payment.dto.PaymentRequest;
import com.taxi.framework.payment.dto.PaymentResponse;
import com.taxi.payment.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

    @Test
    public void testInitiatePayment() throws Exception {
        // Mock response
        PaymentResponse mockResponse = new PaymentResponse();
        mockResponse.setTransactionId("12345");
        mockResponse.setStatus("SUCCESS");

        Mockito.when(paymentService.initiatePayment(Mockito.any(PaymentRequest.class)))
                .thenReturn(mockResponse);

        // Create payment request
        PaymentRequest request = new PaymentRequest();
        request.setAmount("100");
        request.setCurrency("USD");
        request.setPaymentMethod("CreditCard");

        // Convert request to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(request);

        // Perform the POST request
        mockMvc.perform(post("/payment/initiate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value("12345"))
                .andExpect(jsonPath("$.status").value("SUCCESS"));
    }
}

