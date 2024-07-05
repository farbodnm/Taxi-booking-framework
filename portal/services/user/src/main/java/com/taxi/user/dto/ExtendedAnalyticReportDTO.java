package com.taxi.user.dto;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.user.dto.BaseAnalyticReportDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ExtendedAnalyticReportDTO extends BaseAnalyticReportDTO {
    private int totalAdvertisementIncome;
    private float advertiseCTR;
}