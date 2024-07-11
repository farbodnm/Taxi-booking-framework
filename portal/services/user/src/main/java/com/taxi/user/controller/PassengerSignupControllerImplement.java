package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractSignupController;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.user.service.PassengerSignupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/passenger")
@RestController
public class PassengerSignupControllerImplement extends AbstractSignupController<BaseUserSignupDTO> {

    @Autowired
    private PassengerSignupServiceImpl signupService;

    protected PassengerSignupControllerImplement(PassengerSignupServiceImpl signupService) {
        super(signupService);
    }
}
