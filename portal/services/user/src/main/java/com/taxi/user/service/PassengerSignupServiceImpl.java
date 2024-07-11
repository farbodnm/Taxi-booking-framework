package com.taxi.user.service;

import com.taxi.framework.user.dao.DriverDao;
import com.taxi.framework.user.dao.PassengerDao;
import com.taxi.framework.user.dao.UserDao;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.framework.user.service.SignupService;
import com.taxi.user.repository.DriverRepository;
import com.taxi.user.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PassengerSignupService")
public class PassengerSignupServiceImpl implements SignupService<BaseUserSignupDTO> {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public BaseUserSignupDTO signUp(BaseUserSignupDTO dto) {
        PassengerDao passengerDao = new PassengerDao();
        passengerDao.setUsername(dto.getUsername());
        passengerDao.setPassword(dto.getPassword());
        passengerDao.setEmail(dto.getEmail());
        passengerDao.setDateOfBirth(dto.getDateOfBirth());
        passengerRepository.save(passengerDao);
        return dto;
    }

}
