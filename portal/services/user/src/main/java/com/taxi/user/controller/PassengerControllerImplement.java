package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractPassengerController;
import com.taxi.framework.user.dto.BasePassengerServiceDTO;
import com.taxi.user.service.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/passenger")
@RestController
public class PassengerControllerImplement extends AbstractPassengerController<BasePassengerServiceDTO> {

    @Autowired
    private PassengerServiceImpl passengerService;

    protected PassengerControllerImplement(PassengerServiceImpl passengerService) {
        super(passengerService);
    }
}
