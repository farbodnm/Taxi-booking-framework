package com.taxi.user.service;

import com.taxi.framework.user.dao.AvailabilityStatus;
import com.taxi.framework.user.dao.DriverDao;
import com.taxi.framework.user.dao.LicenseState;
import com.taxi.framework.user.dao.VehicleType;
import com.taxi.framework.user.dto.BaseDriverServiceDTO;
import com.taxi.framework.user.service.DriverService;
import com.taxi.user.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Qualifier("DriverService")
public class DriverServiceImpl implements DriverService<BaseDriverServiceDTO> {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    @Transactional
    public BaseDriverServiceDTO update(BaseDriverServiceDTO dto) {
        DriverDao driver = driverRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalStateException("Driver not found with ID: " + dto.getId()));
        driver.setUsername(dto.getUsername());
        driver.setPassword(dto.getPassword());
        driver.setEmail(dto.getEmail());
        driver.setPhone(dto.getPhone());
        driver.setFullName(dto.getFullName());

        driver.setVehicleType(VehicleType.valueOf(dto.getVehicleType()));
        driver.setVehicleModel(dto.getVehicleModel());
        driver.setVehicleColor(dto.getVehicleColor());
        driver.setVehicleLicensePlateNumber(dto.getVehicleLicensePlateNumber());
        driver.setVehicleLicenseExpireDate(dto.getVehicleLicenseExpireDate());

        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setLicenseExpireDate(dto.getLicenseExpireDate());
        driver.setLicenseState(LicenseState.valueOf(dto.getLicenseState()));

        driver.setInsuranceDetail(dto.getInsuranceDetail());

        driver.setRating(dto.getRating());

        driver.setAvailable(AvailabilityStatus.valueOf(dto.getAvailable()));
        driverRepository.save(driver);
        return dto;
    }

    @Override
    public BaseDriverServiceDTO findById(Long id) {
        return driverRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new IllegalStateException("Driver not found with ID: " + id));
    }

    @Override
    public List<BaseDriverServiceDTO> findAllDrivers() {
        return driverRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean verifyDriverLicense(BaseDriverServiceDTO dto) {
        return dto.getLicenseExpireDate().after(dto.getVehicleLicenseExpireDate());
    }

    private BaseDriverServiceDTO convertToDTO(DriverDao driver) {
        BaseDriverServiceDTO dto = new BaseDriverServiceDTO();
        dto.setId(driver.getId());
        dto.setUsername(driver.getUsername());
        dto.setPassword(driver.getPassword());
        dto.setEmail(driver.getEmail());
        dto.setPhone(driver.getPhone());
        dto.setFullName(driver.getFullName());
        dto.setLicenseNumber(driver.getLicenseNumber());
        dto.setLicenseExpireDate(driver.getLicenseExpireDate());
        dto.setVehicleType(driver.getVehicleType().name());
        dto.setVehicleModel(driver.getVehicleModel());
        dto.setVehicleColor(driver.getVehicleColor());
        dto.setVehicleLicensePlateNumber(driver.getVehicleLicensePlateNumber());
        dto.setVehicleLicenseExpireDate(driver.getVehicleLicenseExpireDate());
        dto.setInsuranceDetail(driver.getInsuranceDetail());
        dto.setRating(driver.getRating());
        dto.setAvailable(driver.getAvailable().toString());
        return dto;
    }

    @Override
    public boolean isDriverAvailable(Long id) {
        DriverDao driverDao = driverRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Driver not found with ID: " + id));
        return driverDao.getAvailable() == AvailabilityStatus.AVAILABLE;
    }
}
