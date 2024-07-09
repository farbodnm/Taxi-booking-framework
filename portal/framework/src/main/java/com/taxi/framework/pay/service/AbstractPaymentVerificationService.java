package com.taxi.framework.pay.service;

public abstract class AbstractPaymentVerificationService<T, R> {

    protected abstract R verifyPayment(T verificationRequest);
}
