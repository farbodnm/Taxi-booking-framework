package com.taxi.feedback.service;

import com.taxi.framework.feedback.dto.BaseFeedbackDTO;
import com.taxi.framework.feedback.dto.BaseFeedbackResponseDTO;
import com.taxi.framework.feedback.service.AbstractFeedbackServiceImpl;
import com.taxi.framework.feedback.service.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl extends AbstractFeedbackServiceImpl<BaseFeedbackDTO, BaseFeedbackResponseDTO> {

    protected BaseFeedbackResponseDTO createBookedRequestDTO() {
        return new BaseFeedbackResponseDTO();
    }
}
