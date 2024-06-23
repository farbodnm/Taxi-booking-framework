package com.taxi.feedback.controller;

import com.taxi.feedback.service.FeedbackServiceImpl;
import com.taxi.framework.booking.controller.AbstractBookingController;
import com.taxi.framework.feedback.controller.AbstractFeedbackController;
import com.taxi.framework.feedback.dto.BaseFeedbackDTO;
import com.taxi.framework.feedback.dto.BaseFeedbackResponseDTO;
import com.taxi.framework.feedback.service.AbstractFeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/feedback")
@RestController
public class FeedbackControllerImpl extends AbstractFeedbackController<BaseFeedbackDTO, BaseFeedbackResponseDTO> {
    private FeedbackServiceImpl feedbackService;
    @Autowired
    protected FeedbackControllerImpl(FeedbackServiceImpl feedbackService) {
        super(feedbackService);
    }
}
