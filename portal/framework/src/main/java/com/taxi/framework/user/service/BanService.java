package com.taxi.framework.user.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;

public interface BanService<T extends BaseDriverDTO>{
    T banDriver(T dto);

}
