package com.taxi.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}