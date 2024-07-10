# Payment Integration Module for Taxi Reservation Framework

## Overview

This module provides payment integration for a taxi reservation framework using JavaSpring.
It includes the necessary components for initiating payments, handling payment callbacks, and verifying payment status.
The module is designed to be flexible and extendable, allowing the integration of different payment gateways with
minimal changes.

## Structure

The module is organized into two main folders: `framework` and `service`.

### Framework Folder

Contains abstract classes and DTOs defining the core functionality for payment operations.

1. **Controller:**
    - `AbstractPaymentController<T extends PaymentRequestDTO, R extends PaymentResponseDTO>`
        - Handles common endpoints for initiating payments and handling payment callbacks.

2. **DTO:**
    - `PaymentRequestDTO`
        - Represents a payment request containing details about the payment.
    - `PaymentResponseDTO`
        - Represents a payment response containing transaction details and status.

3. **Service:**
    - `AbstractPaymentService<T extends PaymentRequestDTO, R extends PaymentResponseDTO>`
        - Defines common methods for initiating payments through a payment gateway.
    - `AbstractPaymentVerificationService<T, R>`
        - Defines a method for verifying payments.

### Service Folder

Contains the specific implementation for the ZarinPal payment gateway and application configurations.

1. **Configuration:**
    - `PaymentAppConfig`
        - Defines beans for configuring application components, including `RestTemplate`.

2. **Controller:**
    - `IpTestController`
        - Endpoint for testing IP retrieval and handling payment requests using `ZarinPalPaymentService`.
    - `PayErrorController`
        - Handles custom error pages related to payment errors.
    - `PaymentController`
        - Extends `AbstractPaymentController` to handle payment-related operations using `ZarinPalPaymentService`.

3. **Service:**
    - `ZarinPalPaymentService`
        - Extends `AbstractPaymentService` to implement methods for initiating payment requests using ZarinPal.
    - `ZarinPalPaymentVerificationService`
        - Extends `AbstractPaymentVerificationService` to implement payment verification functionality using ZarinPal.

4. **Application:**
    - `PayApplication`
        - Main application class to run the Spring Boot application.

## Detailed Description

### AbstractPaymentController

Handles common endpoints for initiating payments and handling payment callbacks.

- **initiatePayment**
    - Endpoint: `/initiate`
    - Method: POST
    - Description: Initiates a payment request.
    - Request Body: `PaymentRequestDTO`
    - Response: `PaymentResponseDTO`

- **handleCallback**
    - Endpoint: `/callback`
    - Method: POST
    - Description: Handles payment callback notifications.
    - Request Body: `PaymentResponseDTO`
    - Response: String confirmation message.

### DTOs

1. **PaymentRequestDTO**
    - Fields:
        - `amount`: String
        - `currency`: String
        - `paymentMethod`: String
        - `mobile`: String
        - `email`: String

2. **PaymentResponseDTO**
    - Fields:
        - `transactionId`: String
        - `status`: String

### AbstractPaymentService

Defines common methods for initiating payments through a payment gateway.

- **initiatePayment**
    - Sends a payment request to the payment gateway.
    - Constructs the request payload and headers.
    - Logs request details and handles exceptions.
    - Returns the payment response.

### AbstractPaymentVerificationService

Defines a method for verifying payments.

- **verifyPayment**
    - Verifies a payment based on the provided verification request.
    - Returns the payment verification response.

### ZarinPalPaymentService

Implements methods for initiating payment requests using ZarinPal.

- **getResponseType**
    - Returns the class type of the payment response DTO.

- **sendPaymentRequest**
    - Sends a payment request to the ZarinPal payment gateway.
    - Constructs the request payload and sends it using `RestTemplate`.
    - Returns the JSON response from ZarinPal.

### ZarinPalPaymentVerificationService

Implements payment verification functionality using ZarinPal.

- **verifyPayment**
    - Sends a verification request to the ZarinPal payment gateway.
    - Constructs the request payload and sends it using `RestTemplate`.
    - Returns the JSON response from ZarinPal.

## Running the Application

1. Ensure that the necessary dependencies are included in your `pom.xml` file.
2. Configure the application properties for the payment gateway (e.g., `application.properties`):
   ```properties
   payment.gateway.url=https://sandbox.zarinpal.com/pg/v4/payment/request.json
   payment.gateway.merchantId=YOUR_MERCHANT_ID
   payment.gateway.apiKey=YOUR_API_KEY
   payment.gateway.callbackUrl=YOUR_CALLBACK_URL
   ```
3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Endpoints

1. **Test IP Retrieval:**
    - URL: `/test-ip`
    - Method: GET
    - Description: Retrieves IP address from a local PHP script.

2. **Initiate Payment:**
    - URL: `/payment/initiate`
    - Method: POST
    - Description: Initiates a payment request.
    - Request Body: `PaymentRequestDTO`

3. **Payment Callback:**
    - URL: `/payment/callback`
    - Method: POST
    - Description: Handles payment callback notifications.
    - Request Body: `PaymentResponseDTO`

4. **Custom Error Pages:**
    - URL: `/error`
    - Method: GET
    - Description: Handles custom error pages for different HTTP status codes.

## Conclusion

This module provides a robust and flexible foundation for integrating payment gateways into a taxi reservation framework using Spring Boot. By leveraging abstract classes and DTOs, it allows for easy extension and customization to support different payment providers.