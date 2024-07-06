package com.taxi.framework.feedback.service;

import com.taxi.framework.feedback.dto.BaseUserFeedbackDto;
import com.taxi.framework.feedback.dto.BaseUserFeedbackResponseDto;

import java.math.BigDecimal;
import java.util.Optional;

public interface UserFeedbackService<T extends BaseUserFeedbackDto, Y extends BaseUserFeedbackResponseDto> {
    Y saveFeedback(T dto);
    Optional<BigDecimal> getAverageRating(Long userId);
}
