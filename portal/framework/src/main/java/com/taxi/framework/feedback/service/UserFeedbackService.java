package com.taxi.framework.feedback.service;

import com.taxi.framework.feedback.dto.BaseUserFeedbackDto;
import com.taxi.framework.feedback.dto.BaseUserFeedbackResponseDto;

public interface UserFeedbackService<T extends BaseUserFeedbackDto, Y extends BaseUserFeedbackResponseDto> {
    Y saveFeedback(T dto);
    Y getFeedback(Long id);
    Y updateFeedback(Long id, T dto);
    void deleteFeedback(Long id);
}
