package com.taxi.framework.user.controller;

import com.taxi.framework.user.dto.BasePassengerServiceDTO;
import com.taxi.framework.user.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractPassengerController<T extends BasePassengerServiceDTO> {
    protected final PassengerService<T> passengerService;

    protected AbstractPassengerController(PassengerService<T> passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody T dto) {
        try {
            T updatedDto = passengerService.update(dto);
            return ResponseEntity.ok(updatedDto);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(404).body(e.toString());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(403).body(e.toString());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<T>> fetchAll() {
        List<T> allPassengers = passengerService.fetchAllPassengers().stream()
                .map(passengerService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(allPassengers);
    }
}
