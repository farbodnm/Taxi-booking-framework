package com.taxi.framework.feedback.service;

import com.taxi.framework.feedback.dto.BaseUserFeedbackDto;
import com.taxi.framework.feedback.dto.BaseUserFeedbackResponseDto;
import com.taxi.framework.utils.Utilities;

public abstract class AbstractUserFeedbackServiceImpl<B extends BaseUserFeedbackDto, R extends BaseUserFeedbackResponseDto> implements UserFeedbackService<B, R> {

    @Override
    public R saveFeedback(B dto) {
        R baseFeedbackResponseDTO = createFeedbackResponseDTO();
        baseFeedbackResponseDTO.setId(1L);
        baseFeedbackResponseDTO.setFeedbackGiverDriverId(dto.getFeedbackGiverDriverId());
        baseFeedbackResponseDTO.setFeedbackReceiverUserId(dto.getFeedbackReceiverUserId());
        baseFeedbackResponseDTO.setRating(dto.getRating());
        baseFeedbackResponseDTO.setComments(dto.getComments());
        baseFeedbackResponseDTO.setCreatedAt(Utilities.getCurrentDateTime());
        return baseFeedbackResponseDTO;
    }

    public abstract R createFeedbackResponseDTO();
}
