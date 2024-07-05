package com.taxi.framework.user.controller;

import com.taxi.framework.user.dto.BaseAnalyticReportDTO;
import com.taxi.framework.user.service.AnalyticReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractAnalyticReportController<T extends BaseAnalyticReportDTO> {

    protected final AnalyticReportService<T> analyticReportService;


    protected AbstractAnalyticReportController(AnalyticReportService<T> service) {
        this.analyticReportService = service;
    }


    @PostMapping("/getAnalyticReport")
    public ResponseEntity<T> getAnalyticReport(@RequestBody T dto) {
        return ResponseEntity.ok(analyticReportService.getAnalyticReport(dto));
    }

}
