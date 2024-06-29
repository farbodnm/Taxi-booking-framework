package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractBanController;
import com.taxi.user.dto.ExtendedBanDTO;
import com.taxi.user.service.ExtendBanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class BanControllerImplement extends AbstractBanController<ExtendedBanDTO> {

    @Autowired
    private ExtendBanServiceImpl extendBanService;
    protected BanControllerImplement(ExtendBanServiceImpl extendBanService) {
        super(extendBanService);
    }
}
