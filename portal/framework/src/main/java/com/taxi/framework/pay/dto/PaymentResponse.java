package com.taxi.framework.pay.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentResponse {
    // Define the fields for payment response
    private String transactionId;
    private String status;

}
