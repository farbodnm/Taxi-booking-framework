package com.taxi.pay.service;

import com.taxi.framework.pay.dto.PaymentRequestDTO;
import com.taxi.framework.pay.dto.PaymentResponseDTO;
import com.taxi.framework.pay.service.AbstractPaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service class for handling payment operations using ZarinPal payment gateway.
 * This class extends AbstractPaymentService to implement methods for initiating payment requests.
 *
 * @see AbstractPaymentService
 */
@Service
public class ZarinPalPaymentService extends AbstractPaymentService<PaymentRequestDTO, PaymentResponseDTO> {

    private final String zarinpalApiUrl;

    /**
     * Constructs a new ZarinPalPaymentService with the specified RestTemplate and API URL.
     *
     * @param restTemplate the RestTemplate used for making HTTP requests
     * @param zarinpalApiUrl the URL of the ZarinPal payment gateway API endpoint
     */
    @Autowired
    public ZarinPalPaymentService(RestTemplate restTemplate,
                                  @Value("${zarinpal.api.url}") String zarinpalApiUrl) {
        super(restTemplate);
        this.zarinpalApiUrl = zarinpalApiUrl;
    }

    /**
     * Retrieves the class type of the payment response DTO.
     *
     * @return the class type of PaymentResponseDTO
     */
    @Override
    protected Class<PaymentResponseDTO> getResponseType() {
        return PaymentResponseDTO.class;
    }

    /**
     * Sends a payment request to the ZarinPal payment gateway.
     *
     * @param paymentRequestDTO the payment request DTO containing payment details
     * @return a JSON response string received from ZarinPal after sending the payment request
     */
    public String sendPaymentRequest(PaymentRequestDTO paymentRequestDTO) {
        String jsonResponse = restTemplate.postForObject(zarinpalApiUrl, paymentRequestDTO, String.class);
        // Handle JSON response from ZarinPal
        return jsonResponse;
    }
}
