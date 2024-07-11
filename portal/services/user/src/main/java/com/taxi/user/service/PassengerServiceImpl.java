package com.taxi.user.service;

import com.taxi.framework.user.dao.MembershipType;
import com.taxi.framework.user.dao.PassengerDao;
import com.taxi.framework.user.dto.BasePassengerServiceDTO;
import com.taxi.framework.user.service.PassengerService;
import com.taxi.user.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService<BasePassengerServiceDTO> {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    @Transactional
    public BasePassengerServiceDTO update(BasePassengerServiceDTO dto) {
        PassengerDao passenger = passengerRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalStateException("Passenger not found with ID: " + dto.getId()));

        passenger.setUsername(dto.getUsername());
        passenger.setPassword(dto.getPassword());
        passenger.setEmail(dto.getEmail());
        passenger.setPhone(dto.getPhone());
        passenger.setFullName(dto.getFullName());
        passenger.setMembership(MembershipType.valueOf(dto.getMembership()));
        passenger.setHomeAddress(dto.getHomeAddress());

        passengerRepository.save(passenger);
        return dto;
    }

    @Override
    public List<PassengerDao> fetchAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public BasePassengerServiceDTO convertToDTO(PassengerDao passenger) {
        BasePassengerServiceDTO dto = new BasePassengerServiceDTO();
        dto.setId(passenger.getId());
        dto.setUsername(passenger.getUsername());
        dto.setPassword(passenger.getPassword());
        dto.setEmail(passenger.getEmail());
        dto.setPhone(passenger.getPhone());
        dto.setFullName(passenger.getFullName());
        dto.setMembership(passenger.getMembership().name());
        dto.setHomeAddress(passenger.getHomeAddress());
        return dto;
    }
}
