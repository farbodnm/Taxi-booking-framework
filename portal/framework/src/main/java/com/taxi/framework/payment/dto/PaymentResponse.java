package com.taxi.framework.payment.dto;

public class PaymentResponse {
    // Define the fields for payment response
    private String transactionId;
    private String status;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters and setters
    // Constructors, etc.
}
