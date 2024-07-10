package com.taxi.framework.user.service;

import com.taxi.framework.user.dto.BaseUserSignoutDTO;
import com.taxi.framework.user.dto.BaseUserSignupDTO;

public interface SignoutService<T extends BaseUserSignoutDTO> {
    T signOut(T dto);
}
