package com.taxi.framework.feedback.service;

import com.taxi.framework.feedback.dto.BaseDriverFeedbackDto;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackResponseDto;

import java.math.BigDecimal;
import java.util.Optional;

public interface DriverFeedbackService<T extends BaseDriverFeedbackDto, Y extends BaseDriverFeedbackResponseDto> {
   Y saveFeedback(T dto);
    Optional<BigDecimal> getAverageRating(Long userId);

}
