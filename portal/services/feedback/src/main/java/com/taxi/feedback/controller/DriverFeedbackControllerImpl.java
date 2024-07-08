package com.taxi.feedback.controller;

import com.taxi.feedback.service.DriverFeedbackServiceImpl;
import com.taxi.framework.feedback.controller.AbstractDriverFeedbackController;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackDto;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/driver-feedback")
@RestController
public class DriverFeedbackControllerImpl extends AbstractDriverFeedbackController<BaseDriverFeedbackDto, BaseDriverFeedbackResponseDto> {
    private DriverFeedbackServiceImpl feedbackService;
    @Autowired
    protected DriverFeedbackControllerImpl(DriverFeedbackServiceImpl feedbackService) {
        super(feedbackService);
        this.feedbackService = feedbackService;
    }
}
