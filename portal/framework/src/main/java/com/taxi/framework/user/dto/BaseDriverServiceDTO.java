package com.taxi.framework.user.dto;

import com.taxi.framework.user.dao.LicenseState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class BaseDriverServiceDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullName;

    private String vehicleType;
    private String vehicleModel;
    private String vehicleColor;
    private String vehicleLicensePlateNumber;
    private Date vehicleLicenseExpireDate;

    private String licenseNumber;
    private Date licenseExpireDate;
    private String licenseState;

    private String insuranceDetail;

    private double rating;

    private String available;
}
