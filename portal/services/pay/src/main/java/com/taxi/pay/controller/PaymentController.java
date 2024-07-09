package com.taxi.pay.controller;

import com.taxi.framework.pay.controller.AbstractPaymentController;
import com.taxi.framework.pay.dto.PaymentRequestDTO;
import com.taxi.framework.pay.dto.PaymentResponseDTO;
import com.taxi.pay.service.ZarinPalPaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller class for handling payment-related operations.
 * This class extends AbstractPaymentController to define endpoints for initiating payments.
 *
 * @see AbstractPaymentController
 */
@RestController
@RequestMapping("/payment")
public class PaymentController extends AbstractPaymentController<PaymentRequestDTO, PaymentResponseDTO> {

    /**
     * Constructs a new PaymentController with the specified payment service.
     *
     * @param paymentService the payment service used for processing payment requests and responses
     */
    @Autowired
    public PaymentController(ZarinPalPaymentService paymentService) {
        super(paymentService);
    }

    /**
     * Endpoint for initiating a payment request.
     *
     * @param request the payment request DTO containing payment details
     * @return a ResponseEntity containing the payment response DTO
     */
    @PostMapping("/initiate")
    @Override
    public ResponseEntity<PaymentResponseDTO> initiatePayment(@RequestBody PaymentRequestDTO request) {
        return super.initiatePayment(request);
    }

    // Implement other specific endpoints if needed
}
