package com.taxi.user.service;

import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.user.dto.ExtendedBanDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("CreateMockUser")
public class ExtendCreateMockUserServiceImpl implements ExtendCreateMockUserService{
    @Override
    public BaseUserSignupDTO createMockUser(BaseUserSignupDTO dto) {
        return dto;
    }
}
