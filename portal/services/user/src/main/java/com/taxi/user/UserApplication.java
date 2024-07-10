package com.taxi.user;

import com.taxi.framework.user.dao.*;
import com.taxi.user.repository.DriverRepository;
import com.taxi.user.repository.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EntityScan("com.taxi.framework.user.dao")
public class UserApplication {
    private static final Logger logger = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Bean
    @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {
            logger.info("Initializing Objects");

            logger.info("deleting all drivers");
            driverRepository.deleteAll();

            logger.info("deleting all passengers");
            passengerRepository.deleteAll();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            DriverDao driverDao01 = new DriverDao();
            driverDao01.setUsername("ali");
            driverDao01.setPassword("pass1");
            driverDao01.setEmail("ali@gmail.com");
            driverDao01.setDateOfBirth(dateFormat.parse("2003-01-01"));
            driverDao01.setSignInStatus("signed out");
            driverDao01.setPhone("0902 222 2222");
            driverDao01.setRole(UserRole.valueOf("DRIVER"));
            driverDao01.setFullName("Ali Karimi");

            driverDao01.setVehicleType(VehicleType.valueOf("SEDAN"));
            driverDao01.setVehicleModel("khoob");
            driverDao01.setVehicleColor("meshki");
            driverDao01.setVehicleLicensePlateNumber("A2017");
            driverDao01.setVehicleLicenseExpireDate(dateFormat.parse("2023-10-01"));
            driverDao01.setVehicleLicenseState("valid");

            driverDao01.setLicenseNumber("10203040");
            driverDao01.setLicenseExpireDate(dateFormat.parse("2025-01-01"));
            driverDao01.setLicenseState(LicenseState.valueOf("VALID"));

            driverDao01.setInsuranceDetail("ok");
            driverDao01.setRating(2.5);
            driverDao01.setAvailable(AvailabilityStatus.valueOf("UNAVAILABLE"));
            driverRepository.save(driverDao01);
            logger.info("driver inserted");

            driverDao01 = new DriverDao();
            driverDao01.setUsername("reza");
            driverDao01.setPassword("pass2");
            driverDao01.setEmail("reza@gmail.com");
            driverDao01.setDateOfBirth(dateFormat.parse("2003-03-01"));
            driverDao01.setSignInStatus("signed in");
            driverDao01.setPhone("0903 333 3333");
            driverDao01.setRole(UserRole.valueOf("DRIVER"));
            driverDao01.setFullName("Reza Gasemi");

            driverDao01.setVehicleType(VehicleType.valueOf("SEDAN"));
            driverDao01.setVehicleModel("khoob");
            driverDao01.setVehicleColor("meshki");
            driverDao01.setVehicleLicensePlateNumber("A2017");
            driverDao01.setVehicleLicenseExpireDate(dateFormat.parse("2023-10-01"));
            driverDao01.setVehicleLicenseState("valid");

            driverDao01.setLicenseNumber("10203050");
            driverDao01.setLicenseExpireDate(dateFormat.parse("2025-02-01"));
            driverDao01.setLicenseState(LicenseState.valueOf("VALID"));

            driverDao01.setInsuranceDetail("ok");
            driverDao01.setRating(3.5);
            driverDao01.setAvailable(AvailabilityStatus.valueOf("AVAILABLE"));
            driverRepository.save(driverDao01);
            logger.info("driver inserted");

            driverDao01 = new DriverDao();
            driverDao01.setUsername("mehdi");
            driverDao01.setPassword("pass3");
            driverDao01.setEmail("mehdi@gmail.com");
            driverDao01.setDateOfBirth(dateFormat.parse("2003-01-01"));
            driverDao01.setSignInStatus("signed out");
            driverDao01.setPhone("0904 444 4444");
            driverDao01.setRole(UserRole.valueOf("DRIVER"));
            driverDao01.setFullName("Mehdi T");

            driverDao01.setVehicleType(VehicleType.valueOf("SEDAN"));
            driverDao01.setVehicleModel("khoob");
            driverDao01.setVehicleColor("meshki");
            driverDao01.setVehicleLicensePlateNumber("A2017");
            driverDao01.setVehicleLicenseExpireDate(dateFormat.parse("2023-10-01"));
            driverDao01.setVehicleLicenseState("valid");

            driverDao01.setLicenseNumber("10203040");
            driverDao01.setLicenseExpireDate(dateFormat.parse("2025-01-01"));
            driverDao01.setLicenseState(LicenseState.valueOf("VALID"));

            driverDao01.setInsuranceDetail("ok");
            driverDao01.setRating(4.5);
            driverDao01.setAvailable(AvailabilityStatus.valueOf("AVAILABLE"));
            driverRepository.save(driverDao01);
            logger.info("driver inserted");


            PassengerDao passengerDao = new PassengerDao();

            passengerDao.setUsername("jeff");
            passengerDao.setPassword("pass7");
            passengerDao.setEmail("jeff@gmail.com");
            passengerDao.setDateOfBirth(dateFormat.parse("2005-01-01"));
            passengerDao.setSignInStatus("signed out");
            passengerDao.setPhone("0902 777 777");
            passengerDao.setRole(UserRole.valueOf("PASSENGER"));
            passengerDao.setFullName("Jeff Meff");

            passengerDao.setMembership(MembershipType.valueOf("GOLD"));
            passengerDao.setHomeAddress("Iran");
            passengerRepository.save(passengerDao);

        };
    }


}
