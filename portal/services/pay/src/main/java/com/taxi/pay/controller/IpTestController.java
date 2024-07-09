package com.taxi.pay.controller;

import com.taxi.framework.pay.dto.PaymentRequest;
import com.taxi.pay.service.ZarinPalPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IpTestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test-ip")
    public ResponseEntity<String> testIp() {
        String url = "http://localhost:8080/ip.php";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @Autowired
    private ZarinPalPaymentService paymentService;

    @PostMapping("/request")
    public ResponseEntity<String> requestPayment(@RequestBody PaymentRequest paymentRequest) {
        String response = paymentService.sendPaymentRequest(paymentRequest);
        // Handle response from payment service, e.g., return it to client or process further
        return ResponseEntity.ok(response);
    }
}