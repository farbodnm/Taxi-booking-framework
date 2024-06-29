package com.taxi.user.service;

import com.taxi.user.dto.ExtendedBanDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("BanService")
public class ExtendBanServiceImpl implements ExtendBanService{
    @Override
    public ExtendedBanDTO banDriver(ExtendedBanDTO dto) {
        return dto;
    }
}
