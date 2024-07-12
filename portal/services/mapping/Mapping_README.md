# Mapping Integration Module for Taxi Reservation Framework

## Overview

This module provides mapping and geocoding functionalities for a taxi reservation framework using Spring Boot.
It integrates with the Neshan API to provide direction services and reverse geocoding capabilities.

## Features

- **Direction Services**: Retrieve route information between two locations.
- **Reverse Geocoding**: Convert geographic coordinates into a human-readable address.

## Architecture

### Controller Layer

The controller layer handles HTTP requests and invokes the services to fetch data from the Neshan API.

- **AbstractMappingController**: Defines the endpoints for directions and reverse geocoding.
- **MappingController**: Extends `AbstractMappingController` to create REST endpoints.

### Service Layer

The service layer contains the business logic for interacting with the Neshan API.

- **AbstractMappingService**: Provides methods to call the Neshan API for directions and reverse geocoding.
- **MappingService**: Extends `AbstractMappingService` to implement the methods.

### Data Transfer Objects (DTOs)

DTOs are used to transfer data between layers.

- **DirectionsRequestDTO**: Contains parameters for direction requests.
- **DirectionsResponseDTO**: Contains the response for direction requests.
- **ReverseGeocodingRequestDTO**: Contains parameters for reverse geocoding requests.
- **ReverseGeocodingResponseDTO**: Contains the response for reverse geocoding requests.

### Configuration

- **AppConfig**: Configures the `RestTemplate` bean used to make HTTP requests.

## Usage

### Directions Endpoint

Retrieve directions between two locations.

**Request**
```http
GET https://api.neshan.org/v4/directions?origin={origin}&destination={destination}&type={type}&withTraffic={withTraffic}

Header:
    Api_key: YOUR_API_KEY
```

**Parameters**
- `origin` (String): Starting point.
- `destination` (String): Destination point.
- `type` (String): Type of route (e.g., "car", "walking").
- `withTraffic` (boolean, optional): Include traffic information (default is `true`).

**Response**
```json
{
  "route": "route information"
}
```

**Example for response of direction**
```json
{
  "routes": [
    {
      "overview_polyline": {
        "points": "kz{xEggtxHn@E|@iAtMcAq@k`Ap@yO_OyA"
      },
      "legs": [
        {
          "summary": "روانمهر - ولیعصر",
          "distance": {
            "value": 1820.0,
            "text": "۲ کیلومتر"
          },
          "duration": {
            "value": 487.0,
            "text": "۸ دقیقه"
          },
          "steps": [
            {
              "name": "میدان انقلاب اسلامی",
              "instruction": "در جهت جنوب در میدان انقلاب اسلامی قرار بگیرید",
              "bearing_after": 193,
              "type": "depart",
              "modifier": "left",
              "distance": {
                "value": 61.0,
                "text": "۷۵ متر"
              },
              "duration": {
                "value": 13.0,
                "text": "کمتر از ۱ دقیقه"
              },
              "polyline": "kz{xEggtxHHBRAPGPMJSDS",
              "start_location": [
                51.390755,
                35.701021
              ]
            },
            {
              "name": "",
              "instruction": "به مسیر خود ادامه دهید",
              "bearing_after": 147,
              "type": "exit rotary",
              "modifier": "slight right",
              "exit": 1,
              "distance": {
                "value": 279.0,
                "text": "۳۰۰ متر"
              },
              "duration": {
                "value": 72.0,
                "text": "۱ دقیقه"
              },
              "polyline": "ww{xEcitxHXSf@Ih@EvCS~AMjCQ",
              "start_location": [
                51.391063,
                35.700596
              ]
            },
            {
              "name": "روانمهر",
              "instruction": "به سمت روانمهر، به چپ بپیچید",
              "bearing_after": 80,
              "type": "turn",
              "modifier": "left",
              "distance": {
                "value": 983.0,
                "text": "۱۰۰۰ متر"
              },
              "duration": {
                "value": 261.0,
                "text": "۴ دقیقه"
              },
              "polyline": "gh{xE{ktxHASC]AkB?_@A}AGgJAy@?q@AQAiCEmFEoCAwCCmGAcBAcB?EAaBAkA?mA",
              "start_location": [
                51.391498,
                35.698122
              ]
            },
            {
              "name": "خسرو شکیبایی",
              "instruction": "در خسرو شکیبایی به مسیر خود ادامه دهید",
              "bearing_after": 95,
              "type": "new name",
              "modifier": "straight",
              "distance": {
                "value": 210.0,
                "text": "۲۲۵ متر"
              },
              "duration": {
                "value": 78.0,
                "text": "۱ دقیقه"
              },
              "polyline": "yi{xEuovxHXuFVuE",
              "start_location": [
                51.402349,
                35.698366
              ]
            },
            {
              "name": "ولیعصر",
              "instruction": "به چپ بپیچید و وارد ولیعصر شوید",
              "bearing_after": 7,
              "type": "end of road",
              "modifier": "left",
              "distance": {
                "value": 288.0,
                "text": "۳۰۰ متر"
              },
              "duration": {
                "value": 130.0,
                "text": "۲ دقیقه"
              },
              "polyline": "gh{xEa~vxHgAK{BUcCU_AKwBU",
              "start_location": [
                51.404651,
                35.698117
              ]
            },
            {
              "name": "ولیعصر",
              "instruction": "در مقصد قرار دارید",
              "bearing_after": 0,
              "type": "arrive",
              "distance": {
                "value": 0.0,
                "text": ""
              },
              "duration": {
                "value": 0.0,
                "text": ""
              },
              "polyline": "gx{xE{`wxH",
              "start_location": [
                51.405102,
                35.700682
              ]
            }
          ]
        }
      ]
    }
  ]
}
```


### Reverse Geocoding Endpoint

Convert geographic coordinates to a human-readable address.

**Request**
```http
GET https://api.neshan.org/v5/reverse-geocoding?lat={lat}&lng={lng}
```

**Parameters**
- `lat` (double): Latitude.
- `lng` (double): Longitude.

**Response**
```json
{
  "address": "formatted address"
}
```

**Example for response of reverse geocoding**
```json
{
    "status": "OK",
    "formatted_address": "تهران، دکتر فاطمی، حجاب، سازمان آب، بین دائمی و عبداله زاده",
    "route_name": "سازمان آب",
    "route_type": "secondary",
    "neighbourhood": "فاطمي",
    "city": "تهران",
    "state": "استان تهران",
    "place": null,
    "municipality_zone": "6",
    "in_traffic_zone": "true",
    "in_odd_even_zone": "true",
    "village": null,
    "county": "شهرستان تهران",
    "district": "بخش مرکزی شهرستان تهران"
}
```
## API Endpoints

### Directions
- **URL**: `/api/v1/directions`
- **Method**: `GET`
- **Description**: Retrieves route information between the specified origin and destination.

### Reverse Geocoding
- **URL**: `/api/v1/reverse-geocoding`
- **Method**: `GET`
- **Description**: Converts latitude and longitude into a human-readable address.

---

This module is designed to be extendable and can be integrated with other mapping and geocoding services by extending
the abstract service and controller classes. Ensure to handle exceptions properly and validate API responses for a
robust implementation.
