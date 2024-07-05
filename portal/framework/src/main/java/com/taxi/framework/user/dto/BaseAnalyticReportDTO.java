package com.taxi.framework.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseAnalyticReportDTO {

    private int totalPassengersPerDay;
    private int totalTripsPerDay;
    private int totalCanceledTripsPerDay;
    private int totalActiveDriversPerDay;
    private int totalProfitPerDay;


}