# SMS Integration Module for Taxi Reservation Framework

## Overview

The SMS Integration Module is a critical component of the Taxi Reservation Framework. It enables the system to send SMS notifications to users for various events such as booking confirmations, driver arrival notifications, and trip completions.

## Features

- **Send SMS**: Send customizable SMS messages to users.
- **Error Handling**: Properly handles errors during the SMS sending process and provides meaningful responses.
- **Integration with SMS Gateways**: Supports integration with third-party SMS gateways using HTTP APIs.

## Module Structure

### Framework Folder

#### 1. Controller
**AbstractSmsController.java**

This abstract controller class provides a common structure for handling SMS requests. It declares an abstract method `sendSms` which takes an `SmsRequestDTO` as input and returns a `ResponseEntity<String>`.

#### 2. DTO
**SmsRequestDTO.java**

This DTO class represents the structure of an SMS request. It includes the mobile number, template ID, and a list of parameters to be included in the message.

#### 3. Service
**AbstractSmsService.java**

This abstract service class defines the structure for sending SMS messages. It includes the API URL and key and declares an abstract method `sendSms` which handles the actual sending of the SMS.

### Service Folder

#### 1. Controller Implementation
**Controller.java**

This class implements the abstract controller and provides an endpoint (`/api/sms/send`) for handling SMS requests. It uses the `AbstractSmsService` to send SMS messages and handles potential IOExceptions.

#### 2. Service Implementation
**ServiceImp.java**

This class implements the abstract SMS service, sending SMS messages using OkHttpClient to interact with a third-party SMS API.

### Main Application
**SmsApplication.java**

This is the entry point of the SMS application, bootstrapping the Spring Boot application.

## Usage

Send a POST request to `/api/sms/send` with the following JSON body:

```json
{
  "mobile": "09165874525",
  "templateId": "template-id",
  "parameters": [
    {
      "name": "param1",
      "value": "value1"
    },
    {
      "name": "param2",
      "value": "value2"
    }
  ]
}
```

The system will process the request and send an SMS based on the provided template and parameters.