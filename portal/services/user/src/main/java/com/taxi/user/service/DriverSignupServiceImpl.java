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
public class DriverSignupServiceImpl implements SignupService<BaseUserSignupDTO> {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public BaseUserSignupDTO signUp(BaseUserSignupDTO dto) {
        DriverDao userDao = new DriverDao();
        userDao.setUsername(dto.getUsername());
        userDao.setPassword(dto.getPassword());
        userDao.setEmail(dto.getEmail());
        userDao.setDateOfBirth(dto.getDateOfBirth());
        driverRepository.save(userDao);
        return dto;
    }

}
