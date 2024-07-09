package com.taxi.pay.controller;

import com.taxi.framework.pay.dto.PaymentRequestDTO;
import com.taxi.pay.service.ZarinPalPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Controller class for testing IP and handling payment requests.
 * This class defines endpoints for testing IP retrieval and handling payment requests using ZarinPalPaymentService.
 */
@RestController
public class IpTestController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Endpoint for testing IP retrieval from a local PHP script.
     *
     * @return a ResponseEntity containing the IP address as a string
     */
    @GetMapping("/test-ip")
    public ResponseEntity<String> testIp() {
        String url = "http://localhost:8080/ip.php";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @Autowired
    private ZarinPalPaymentService paymentService;

    /**
     * Endpoint for initiating a payment request using ZarinPalPaymentService.
     *
     * @param paymentRequestDTO the payment request DTO containing payment details
     * @return a ResponseEntity containing the response from the payment service
     */
    @PostMapping("/request")
    public ResponseEntity<String> requestPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        String response = paymentService.sendPaymentRequest(paymentRequestDTO);
        // Handle response from payment service, e.g., return it to client or process further
        return ResponseEntity.ok(response);
    }
}
