package com.taxi.mapservice.controller;

import com.taxi.framework.mapService.controller.AbstractMappingController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/directions")
public class MappingController extends AbstractMappingController {
    // No additional code needed here, inherits functionality from AbstractMappingController
}
