package com.taxi.framework.notification.service;

import com.taxi.framework.notification.controller.dto.UserCreateDTO;
import com.taxi.framework.notification.model.User;

public interface IUserService {
    User createUser(UserCreateDTO dto);

    User getUserById(Long id);
}
