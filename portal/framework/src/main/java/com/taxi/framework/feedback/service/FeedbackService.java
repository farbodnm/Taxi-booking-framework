package com.taxi.framework.feedback.service;

import com.taxi.framework.feedback.dto.BaseFeedbackDTO;
import com.taxi.framework.feedback.dto.BaseFeedbackResponseDTO;

public interface FeedbackService <T extends BaseFeedbackDTO, Y extends BaseFeedbackResponseDTO> {
   Y saveFeedback(T dto);
    Y getFeedback(Long id);
    Y updateFeedback(Long id, T dto);
    void deleteFeedback(Long id);

}
