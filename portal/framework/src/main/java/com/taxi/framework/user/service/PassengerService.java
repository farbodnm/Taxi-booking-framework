package com.taxi.framework.user.service;

import com.taxi.framework.user.dto.BasePassengerServiceDTO;
import com.taxi.framework.user.dao.PassengerDao;
import java.util.List;

public interface PassengerService<T extends BasePassengerServiceDTO> {
    T update(T dto);
    List<PassengerDao> fetchAllPassengers();
    T convertToDTO(PassengerDao passenger);
}
