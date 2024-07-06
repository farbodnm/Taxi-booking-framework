package com.taxi.framework.booking.service;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import com.taxi.framework.user.dto.AccessibilitySettingsDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBookingCreationServiceImpl<B extends BaseBookingRequestDTO, R extends BaseBookedRequestDTO> implements BookingCreationService<B, R> {

    private Map<Long, R> assignedDriversMap = new HashMap<>();

    private final String dispatchEndpoint;

    protected AbstractBookingCreationServiceImpl(String dispatchEndpoint) {
        this.dispatchEndpoint = dispatchEndpoint;
    }

    @Override
    public String createBooking(B bookingRequestDTO, AccessibilitySettingsDTO settings) {
        if (settings != null) {
            if (settings.isScreenReaderEnabled()) {
                // Apply screen reader specific logic
            }
            if (settings.isVoiceCommandEnabled()) {
                // Apply voice command specific logic
            }
        }

        String url = dispatchEndpoint + "/dispatch/find/driver";
        RestTemplate restTemplate = new RestTemplate();
        if (restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(bookingRequestDTO),
                Void.class
        ).getStatusCode() == HttpStatus.OK) {

            R bookedRequest = createBookedRequestDTO();
            bookedRequest.setMessage(BaseBookedRequestDTO.MessageEnum.LOOKING_FOR_A_DRIVER);
            assignedDriversMap.put(bookingRequestDTO.getUserId(), bookedRequest);

            return "Booking request successful.";
        }
        return "Booking request failed";
    }

    @Override
    public R booked(R bookedRequestDTO, long userId) {
        bookedRequestDTO.setMessage(BaseBookedRequestDTO.MessageEnum.DRIVER_ON_THE_WAY);
        assignedDriversMap.put(userId, bookedRequestDTO);
        return bookedRequestDTO;
    }

    protected abstract R createBookedRequestDTO();
}
