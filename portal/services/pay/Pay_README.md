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

## POST Method for Initiating Payment

To initiate a payment, use the following POST method:

**Endpoint**: `POST http://localhost:8081/payment/initiate?Content-Type=application/json`

**Request Body**:
```json
{
  "amount": "100",
  "currency": "USD",
  "paymentMethod": "CreditCard"
}
```

**Response Body**:
```json
{
    "transactionId": "12345",
    "status": "SUCCESS"
}
```

## GET Method

To connect to a page of the ZarinPal gateway, use the following GET method:

**Endpoint**: `GET http://localhost:8081/test-ip`

The output of the PHP page is as follows:

```html
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <meta http-equiv="Content-Language" content="fa">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>زرین پال | تست درگاه | تست IP</title>
    <style type="text/css">
        body {
            background: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAMAAAHpCAMAAABwXnbdAAAAt1BMVEXu7u7v7+/w8PDx8fHy8vLz8/P09PT19fX29vb39/f4+Pj5+fn6+vr71VD7+/v8zE38zU38zk38zk78z0780E/80U/80k/80lD800/801D81FD81U381U781VD81k781k/81lD8/Pz9x0r9yEr9yUv9ykv9y0v9y0z9zEz9z0790E790kn90kr900r900v91Ev91Ez91U39/f3+xEj+xUj+xUn+xkn+x0n+0Uj+0Un+0kn+/v7///+nn8ExAAABAUlEQVQ4je3I546CUBCG4aNSFLGAggpYwIJ0KdL0/q9r40mcOHtMNpvsr41v8mS+DKnrmnzXNA1p2xYEQQDCMARRFCFxHDOSJAGXy+WtNE0R0zQZlmUxNpsN3O12+2u73Y563a/W6zX1up9GoxHzezAM40er1QpZLpeUrutksVjQ+6Bp2lvz+Zz4vg88zyOz2YxSVZVSFIUxnU6RyWRCzuczcF2XOp1O1PF4ZBwOB2S/3zMcxyFVVZGyLJHr9QqKogB5noP7/f4nbrcbI8syhm3byHg8BrIsI8PhEEiShAwGA9Dv94EoikAQBITnecBxHNLr9ZBut4t0Oh3Gp0+f/l1fYlVb2B6+bYsAAAAASUVORK5CYII=') #eee repeat-x top;
            font-family: Tahoma;
            font-size: 11px;
            direction: rtl;
            margin: 0;
            padding: 0;
        }
        fieldset {
            float: right;
            width: 240px;
            border: 1px solid #ddd;
            font: 12px Tahoma;
            background: #fff;
            padding: 20px;
            margin: 50px 10px 0 0;
            text-align: center;
            height: 165px;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px 5px 5px 5px;
            border-radius: 5px 5px 5px 5px;
            margin-bottom: 10px;
        }
        fieldset legend {
            background-color: #ccc;
            font-weight: 900;
            margin-right: 14px;
            padding: 5px 30px;
        }
        input.submit {
            background: none repeat scroll 0 0 #FACE61;
            border: 1px solid #D6AB28;
            border-radius: 5px 5px 5px 5px;
            box-shadow: -1px 1px 2px rgba(0, 0, 0, .3);
            color: #2D2D2D;
            font-weight: 900;
            padding: 7px 25px;
        }
        input, button, textarea, select {
            border-radius: 3px;
            padding: 8px;
            background-color: #FFF;
            border: 1px solid #DBE1E8;
        }
        input, button, textarea, select {
            background-color: #EFEFEF;
            border: 1px solid silver;
            font: 11px tahoma;
            vertical-align: middle;
            margin: 0 0 0 2px;
            padding: 3px;
            line-height: 14px;
        }
        #flashMessage, #authMessage {
            min-height: 24px;
            _height: 24px;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            direction: rtl;
            margin: 10px 0;
            padding: 5px 30px 10px 10px;
            text-align: justify;
            clear: both;
            margin: 0 auto;
            width: 825px;
        }
        div.error-msg, div.message {
            border: 1px solid #fe9090;
            background: #feb1b1 url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAjFJREFUeNqkU0tPE1EUPvPoOHdaSSkUsYkY2xLTmpCQmJBAumBNZIFLoz+CX8Av6MpfoHHLhgXsTTWE7ohtDRhEkrGpQy0M7e3ceXnO2Db1BQtv8s3cx/m+87pXCsMQ/meo9HktSaDgnyABZBAbOF1GzA3sviDeoatthOnjgvAcnau/CT6JMbaZXVjIZ+bnU2xiQqcI+eXlonl0VDo5PHwqOC+j3c4vEQzJLJncWlpbK4SqyhzPA+fiYnhmzBYKRjqbnaru7m51f+5HIhJ5eCVJmVu6/mZ5fX2Juy4LguCv+UqYqhqG/GBvb184zrMXYWhGEWA+G3PFYv67bTPHca4tWiwWYzO5XP60VqM6vYwEPICV2+l0ymq3R4au60Kv240ghAAPU4pyVlWYnpxMEWdc4F4gyzoZlSoVME0TOp0OKIoC8XgcEokEaJoWCezkctDv9XTijIpI2h56FLYNjUYj8oah/kGmwajdaOuNd8EFOLNbrcXQsozG6uq1NUiQvRB94oxHUGk1myt3VNUwUP2mccZ5mzg0lwcC25/Pzz+BLHMDW2VQ4/8BbDFvOs4xcUYC2HWz6/vl95ZVxwPOUIQN8h2HQHL16qreC4IycUYXiS7IfVw8xtv4QJY3C5qWf6hpqaSi6GTU8f3+RyHadSGOT5BcxWac4n7EHQhQLaYQ0xmA2SJA') no-repeat 10px 50%;
            padding: 10px 10px 10px 50px;
            margin: 0 0 10px;
            color: #880000;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <!-- Page content goes here -->
</body>
</html>
```

## Conclusion

This module provides a robust and flexible foundation for integrating payment gateways into a taxi reservation framework using Spring Boot. By leveraging abstract classes and DTOs, it allows for easy extension and customization to support different payment providers.
