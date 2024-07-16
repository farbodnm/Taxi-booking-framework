package com.taxi.framework.pay.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Represents a payment response containing the transaction details and status.
 * This class is used to capture the information returned by the payment gateway after a payment request.
 */
@Getter
@Setter
@NoArgsConstructor
public class PaymentResponseDTO {

    /**
     * The unique identifier for the transaction.
     */
    private String transactionId;

    /**
     * The status of the transaction.
     */
    private String status;
}
