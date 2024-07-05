package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractAnalyticReportController;
import com.taxi.framework.user.dto.BaseAnalyticReportDTO;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.user.dto.ExtendedAnalyticReportDTO;
import com.taxi.user.service.ExtendAnalyticReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class AnalyticReportImplement extends AbstractAnalyticReportController<ExtendedAnalyticReportDTO> {

    @Autowired
    private ExtendAnalyticReportServiceImpl extendAnalyticReportService;
    protected AnalyticReportImplement(ExtendAnalyticReportServiceImpl extendAnalyticReportService) {
        super(extendAnalyticReportService);
    }
}
