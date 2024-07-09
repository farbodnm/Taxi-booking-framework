package com.taxi.framework.pay.service;

/**
 * Abstract base service for handling payment verification operations.
 * This service defines a method for verifying payments.
 *
 * @param <T> the type of the payment verification request
 * @param <R> the type of the payment verification response
 */
public abstract class AbstractPaymentVerificationService<T, R> {

    /**
     * Verifies a payment based on the provided verification request.
     *
     * @param verificationRequest the payment verification request
     * @return the payment verification response
     */
    protected abstract R verifyPayment(T verificationRequest);
}
