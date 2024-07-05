package com.taxi.user.service;

import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.user.dto.ExtendedAnalyticReportDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("GetAnalyticReport")
public class ExtendAnalyticReportServiceImpl implements ExtendAnalyticReportService {
    @Override
    public ExtendedAnalyticReportDTO getAnalyticReport(ExtendedAnalyticReportDTO dto) {
        return dto;
    }
}
