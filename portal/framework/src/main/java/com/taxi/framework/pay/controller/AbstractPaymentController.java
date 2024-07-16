package com.taxi.framework.pay.controller;

import com.taxi.framework.pay.dto.PaymentRequestDTO;
import com.taxi.framework.pay.dto.PaymentResponseDTO;
import com.taxi.framework.pay.service.AbstractPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Abstract base controller for handling payment-related operations.
 * This controller defines common endpoints for initiating payments and handling payment callbacks.
 *
 * @param <T> the type of the payment request
 * @param <R> the type of the payment response
 */
public abstract class AbstractPaymentController<T extends PaymentRequestDTO, R extends PaymentResponseDTO> {

    /**
     * The service responsible for processing payment requests and responses.
     */
    protected final AbstractPaymentService<T, R> paymentService;

    /**
     * Constructs a new AbstractPaymentController with the specified payment service.
     *
     * @param paymentService the payment service to use for processing payment requests and responses
     */
    protected AbstractPaymentController(AbstractPaymentService<T, R> paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Endpoint for initiating a payment.
     *
     * @param request the payment request
     * @return a ResponseEntity containing the payment response
     */
    @PostMapping("/initiate")
    public ResponseEntity<R> initiatePayment(@RequestBody T request) {
        R response = paymentService.initiatePayment(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles the payment callback by validating the callback request
     * and updating the payment status in the system.
     *
     * @param paymentResponseDTO the payment response from the callback
     * @return a ResponseEntity containing the payment response
     */
    @PostMapping("/callback")
    public ResponseEntity<R> handleCallback(@RequestBody PaymentResponseDTO paymentResponseDTO) {
        // Validate the callback
        // Update payment status in your system

        @SuppressWarnings("unchecked")
        R response = (R) paymentResponseDTO;
        return ResponseEntity.ok(response);
    }

    // Other common methods for handling payment-related operations
}
