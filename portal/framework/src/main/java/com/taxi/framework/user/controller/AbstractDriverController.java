package com.taxi.framework.user.controller;

import com.taxi.framework.user.dto.BaseDriverServiceDTO;
import com.taxi.framework.user.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractDriverController<T extends BaseDriverServiceDTO> {

    protected final DriverService<T> driverService;

    protected AbstractDriverController(DriverService<T> driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateDriver(@RequestBody T dto) {
        try {
            T updatedDto = driverService.update(dto);
            return ResponseEntity.ok(updatedDto);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(404).body(e.toString());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(403).body(e.toString());
        }
    }

    @GetMapping("/{id}")
    public abstract ResponseEntity<T> getDriverById(@PathVariable Long id);

    @GetMapping("/all")
    public ResponseEntity<List<T>> getAllDrivers() {
        List<T> drivers = driverService.findAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> verifyDriverLicense(@RequestBody T dto) {
        boolean verified = driverService.verifyDriverLicense(dto);
        return ResponseEntity.ok(verified);
    }

    @GetMapping("/available/{id}")
    public ResponseEntity<Boolean> isDriverAvailable(@PathVariable Long id) {
        boolean available = driverService.isDriverAvailable(id);
        return ResponseEntity.ok(available);
    }
}
