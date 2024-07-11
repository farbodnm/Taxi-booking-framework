package com.taxi.framework.user.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "drivers")
public class DriverDao extends UserDao {
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private String vehicleModel;
    private String vehicleColor;
    private String vehicleLicensePlateNumber;
    private Date vehicleLicenseExpireDate;
    private String vehicleLicenseState;

    private String licenseNumber;
    private Date licenseExpireDate;
    @Enumerated(EnumType.STRING)
    private LicenseState licenseState;

    private String insuranceDetail;

    private double rating;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus available;

    @Override
    public String toString() {
        return "DriverDao{" +
                "vehicleType='" + vehicleType + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", vehicleLicensePlateNumber='" + vehicleLicensePlateNumber + '\'' +
                ", vehicleLicenseExpireDate=" + vehicleLicenseExpireDate +
                ", vehicleLicenseState='" + vehicleLicenseState + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", licenseExpireDate=" + licenseExpireDate +
                ", licenseState='" + licenseState + '\'' +
                ", insuranceDetail='" + insuranceDetail + '\'' +
                ", rating=" + rating +
                ", available='" + available + '\'' +
                '}';
    }


}
