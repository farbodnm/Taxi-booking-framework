package com.taxi.framework.booking.controller;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import com.taxi.framework.booking.service.BookingCreationService;
import com.taxi.framework.user.dto.AccessibilitySettingsDTO;
import com.taxi.framework.user.service.UserAccessibilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractBookingController<T extends BaseBookingRequestDTO, Y extends BaseBookedRequestDTO> {
    protected final BookingCreationService<T, Y> bookingCreationService;
    protected final UserAccessibilityService userAccessibilityService;

    protected AbstractBookingController(BookingCreationService<T, Y> bookingCreationService, UserAccessibilityService userAccessibilityService) {
        this.bookingCreationService = bookingCreationService;
        this.userAccessibilityService = userAccessibilityService;
    }

    @PostMapping("/book")
    public ResponseEntity<String> book(@RequestBody T dto) {
        AccessibilitySettingsDTO settings = userAccessibilityService.getAccessibilitySettings(dto.getUserId());
        return ResponseEntity.ok(bookingCreationService.createBooking(dto, settings));
    }

    @PostMapping("/booked/{userId}")
    public ResponseEntity<Y> booked(@RequestBody Y dto, @PathVariable long userId) {
        return ResponseEntity.ok(bookingCreationService.booked(dto, userId));
    }

    @GetMapping("/refresh/{userId}")
    public ResponseEntity<Y> refresh(@PathVariable long userId) {
        return ResponseEntity.ok(bookingCreationService.refresh(userId));
    }

    @PatchMapping("/nextstate/{userId}")
    public ResponseEntity<String> goToNextState(@PathVariable long userId) {
        return ResponseEntity.ok(bookingCreationService.bookingNextState(userId));
    }
}
