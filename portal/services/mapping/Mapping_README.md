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
GET /api/v1/directions?origin={origin}&destination={destination}&type={type}&withTraffic={withTraffic}
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

### Reverse Geocoding Endpoint

Convert geographic coordinates to a human-readable address.

**Request**
```http
GET /api/v1/reverse-geocoding?lat={lat}&lng={lng}
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