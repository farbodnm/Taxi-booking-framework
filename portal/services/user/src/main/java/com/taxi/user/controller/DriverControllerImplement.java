package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractDriverController;
import com.taxi.framework.user.dto.BaseDriverServiceDTO;
import com.taxi.user.service.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/driver")
@RestController
public class DriverControllerImplement extends AbstractDriverController<BaseDriverServiceDTO> {

    @Autowired
    private DriverServiceImpl driverService;

    protected DriverControllerImplement(DriverServiceImpl driverService) {
        super(driverService);
    }

    @Override
    public ResponseEntity<BaseDriverServiceDTO> getDriverById(Long id) {
        try {
            BaseDriverServiceDTO driver = driverService.findById(id);
            return ResponseEntity.ok(driver);
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
