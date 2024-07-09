package com.taxi.framework.pay.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentRequest {
    // Define the fields for payment request
    private String amount;
    private String currency;
    private String paymentMethod;
    private String mobile;
    private String email;
}

