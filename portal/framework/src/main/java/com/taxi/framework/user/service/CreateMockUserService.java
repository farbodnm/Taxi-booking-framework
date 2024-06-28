package com.taxi.framework.user.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.user.dto.BaseUserSignupDTO;

public interface CreateMockUserService<T extends BaseUserSignupDTO>{
    T createMockUser(T dto);

}
