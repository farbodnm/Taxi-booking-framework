package com.taxi.framework.user.service;

import com.taxi.framework.user.dto.BaseAnalyticReportDTO;
import com.taxi.framework.user.dto.BaseUserSignupDTO;

public interface AnalyticReportService<T extends BaseAnalyticReportDTO>{
    T getAnalyticReport(T dto);

}
