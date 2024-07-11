package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractSignoutController;
import com.taxi.framework.user.dto.BaseUserSignoutDTO;
import com.taxi.user.service.SignoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class SignoutControllerImplement extends AbstractSignoutController<BaseUserSignoutDTO> {

    @Autowired
    private SignoutServiceImpl signoutService;

    protected SignoutControllerImplement(SignoutServiceImpl signooutService) {
        super(signooutService);
    }
}
