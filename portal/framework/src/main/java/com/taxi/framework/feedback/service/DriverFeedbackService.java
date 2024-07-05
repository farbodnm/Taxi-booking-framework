package com.taxi.framework.feedback.service;

import com.taxi.framework.feedback.dto.BaseDriverFeedbackDto;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackResponseDto;

public interface DriverFeedbackService<T extends BaseDriverFeedbackDto, Y extends BaseDriverFeedbackResponseDto> {
   Y saveFeedback(T dto);
    Y getFeedback(Long id);
    Y updateFeedback(Long id, T dto);
    void deleteFeedback(Long id);

}
