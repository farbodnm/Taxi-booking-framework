package com.taxi.framework.user.service;

import com.taxi.framework.user.dto.BaseDriverServiceDTO;

import java.util.List;

public interface DriverService<T extends BaseDriverServiceDTO> {
    T update(T dto);
    T findById(Long id);
    List<T> findAllDrivers();
    boolean verifyDriverLicense(T dto);
    boolean isDriverAvailable(Long id);
}
