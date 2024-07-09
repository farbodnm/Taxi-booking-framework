package com.taxi.framework.pay.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Represents a payment request containing details about the payment.
 * This class is used to capture the necessary information required to initiate a payment.
 */
@Getter
@Setter
@NoArgsConstructor
public class PaymentRequestDTO {

    /**
     * The amount to be paid.
     */
    private String amount;

    /**
     * The currency in which the payment is to be made.
     */
    private String currency;

    /**
     * The method of payment (e.g., credit card, bank transfer).
     */
    private String paymentMethod;

    /**
     * The mobile number of the payer.
     */
    private String mobile;

    /**
     * The email address of the payer.
     */
    private String email;
}

