package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractCreateMockUserController;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.user.service.ExtendCreateMockUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class CreateMockUserImplement extends AbstractCreateMockUserController<BaseUserSignupDTO> {

    @Autowired
    private ExtendCreateMockUserServiceImpl extendBanService;
    protected CreateMockUserImplement(ExtendCreateMockUserServiceImpl extendCreateMockUserService) {
        super(extendCreateMockUserService);
    }
}
